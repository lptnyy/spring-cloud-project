package com.wzy.user;

import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.user.ProUser;
import com.wzy.user.hystrix.UserServiceHystrix;
import com.wzy.user.parameter.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "user-service", configuration = FeignRequestInterceptor.class,fallback = UserServiceHystrix.class)
public interface UserService {

    /*
     * 获得用户信息
     * @return
     */
    @RequestMapping(path = "/getUser", method = RequestMethod.POST)
    ServiceResponse<ProUser> userNameGetUser(@RequestBody ProParameter<User> proParameter);

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(path = "/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProUser>> getList(@RequestBody ProParameter<User> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/getPageList", method = RequestMethod.POST)
    ServiceResponse getPageList(@RequestBody ProParameter<User> proParameter);

    /**
     * 同多Id数组查询数据
     * @return
     */
    @RequestMapping(path = "/findIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProUser>> findIdsList(@RequestBody ProParameter<Integer> proParameter);
}
