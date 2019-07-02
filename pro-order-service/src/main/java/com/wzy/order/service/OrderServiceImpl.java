package com.wzy.order.service;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.wzy.mapper.OrderMapper;
import com.wzy.order.OrderService;
import com.wzy.pojo.Order;
import com.wzy.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Api(value = "订单接口")
@RefreshScope
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Autowired
    RedisService redisService;

    @Override
    @ApiOperation(value = "测试订单信息", notes = "就是测试接口")
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public int addOrder(@RequestBody Order order) {
        int num = orderMapper.insert(order);
        if (true){
            throw new IllegalStateException("by exFlag");
        }
        return num;
    }
}
