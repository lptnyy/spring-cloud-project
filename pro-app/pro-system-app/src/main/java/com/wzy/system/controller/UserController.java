package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.page.RequestPage;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.user.ProUser;
import com.wzy.redis.RedisService;
import com.wzy.system.UserService;
import com.wzy.system.parameter.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/userPageList")
    public ServiceResponse<List<ProUser>> getUsers(RequestPage requestPage){
        User user = new User();
        return userService.getPageList(new ProParameter<User>()
                .setObj(user)
                .setRequestPage(requestPage));
    }
}
