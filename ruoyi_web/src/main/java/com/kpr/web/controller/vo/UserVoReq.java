package com.kpr.web.controller.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户请求信息
 * @author admin
 */
@Data
public class UserVoReq {

    /**
     * 用户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 微信昵称
     */
    private String  name;
    /**
     * 微信头像
     */
    private String  img;
    /**
     * 微信用户唯一标识
     */
    private String  openid;
    /**
     * 用户余额
     */
    private BigDecimal amount;
    /**
     * 手机号码
     */
    private String  phoneNumber;
    /**
     * 支付密码
     */
    private String  payPassword;
    /**
     * 是否删除1删除0未删除
     */
    private Integer isDelete;

    /**
     * 微信登录code
     */
    private String wxCode;

}
