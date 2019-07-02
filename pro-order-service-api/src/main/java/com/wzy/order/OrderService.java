package com.wzy.order;

import com.wzy.order.hystrix.OrderServiceHystrix;
import com.wzy.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-service", fallback = OrderServiceHystrix.class)
public interface OrderService {

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping(path = "/addOrder", method=RequestMethod.POST)
    public int addOrder(@RequestBody Order order) throws Exception;
}
