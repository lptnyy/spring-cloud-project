package com.wzy.system.controller;
import com.wzy.common.annotation.Log;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProMenuService;
import com.wzy.system.IProRoleMenuService;
import com.wzy.system.IProUserRoleService;
import com.wzy.system.dto.ProMenu;
import com.wzy.system.dto.ProRoleMenu;
import com.wzy.system.dto.ProUserRole;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.request.ProRoleMenuRequest;
import com.wzy.system.request.ProUserRoleRequest;
import com.wzy.system.vo.Menu;
import com.wzy.system.vo.MenuMeta;
import com.wzy.system.vo.ProMenuVo;
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

@RestController
@RequestMapping(value = "menu")
@Api(value = "MenuController", description = "菜单")
public class MenuController {

    @Autowired
    IProMenuService proMenuService;

    @Autowired
    RedisService redisService;

    @Autowired
    IProUserRoleService proUserRoleService;

    @Autowired
    IProRoleMenuService proRoleMenuService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "菜单", value = "分页查询列表", source = "admin-app")
    public ServiceResponse<List<ProMenuVo>> getPageList(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<List<ProMenuVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProMenu>> response = proMenuService.getList(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

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
                                menuVo.setTitle(menuVo.getTitle());
                                menuVo.setExpand(false);

                                // 筛选出子节点
                                List<ProMenuVo> childs = resultList.stream()
                                        .filter(child -> child.getParentId().equals(proMenu.getMenuId()))
                                        .map(child -> {
                                            ProMenuVo childVo = new ProMenuVo();
                                            BeanUtils.copyProperties(child,childVo);
                                            childVo.setTitle(childVo.getTitle());
                                            childVo.setExpand(false);

                                            // 获得三级 功能列表
                                            List<ProMenuVo> threeChilds = resultList.stream()
                                                    .filter(threeChild -> threeChild.getParentId().equals(childVo.getMenuId()))
                                                    .map(threeChild -> {
                                                        ProMenuVo threeChildVo = new ProMenuVo();
                                                        BeanUtils.copyProperties(threeChild,threeChildVo);
                                                        threeChildVo.setTitle(threeChildVo.getTitle());
                                                        threeChildVo.setExpand(false);
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
    @Log(name = "菜单", value = "获取单条信息", source = "admin-app")
    public ServiceResponse<ProMenuVo> get(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<ProMenuVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMenu> response = proMenuService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

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
    @GlobalTransactional
    @Log(name = "菜单", value = "保存", source = "admin-app")
    public ServiceResponse<ProMenuVo> save(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<ProMenuVo>()
                .run(serviceResponse -> {

                    // 封装查询参数
                    ProMenuRequest proMenuRequest = new ProMenuRequest();

                    proMenuRequest.setTitle(request.getTitle());

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMenu> response = proMenuService.get(new ProParameter<>(proMenuRequest));

                    // 获取调用服务状态
                    response.checkState();

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
    @GlobalTransactional
    @Log(name = "菜单", value = "批量删除", source = "admin-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过menuId
                    request.setMenuId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @GlobalTransactional
    @Log(name = "菜单", value = "删除", source = "admin-app")
    public ServiceResponse<Integer> delete(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @GlobalTransactional
    @Log(name = "菜单", value = "修改", source = "admin-app")
    public ServiceResponse<Integer> update(@RequestBody ProMenuRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMenuService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/getUserMenus")
    @ApiOperation(value = "获取登陆用户相关的设置的menu菜单")
    @Log(name = "菜单", value = "获取登陆用户相关的设置的menu菜单", source = "admin-app")
    public ServiceResponse<List<Menu>> getUserMenus(@RequestBody ProUserRoleRequest request) {
        return new ServiceResponse<List<Menu>>()
                .run(serviceResponse -> {

                    // 查询此用户下的所有权限
                    ServiceResponse<List<ProUserRole>> proRoleMenuResponse = proUserRoleService.getList(new ProParameter<>(request));

                    // 查看服务调用结果
                    proRoleMenuResponse.checkState();

                    // 获取返回结果
                    List<ProUserRole> proUserRoles = proRoleMenuResponse.getObj();

                    // 获取所有角色id
                    List<Integer> roleIds = proUserRoles.stream().map(ProUserRole::getRoleId).distinct().collect(Collectors.toList());

                    // 获取所有角色下menuid
                    ProRoleMenuRequest proRoleMenuRequest = new ProRoleMenuRequest();
                    proRoleMenuRequest.setRoleId(1); // ids 查询 随意添写 起到标记作用 ids  in roleid
                    proRoleMenuRequest.setIds(roleIds);

                    // 查询结果
                    ServiceResponse<List<ProRoleMenu>> response = proRoleMenuService.findIdsList(new ProParameter<>(proRoleMenuRequest));

                    // 验证服务是否调用成功
                    response.checkState();

                    // 查询所有菜单
                    List<Integer> menuIds = response.getObj()
                            .stream()
                            .map(ProRoleMenu::getMenuId)
                            .distinct()
                            .collect(Collectors.toList());

                    ProMenuRequest proMenuRequest = new ProMenuRequest();
                    proMenuRequest.setMenuId(1);
                    proMenuRequest.setIds(menuIds);
                    ServiceResponse<List<ProMenu>> proMyMeunResponse = proMenuService.findIdsList(new ProParameter<>(proMenuRequest));

                    // 验证服务是否调用成功
                    proMyMeunResponse.checkState();


                    // 获取服务返回的结果
                    List<ProMenu> resultList = proMyMeunResponse.getObj();

                    // 筛选处根目录
                    List<ProMenu> rootMenuList = resultList.stream()
                            .filter(proMenu -> proMenu.getParentId().equals(0))
                            .collect(Collectors.toList());

                    // 拼接菜单
                    List<Menu> menus = rootMenuList.stream()
                            .map(proMenu -> {
                        Menu menu = new Menu();
                        MenuMeta menuMeta = new MenuMeta();
                        menuMeta.setIcon(proMenu.getIcon());
                        menuMeta.setTitle(proMenu.getTitle());
                        menu.setName(proMenu.getName());
                        menu.setType(proMenu.getType());
                        menu.setPath(proMenu.getPath());
                        menu.setMeta(menuMeta);

                        // 查找子菜单
                        menu.setChildren(
                                resultList.stream().filter(proMenu1 -> proMenu1.getParentId().equals(proMenu.getMenuId()))
                                .map(proMenu1 -> {
                                    Menu childMenu = new Menu();
                                    if (proMenu1.getType().equals("3")) {
                                        MenuMeta childMenuMeta = new MenuMeta();
                                        childMenuMeta.setIcon(proMenu1.getIcon());
                                        childMenuMeta.setTitle(proMenu1.getTitle());
                                        childMenuMeta.setHref(proMenu1.getPath());
                                        childMenu.setName(proMenu1.getName());
                                        childMenu.setType(proMenu1.getType());
                                        childMenu.setPath("");
                                        childMenu.setMeta(childMenuMeta);
                                    } else {
                                        MenuMeta childMenuMeta = new MenuMeta();
                                        childMenuMeta.setIcon(proMenu1.getIcon());
                                        childMenuMeta.setTitle(proMenu1.getTitle());
                                        childMenu.setName(proMenu1.getName());
                                        childMenu.setType(proMenu1.getType());
                                        childMenu.setPath(proMenu1.getPath());
                                        childMenu.setMeta(childMenuMeta);
                                    }
                                    return childMenu;
                                }).collect(Collectors.toList())
                        );
                        return menu;
                    }).collect(Collectors.toList());
                    return menus;
                })
                .exec();
    }
}
