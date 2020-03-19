package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProMenuService;
import com.wzy.system.dto.ProMenu;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.vo.ProMenuVo;
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
@RequestMapping(value = "menu")
@Api(value = "MenuController", description = "菜单")
public class MenuController {

    @Autowired
    IProMenuService proMenuService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    public ServiceResponse<List<ProMenuVo>> getPageList(@RequestBody ProMenuRequest request){
        return new ServiceResponse<List<ProMenuVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProMenu>> response = proMenuService.getList(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 获取服务返回的结果
                    List<ProMenu> resultList = response.getObj();

                    // 获取所有根节点
                    List<ProMenu> genTree = resultList.stream()
                            .filter(proMenu -> proMenu.getParentId() == 0)
                            .collect(Collectors.toList());

                    // 循环遍历查询根目录子节点
                    List<ProMenuVo> returnList = genTree.stream()
                            .map(proMenu -> {
                                ProMenuVo menuVo = new ProMenuVo();
                                BeanUtils.copyProperties(proMenu,menuVo);
                                menuVo.setTitle(menuVo.getName());
                                menuVo.setExpand(false);

                                // 筛选出子节点
                                List<ProMenuVo> childs = resultList.stream()
                                        .filter(child -> child.getParentId().equals(proMenu.getMenuId()))
                                        .map(child -> {
                                            ProMenuVo childVo = new ProMenuVo();
                                            BeanUtils.copyProperties(child,childVo);
                                            childVo.setTitle(childVo.getName());
                                            childVo.setExpand(true);

                                            // 获得三级 功能列表
                                            List<ProMenuVo> threeChilds = resultList.stream()
                                                    .filter(threeChild -> threeChild.getParentId().equals(childVo.getMenuId()))
                                                    .map(threeChild -> {
                                                        ProMenuVo threeChildVo = new ProMenuVo();
                                                        BeanUtils.copyProperties(threeChild,threeChildVo);
                                                        threeChildVo.setTitle(threeChildVo.getName());
                                                        threeChildVo.setExpand(true);
                                                        return threeChildVo;
                                                    })
                                                    .collect(Collectors.toList());

                                            childVo.setChildren(threeChilds);
                                            return childVo;
                                        }).collect(Collectors.toList());

                                // 存放子节点信息
                                menuVo.setChildren(childs);

                                return menuVo;
                            }).collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    public ServiceResponse<ProMenuVo> get(@RequestBody ProMenuRequest request){
        return new ServiceResponse<ProMenuVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMenu> response = proMenuService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 组装返回的vo
                    ProMenu proMenu = response.getObj();
                    ProMenuVo proMenuVo = new ProMenuVo();
                    BeanUtils.copyProperties(proMenu,proMenuVo);
                    return proMenuVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    public ServiceResponse<ProMenuVo> save(@RequestBody ProMenuRequest request){
        return new ServiceResponse<ProMenuVo>()
                .run(serviceResponse -> {

                    // 封装查询参数
                    ProMenuRequest proMenuRequest = new ProMenuRequest();

                    proMenuRequest.setName(request.getName());

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMenu> response = proMenuService.get(new ProParameter<>(proMenuRequest));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 判断结果
                    if(response.getObj() != null) {
                        serviceResponse.setCode(500);
                        serviceResponse.setMsg("菜单已存在");
                        return null;
                    }
                    ProMenu proMenu = proMenuService.save(new ProParameter<>(request)).getObj();
                    ProMenuVo proMenuVo = new ProMenuVo();
                    BeanUtils.copyProperties(proMenu,proMenuVo);
                    return proMenuVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProMenuRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    public ServiceResponse<Integer> delete(@RequestBody ProMenuRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    public ServiceResponse<Integer> update(@RequestBody ProMenuRequest request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }
}
