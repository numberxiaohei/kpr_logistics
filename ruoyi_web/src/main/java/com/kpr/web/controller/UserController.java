package com.kpr.web.controller;


import com.kpr.web.service.SysRegisterService;
import com.kpr.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 万先生
 * @version 1.0
 * Create by 2024/3/5 22:58
 */
@RestController
@RequestMapping("/api")
public class UserController extends BaseController{

    @Autowired
    UserService userService;


    @Autowired
    SysRegisterService sysRegisterService;





}
