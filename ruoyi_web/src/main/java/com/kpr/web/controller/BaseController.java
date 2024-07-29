package com.kpr.web.controller;


import com.kpr.web.mapper.UserMapper;
import com.kpr.web.utils.SecurityUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.kpr.web.controller.vo.LoginUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * web-api层 数据处理
 *
 * @author lxk
 */
public class BaseController {

    @Autowired
    protected UserMapper userMapper;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功
     */
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(Object data) {
        return AjaxResult.success(data);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }

    /**
     * 返回警告消息
     */
    public AjaxResult warn(String message) {
        return AjaxResult.warn(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result) {
        return result ? success() : error();
    }


    /**
     * 获取用户缓存信息
     */
    public LoginUserVo getLoginUser() {
        return SecurityUtils.getLoginUser();
    }

    /**
     * 获取登录用户id
     */
    public Long getUserId() {
        return getLoginUser().getUserId();
    }


    /**
     * 获取登录用户名
     */
    public String getPhone() {
        return getLoginUser().getUsername();
    }


}
