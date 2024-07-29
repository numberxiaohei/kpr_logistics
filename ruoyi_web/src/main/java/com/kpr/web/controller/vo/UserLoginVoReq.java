package com.kpr.web.controller.vo;

import lombok.Data;

/**
 * 用户登录对象
 *
 * @author xw
 */
@Data
public class UserLoginVoReq {

  /**
   * 账号
   */
  private String phone;

  /**
   * 密码
   */
  private String passWord;

}
