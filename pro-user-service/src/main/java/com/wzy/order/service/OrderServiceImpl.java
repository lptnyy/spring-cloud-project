package com.wzy.order.service;

import com.wzy.order.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements OrderService{
    @Override
    public String getOrder() {
        return "ok";
    }
}
