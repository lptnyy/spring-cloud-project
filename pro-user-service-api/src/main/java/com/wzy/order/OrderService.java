package com.wzy.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-service")
public interface OrderService {

    @RequestMapping(path = "/getOrder", method = RequestMethod.GET)
    public String getOrder();
}
