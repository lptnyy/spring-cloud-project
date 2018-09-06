package com.wzy.order.web.controller;

import com.wzy.order.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderWebController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "测试订单接口", notes = "测试订单的web接口")
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public String getOrder(){
        return orderService.getOrder();
    }
}
