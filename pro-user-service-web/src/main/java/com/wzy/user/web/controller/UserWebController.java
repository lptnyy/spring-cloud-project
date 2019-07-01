package com.wzy.user.web.controller;

import com.alibaba.fastjson.JSON;
import com.wzy.redis.RedisService;
import com.wzy.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWebController {

       @Autowired
    UserService userService;

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(UserWebController.class);

    @ApiOperation(value = "测试订单接口", notes = "测试订单的web接口")
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String getOrder() {
        logger.info("调用成功了");
        return userService.hi();
    }
}
