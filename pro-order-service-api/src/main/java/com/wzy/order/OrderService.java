package com.wzy.order;

import com.wzy.order.hystrix.OrderServiceHystrix;
import com.wzy.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order-service", fallback = OrderServiceHystrix.class)
public interface OrderService {
    // 添加订单信息
    public int addOrder(Order order);
}
