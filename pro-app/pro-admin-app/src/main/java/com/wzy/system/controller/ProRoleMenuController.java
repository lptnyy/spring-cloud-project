package com.wzy.system.controller;
import com.wzy.common.annotation.Log;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProRoleMenuService;
import com.wzy.system.dto.ProRoleMenu;
import com.wzy.system.request.ProRoleMenuRequest;
import com.wzy.system.vo.ProRoleMenuVo;
import io.seata.spring.annotation.GlobalTransactional;
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
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@RestController
@RequestMapping(value = "proRoleMenu")
@Api(value = "ProRoleMenuController", description = "角色菜单关系表")
public class ProRoleMenuController {

    @Autowired
    IProRoleMenuService proRoleMenuService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "角色菜单关系表", value = "分页查询列表", source = "admin-app")
    public ServiceResponse<List<ProRoleMenuVo>> getPageList(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<List<ProRoleMenuVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProRoleMenu>> response = proRoleMenuService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 获取服务返回的结果
                    List<ProRoleMenu> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProRoleMenuVo> returnList = resultList.stream()
                            .map(proRoleMenu -> {
                                ProRoleMenuVo proRoleMenuvo = new ProRoleMenuVo();
                                BeanUtils.copyProperties(proRoleMenu,proRoleMenuvo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proRoleMenuvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "角色菜单关系表", value = "获取单条信息", source = "admin-app")
    public ServiceResponse<ProRoleMenuVo> get(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<ProRoleMenuVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProRoleMenu> response = proRoleMenuService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 组装返回的vo
                    ProRoleMenu proRoleMenu = response.getObj();
                    ProRoleMenuVo proRoleMenuVo = new ProRoleMenuVo();
                    BeanUtils.copyProperties(proRoleMenu,proRoleMenuVo);
                    return proRoleMenuVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @Log(name = "角色菜单关系表", value = "保存", source = "admin-app")
    @GlobalTransactional
    public ServiceResponse<Integer> save(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 删原角色权限信息
                    ServiceResponse<Integer> response = proRoleMenuService.delete(new ProParameter<>(request));
                    response.checkState();

                    // 获取返回结果 包括数据库插入id
                    List<ProRoleMenuRequest> roleMenuRequests = request.getIds().stream()
                            .map(id -> {
                                ProRoleMenuRequest proRoleMenuRequest = new ProRoleMenuRequest();
                                proRoleMenuRequest.setRoleId(request.getRoleId());
                                proRoleMenuRequest.setMenuId(id);
                                return proRoleMenuRequest;
                            }).collect(Collectors.toList());
                    ServiceResponse<Integer> proroleMenus = proRoleMenuService.batchSave(new ProParameter<List<ProRoleMenuRequest>>(roleMenuRequests));
                    proroleMenus.checkState();
                    return proroleMenus.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "角色菜单关系表", value = "批量删除", source = "admin-app")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleMenuService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "角色菜单关系表", value = "删除", source = "admin-app")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleMenuService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "角色菜单关系表", value = "修改", source = "admin-app")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProRoleMenuRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proRoleMenuService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }
}
