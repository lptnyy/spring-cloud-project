package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProUserRoleService;
import com.wzy.system.dto.ProUserRole;
import com.wzy.system.request.ProUserRoleRequest;
import com.wzy.system.vo.ProUserRoleVo;
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

/**
 * <p>
    * 用户角色关系表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@RestController
@RequestMapping(value = "proUserRole")
@Api(value = "ProUserRoleController", description = "用户角色关系表 ")
public class ProUserRoleController {

    @Autowired
    IProUserRoleService proUserRoleService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    public ServiceResponse<List<ProUserRoleVo>> getPageList(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<List<ProUserRoleVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProUserRole>> response = proUserRoleService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProUserRole> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProUserRoleVo> returnList = resultList.stream()
                            .map(proUserRole -> {
                                ProUserRoleVo proUserRolevo = new ProUserRoleVo();
                                BeanUtils.copyProperties(proUserRole,proUserRolevo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proUserRolevo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    public ServiceResponse<ProUserRoleVo> get(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<ProUserRoleVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProUserRole> response = proUserRoleService.get(new ProParameter<>(request));
                    response.checkState();

                    // 组装返回的vo
                    ProUserRole proUserRole = response.getObj();
                    ProUserRoleVo proUserRoleVo = new ProUserRoleVo();
                    BeanUtils.copyProperties(proUserRole,proUserRoleVo);
                    return proUserRoleVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    public ServiceResponse<List<ProUserRole>> save(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<List<ProUserRole>>()
                .run(serviceResponse -> {

                    // 删除原始管理员角色信息
                    ProUserRoleRequest roleRequest = new ProUserRoleRequest();
                    roleRequest.setUserId(request.getUserId());

                    // 获取结果判断是否执行成功
                    ServiceResponse<Integer> response = proUserRoleService.delete(new ProParameter<>(request));

                    // 验证返回结果直接异常退出
                    response.checkState();

                    // 拼装数据
                    List<ProUserRoleRequest> saveRoleRquests = request.getIds()
                            .stream()
                            .map(roleId -> {
                                ProUserRoleRequest proUserRoleRequest = new ProUserRoleRequest();
                                proUserRoleRequest.setUserId(request.getUserId());
                                proUserRoleRequest.setRoleId(roleId);
                                return proUserRoleRequest;
                            }).collect(Collectors.toList());

                    // 保存数据
                    ServiceResponse<List<ProUserRole>> saveResponse = proUserRoleService.batchSave(new ProParameter<>(saveRoleRquests));

                    // 验证返回结果直接异常退出
                    saveResponse.checkState();

                    return saveResponse.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proUserRoleService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "批量删除")
    public ServiceResponse<Integer> delete(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proUserRoleService.delete(new ProParameter<>(request));

                    // 判断返回状态 异常退出
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    public ServiceResponse<Integer> update(@RequestBody ProUserRoleRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proUserRoleService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
