package com.wzy.order.web;

import com.wzy.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderWebCtl {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "/order/getlist")
    public String getOrder(){
        return orderService.getOrder();
    }
}
