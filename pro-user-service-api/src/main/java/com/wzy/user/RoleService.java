package com.wzy.user;

import com.wzy.user.hystrix.RoleServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service", fallback = RoleServiceHystrix.class)
public interface RoleService {

    @RequestMapping(path = "/run", method = RequestMethod.GET)
    public void run();
}
