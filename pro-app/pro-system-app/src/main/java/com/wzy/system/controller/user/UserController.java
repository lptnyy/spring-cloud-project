package com.wzy.system.controller.user;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.DateUtil;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.UserService;
import com.wzy.system.dto.ProUser;
import com.wzy.system.request.User;
import com.wzy.system.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "user")
@Api(value = "管理员操作接口")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/userPageList")
    @ApiOperation(value = "分页查询管理员列表")
    public ServiceResponse<List<ProUser>> getUsers(@RequestBody User user){
        return new ServiceResponse<List<UserVo>>()
                .run(serviceResponse -> {
                    return userService.getPageList(
                            new ProParameter<User>(user)) // 传参数
                            .copyPage(serviceResponse) // 拷贝分页信息
                            .getObj() // 获取服务返回的数据
                            .stream()
                            .map(data -> {
                                // 将原始数据转换成页面显示的特定格式数据
                                UserVo userVo = new UserVo();
                                BeanUtils.copyProperties(data,userVo);
                                userVo.setCreateTime(DateUtil.getyyMMddHHmmss(data.getCreateTime()));
                                userVo.setLastLoginTime(DateUtil.getyyMMddHHmmss(data.getLastLoginTime()));
                                return userVo;
                            })
                            .collect(Collectors.toList());

                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除用户")
    public ServiceResponse<Integer> delete(@RequestBody User user){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    return userService.delete(new ProParameter<User>(user)).getObj();
                })
                .exec();
    }

    @PostMapping(value = "/updateStats")
    @ApiOperation(value = "修改用户状态")
    public ServiceResponse<Integer> updateStats(@RequestBody User user){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    return userService.update(new ProParameter<User>(user)).getObj();
                })
                .exec();
    }
}
