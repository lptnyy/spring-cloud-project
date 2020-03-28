package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.DateUtil;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProUserRoleService;
import com.wzy.system.UserService;
import com.wzy.system.dto.ProUser;
import com.wzy.system.dto.ProUserRole;
import com.wzy.system.request.ProUserRoleRequest;
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
import java.util.ArrayList;
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

    @Autowired
    IProUserRoleService proUserRoleService;

    @PostMapping(value = "/userPageList")
    @ApiOperation(value = "分页查询管理员列表")
    public ServiceResponse<List<UserVo>> getUsers(@RequestBody User user){
        return new ServiceResponse<List<UserVo>>()
                .run(serviceResponse -> {

                    // 获取结果
                    ServiceResponse<List<ProUser>> response = userService.getPageList(new ProParameter<User>(user))
                            .copyPage(serviceResponse);

                    // 验证请求状态
                    response.checkState();

                    if (response.getObj().size() > 0) {

                        // 过滤取得userId数组
                        List<Integer> userIds = response.getObj().stream()
                                .map(proUser -> proUser.getUserId())
                                .distinct()
                                .collect(Collectors.toList());
                        ProUserRoleRequest proUserRoleRequest = new ProUserRoleRequest();
                        proUserRoleRequest.setIds(userIds);

                        // 通过in查询
                        ServiceResponse<List<ProUserRole>> proUserRoleServiceResponse = proUserRoleService.findIdsList(new ProParameter<>(proUserRoleRequest));
                        proUserRoleServiceResponse.checkState();

                        // 拼装数据
                        List<ProUser> proUsers = response.getObj();
                        List<UserVo> userVos = proUsers.stream()
                                .map(proUser -> {
                                    UserVo userVo = new UserVo();
                                    BeanUtils.copyProperties(proUser,userVo);
                                    userVo.setLastLoginTime(DateUtil.getyyMMddHHmmss(proUser.getLastLoginTime()));
                                    userVo.setCreateTime(DateUtil.getyyMMddHHmmss(proUser.getCreateTime()));
                                    Integer[] ids = proUserRoleServiceResponse.getObj()
                                            .stream()
                                            .filter(proUserRole -> proUserRole.getUserId().equals(proUser.getUserId()))
                                            .map(proUserRole -> proUserRole.getRoleId())
                                            .distinct()
                                            .toArray(Integer[]::new);
                                    userVo.setIds(ids);
                                    return userVo;
                                }).collect(Collectors.toList());
                        return userVos;
                    }
                    return new ArrayList<>();
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

    @PostMapping(value = "/save")
    @ApiOperation(value = "添加用户")
    public ServiceResponse<Integer> save(@RequestBody User user){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    User userPro = new User();
                    userPro.setUserName(user.getUserName());
                    ServiceResponse<ProUser> response = userService.userNameGetUser(new ProParameter<>(userPro));
                    if (response.getObj() != null) {
                        serviceResponse.setCode(500);
                        serviceResponse.setMsg("此账号已经存在");
                        return -1;
                    }
                    ServiceResponse<Integer> saveResponse = userService.save(new ProParameter<User>(user));
                    saveResponse.copyState(serviceResponse);
                    return saveResponse.getObj();
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
