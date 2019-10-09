package com.wzy.user;

import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.User;
import com.wzy.user.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service", fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(path = "/hi", method = RequestMethod.POST)
    public ServiceResponse hi();

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping(path = "/updateUser", method = RequestMethod.POST)
    public ServiceResponse updateUser();

    /**
     * 获得用户信息
     * @param user
     * @return
     */
    @RequestMapping(path = "/getuser", method = RequestMethod.POST)
    public ServiceResponse userNameGetUser(@RequestBody User user);
}
