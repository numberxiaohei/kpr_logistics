//package com.kpr.web.security;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.kpr.web.controller.vo.LoginUserVo;
//import com.kpr.web.mapper.UserMapper;
//import com.kpr.web.po.UserPo;
//import com.ruoyi.common.exception.ServiceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * 用户验证处理
// *
// * @author xw
// */
//@Service("userDetailsByPassword")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//  @Autowired
//  private UserMapper userMapper;
//
//  @Override
//  public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
//      UserPo userPo = userMapper.selectOne(new LambdaQueryWrapper<UserPo>().eq(UserPo::getPhoneNumber, phone));
//    if (userPo == null) {
//      throw new ServiceException("用户不存在,请重新登录！");
//    }
//    return createLoginUser(userPo);
//  }
//
//  public UserDetails createLoginUser(UserPo user) {
//    return new LoginUserVo(user.getId(), user);
//  }
//}
