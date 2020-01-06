package com.wzy.user.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.user.ProUser;
import com.wzy.user.UserService;
import com.wzy.user.parameter.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public ServiceResponse<ProUser> userNameGetUser(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getPageList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> findIdsList(ProParameter<Integer> proParameter) {
        return ServiceResponse.getFAIL();
    }
}
