package com.wzy.user.web.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wzy.common.util.ServiceRun;
import com.wzy.order.OrderService;
import com.wzy.pojo.Order;
import com.wzy.user.RoleService;
import com.wzy.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    OrderService orderService;

    @LcnTransaction
    public String orderUpdate(){
        roleService.run();
        Order order = new Order();
        order.setId(1);
        order.setPrice(1);
        order.setStat(1);
        order.setCreatetime(new Date());
        // LCN 模式 调用外部服务有熔断方面的配置 需要在分布式事务开启方进行手动验证 抛出异常 不然分布式事务失效
        new ServiceRun()
                .run(()-> userService.updateUser())
                .run(()-> orderService.addOrder(order));
        return "";
    }
}
