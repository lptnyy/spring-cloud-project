package com.wzy.user.web.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
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
        int num = userService.updateUser();
        Order order = new Order();
        order.setId(1);
        order.setPrice(1);
        order.setStat(1);
        order.setCreatetime(new Date());
        num = orderService.addOrder(order);
        if (num == -1){
            throw new IllegalStateException("by exFlag");
        }
        return "";
    }
}
