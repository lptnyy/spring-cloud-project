package com.wzy.user.web.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wzy.common.util.ServiceRun;
import com.wzy.order.OrderService;
import com.wzy.pojo.Order;
import com.wzy.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebService {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @LcnTransaction
    public String orderUpdate(){
        Order order = new Order();
        order.setId(1);
        order.setPrice(1);
        order.setStat(1);
        order.setCreatetime(new Date());
        new ServiceRun()
                .run(()-> userService.updateUser())
                .run(()-> orderService.addOrder(order));
        return "";
    }
}
