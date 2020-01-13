package com.wzy.user.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.mapper.user.ProUserMapper;
import com.wzy.pojo.user.ProUser;
import com.wzy.redis.RedisService;
import com.wzy.user.UserService;
import com.wzy.user.parameter.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "用户接口")
public class UserServiceImpl implements UserService {

    @Autowired
    RedisService redisService;

    @Resource
    ProUserMapper proUserMapper;

    @Override
    @ApiOperation(value = "获取用户信息", notes = "通过属性查询相对应的数据")
    public ServiceResponse<ProUser> userNameGetUser(ProParameter<User> proParameter) {
       return new ServiceResponse<ProUser>()
                .run((serviceResponse) -> {
                    return proUserMapper.selectOne(
                            new LambdaQueryWrapper<ProUser>()
                                    .eq(ProUser::getUserName,proParameter.getObj().getUserName()));
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> getList(ProParameter<User> proParameter) {
        return new ServiceResponse<List<ProUser>>()
                .run((serviceResponse) -> {
                    return proUserMapper.selectList(
                            new LambdaQueryWrapper<ProUser>()
                                    .eq(ProUser::getUserName,proParameter.getObj()));
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> getPageList(ProParameter<User> proParameter) {
        return new ServiceResponse<List<ProUser>>()
                .run((serviceResponse -> {
                   Page<ProUser> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                   IPage<ProUser> pageResult = proUserMapper.selectPage(page, new LambdaQueryWrapper<>());
                   serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                           .setPageSize(proParameter.getRequestPage().getPageSize())
                           .setCount(pageResult.getTotal())
                           .setPages(pageResult.getPages());
                   return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProUser>> findIdsList(ProParameter<Integer> proParameter) {
        return null;
    }
}
