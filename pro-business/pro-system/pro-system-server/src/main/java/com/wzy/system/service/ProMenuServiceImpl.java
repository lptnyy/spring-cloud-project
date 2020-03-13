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
import com.wzy.system.dto.ProMenu;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.IProMenuService;
import com.wzy.system.mapper.ProMenuMapper;

@RestController
@Api(value = "菜单表 ")
public class ProMenuServiceImpl implements IProMenuService {

    @Resource
    ProMenuMapper mapper;

    @Override
    public ServiceResponse<ProMenu> get(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<ProMenu>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getUrl())){
                        lambdaQueryWrapper.eq(ProMenu::getUrl,request.getUrl());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(request.getParentId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getParentId,request.getParentId());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProMenu::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMenu>> getList(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<List<ProMenu>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getUrl())){
                        lambdaQueryWrapper.eq(ProMenu::getUrl,request.getUrl());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(request.getParentId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getParentId,request.getParentId());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProMenu::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMenu>> getPageList(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<List<ProMenu>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getUrl())){
                        lambdaQueryWrapper.eq(ProMenu::getUrl,request.getUrl());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(request.getParentId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getParentId,request.getParentId());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProMenu::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMenu::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMenu::getCreateTime);
                    Page<ProMenu> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProMenu> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProMenu>> findIdsList(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<List<ProMenu>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMenu> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMenu bean = new ProMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<ProMenu> save(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<ProMenu>()
                .run(serviceResponse -> {
                    ProMenu bean = new ProMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMenu bean = new ProMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.deleteById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMenuRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMenuRequest request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}
