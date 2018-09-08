package com.wzy.user;

import com.wzy.user.hystrix.UserServiceHystrix;
import com.wzy.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user-service", fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi();

    @RequestMapping(path = "/getlist", method = RequestMethod.GET)
    public List<User> getUserList();
}
