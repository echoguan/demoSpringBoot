package com.echo.controller;

import com.echo.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by echo on 2017/7/16.
 */
@RestController
public class UserController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/")
    public String hello(){
        return configBean.getName() + configBean.getWant();
    }

}
