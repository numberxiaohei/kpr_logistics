package com.kpr.web.service.impl;


import com.kpr.web.service.TokenService;
import com.kpr.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 万先生
 * @version 1.0
 * Create by 2024/3/5 22:14
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;


}
