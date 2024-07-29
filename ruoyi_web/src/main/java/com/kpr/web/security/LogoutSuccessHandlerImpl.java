//package com.shop.web.security;
//
//import com.alibaba.fastjson2.JSON;
//import com.shop.web.controller.vo.LoginUserVo;
//import com.shop.web.service.TokenService;
//import com.xw.common.constant.Constants;
//import com.xw.common.core.domain.AjaxResult;
//import com.xw.common.utils.ServletUtils;
//import com.xw.common.utils.StringUtils;
//import com.xw.mall.controller.vo.LoginUserVo;
//import com.xw.mall.manager.AsyncManager;
//import com.xw.mall.manager.factory.AsyncFactory;
//import com.xw.mall.security.service.TokenService;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
///**
// * 自定义退出处理类 返回成功
// *
// * @author xw
// */
//@Configuration
//public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
//
//  @Autowired
//  private TokenService tokenService;
//
//  /**
//   * 退出处理
//   */
//  @Override
//  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//      throws IOException, ServletException {
//    LoginUserVo loginUser = tokenService.getLoginUser(request);
//    if (loginUser != null) {
//      String userName = loginUser.getUsername();
//      // 删除用户缓存记录
//      tokenService.delLoginUser(loginUser.getUserId() + "");
//      // 记录用户退出日志
//      AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
//    }
//    ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success("退出成功")));
//  }
//}
