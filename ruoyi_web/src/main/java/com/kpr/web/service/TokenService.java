package com.kpr.web.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kpr.web.controller.vo.LoginUserVo;
import com.kpr.web.mapper.UserMapper;
import com.kpr.web.po.UserPo;
import com.ruoyi.common.constant.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * token验证处理
 *
 * @author xw
 */
@Component
public class TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    @Autowired
    private UserMapper userMapper;

    public LoginUserVo getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (token != null) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            UserPo userPo = userMapper.selectOne(new LambdaQueryWrapper<UserPo>().eq(UserPo::getId, claims.get(Constants.LOGIN_USER_KEY)));
            if (userPo == null) {
                return null;
            }
            LoginUserVo  user = new LoginUserVo();
            user.setUserId(userPo.getId());
            return user;
        }
        return null;
    }


    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUserVo loginUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, loginUser.getUserId() + "");
        return createToken(claims);
    }


    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (token != null && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

//    /**
//     * 删除用户身份信息
//     */
//    public void delLoginUser(String token) {
//        if (token != null) {
//            String userKey = getTokenKey(token);
//            redisCache.deleteObject(userKey);
//        }
//    }

}
