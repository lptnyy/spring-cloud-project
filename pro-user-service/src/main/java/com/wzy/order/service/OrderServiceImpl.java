package com.wzy.order.service;

import com.wzy.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "订单接口")
public class OrderServiceImpl implements OrderService{

    @Override
    @ApiOperation(value = "测试订单信息", notes = "就是测试接口")
    public String hi() {
        return "2";
    }
}
