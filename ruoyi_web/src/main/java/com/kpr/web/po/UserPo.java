package com.kpr.web.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息实体类
 *
 * @author admin
 */
@Data
@TableName("kpr_user")
public class UserPo implements Serializable {

    /**
     * 用户id
     */
    @Id
    @Column(name = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户余额
     */
    @Column(name = "headImg")
    private BigDecimal head_img;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private BigDecimal createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

}
