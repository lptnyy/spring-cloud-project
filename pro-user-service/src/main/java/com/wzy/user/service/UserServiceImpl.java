package com.wzy.user.service;

import com.wzy.mapper.UserMapper;
import com.wzy.user.UserService;
import com.wzy.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "订单接口")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    @ApiOperation(value = "测试订单信息", notes = "就是测试接口")
    public String hi() {
        return "2";
    }

    @Override
    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息没有任何参数的")
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
