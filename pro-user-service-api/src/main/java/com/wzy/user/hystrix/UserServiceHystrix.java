package com.wzy.user.hystrix;

import com.wzy.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public String hi() {
        return "服务器已经禁用";
    }

    @Override
    public int updateUser() {
        return 0;
    }
}
