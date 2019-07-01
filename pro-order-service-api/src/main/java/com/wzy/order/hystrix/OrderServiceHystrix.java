package com.wzy.order.hystrix;

import com.wzy.order.OrderService;
import com.wzy.pojo.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceHystrix implements OrderService {

    @Override
    public int addOrder(Order order) {
        return 0;
    }
}