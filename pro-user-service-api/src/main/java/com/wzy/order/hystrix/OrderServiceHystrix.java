package com.wzy.order.hystrix;

import com.wzy.order.OrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceHystrix implements OrderService{

    @Override
    public String hi() {
        return "服务器已经禁用";
    }
}
