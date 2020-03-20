package com.wzy.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.wzy.system.dto.ProRoleMenu;
import com.wzy.system.request.ProRoleMenuRequest;
import com.wzy.system.IProRoleMenuService;
import com.wzy.system.mapper.ProRoleMenuMapper;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-19
 */
@RestController
@Api(value = "ProRoleMenuServiceImpl", description = "角色菜单关系表")
public class ProRoleMenuServiceImpl implements IProRoleMenuService {

    @Resource
    ProRoleMenuMapper mapper;

    @Override
    public ServiceResponse<ProRoleMenu> get(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<ProRoleMenu>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> getList(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> getPageList(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    Page<ProRoleMenu> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProRoleMenu> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> findIdsList(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<List<ProRoleMenu>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.orderByDesc(ProRoleMenu::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProRoleMenu bean = new ProRoleMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<ProRoleMenu> save(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<ProRoleMenu>()
                .run(serviceResponse -> {
                    ProRoleMenu bean = new ProRoleMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProRoleMenu>> batchSave(ProParameter<List<ProRoleMenuRequest>> proParameter) {
       return new ServiceResponse<List<ProRoleMenu>>()
               .run(serviceResponse -> {
                   List<ProRoleMenu> roles = proParameter.getObj()
                       .stream()
                       .map(proRoleMenuRequest -> {
                            ProRoleMenu proRoleMenu = new ProRoleMenu();
                            BeanUtils.copyProperties(proRoleMenuRequest, proRoleMenu);
                            mapper.insert(proRoleMenu);
                            return proRoleMenu;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProRoleMenuRequest request = proParameter.getObj();
                    if(request.getRmId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRmId,request.getRmId());
                    }
                    if(request.getRoleId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getRoleId,request.getRoleId());
                    }
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getMenuId,request.getMenuId());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProRoleMenu::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProRoleMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProRoleMenuRequest request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}
