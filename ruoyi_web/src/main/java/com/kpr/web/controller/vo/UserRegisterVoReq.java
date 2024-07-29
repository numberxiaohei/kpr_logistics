package com.kpr.web.controller.vo;

import lombok.Data;

/**
 * 用户注册对象
 *
 * @author ruoyi
 */
@Data
public class UserRegisterVoReq {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 送货地址
     */
    private String address;


    /**
     * 微信头像
     */
    private String img;


    private String refereeCode;
}
