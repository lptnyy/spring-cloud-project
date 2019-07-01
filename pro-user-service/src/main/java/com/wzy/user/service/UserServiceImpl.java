package com.wzy.user.service;

import com.wzy.mapper.UserMapper;
import com.wzy.redis.RedisService;
import com.wzy.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Api(value = "订单接口")
@RefreshScope
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Autowired
    RedisService redisService;

    @Override
    @ApiOperation(value = "测试订单信息", notes = "就是测试接口")
    public String hi() {
        redisService.set("hhha1", "haha");
        return redisService.get("hhha1");
    }
}
