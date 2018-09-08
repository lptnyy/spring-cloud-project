package com.wzy.user.hystrix;

import com.wzy.user.UserService;
import com.wzy.pojo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public String hi() {
        return "服务器已经禁用";
    }

    @Override
    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        return users;
    }
}
