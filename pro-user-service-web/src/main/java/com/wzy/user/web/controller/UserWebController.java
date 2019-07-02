package com.wzy.user.web.controller;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.wzy.user.web.service.WebService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWebController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(UserWebController.class);

    @Autowired
    WebService service;


    @ApiOperation(value = "测试订单接口", notes = "测试订单的web接口")
    @RequestMapping(value = "/update")
    public String updateOrder() {
        try{
            logger.info("order调用成功了");
            service.orderUpdate();
        } catch (Exception e){

        }
        return "ok";
    }
}
