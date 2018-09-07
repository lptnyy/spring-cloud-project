package com.wzy.order;

import com.wzy.order.hystrix.OrderServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-service", fallback = OrderServiceHystrix.class)
public interface OrderService {

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi();
}
