package com.wzy.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.wzy.system.dto.ProMenu;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.IProMenuService;
import com.wzy.system.mapper.ProMenuMapper;

/**
 * <p>
    * 菜单表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-12
 */
@RestController
@Api(value = "ProMenuServiceImpl", description = "菜单表 ")
public class ProMenuServiceImpl implements IProMenuService {

    @Resource
    ProMenuMapper mapper;

    @Override
    public ServiceResponse<ProMenu> get(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<ProMenu>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getTitle())){
                        lambdaQueryWrapper.eq(ProMenu::getTitle,request.getTitle());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
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
                    if(!StringUtils.isEmpty(request.getJurisdiction())){
                        lambdaQueryWrapper.eq(ProMenu::getJurisdiction,request.getJurisdiction());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMenu>> getList(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMenu>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getTitle())){
                        lambdaQueryWrapper.eq(ProMenu::getTitle,request.getTitle());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
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
                    if(!StringUtils.isEmpty(request.getJurisdiction())){
                        lambdaQueryWrapper.eq(ProMenu::getJurisdiction,request.getJurisdiction());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMenu>> getPageList(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMenu>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getTitle())){
                        lambdaQueryWrapper.eq(ProMenu::getTitle,request.getTitle());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
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
                    if(!StringUtils.isEmpty(request.getJurisdiction())){
                        lambdaQueryWrapper.eq(ProMenu::getJurisdiction,request.getJurisdiction());
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
    public ServiceResponse<List<ProMenu>> findIdsList(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMenu>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMenu> queryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        queryWrapper.in(ProMenu::getMenuId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getTitle())){
                        queryWrapper.in(ProMenu::getTitle,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        queryWrapper.in(ProMenu::getName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        queryWrapper.in(ProMenu::getPath,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        queryWrapper.in(ProMenu::getIcon,request.getIds());
                    }
                    if(request.getParentId() != null){
                        queryWrapper.in(ProMenu::getParentId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        queryWrapper.in(ProMenu::getType,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProMenu::getCreateTime,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getJurisdiction())){
                        queryWrapper.in(ProMenu::getJurisdiction,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProMenu::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMenu bean = new ProMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProMenu> save(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<ProMenu>()
                .run(serviceResponse -> {
                    ProMenu bean = new ProMenu();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProMenu>> batchSave(ProParameter<List<ProMenuRequest>> proParameter) throws Exception {
       return new ServiceResponse<List<ProMenu>>()
               .run(serviceResponse -> {
                   List<ProMenu> roles = proParameter.getObj()
                       .stream()
                       .map(proMenuRequest -> {
                            ProMenu proMenu = new ProMenu();
                            BeanUtils.copyProperties(proMenuRequest, proMenu);
                            mapper.insert(proMenu);
                            return proMenu;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMenuRequest request = proParameter.getObj();
                    if(request.getMenuId() != null){
                        lambdaQueryWrapper.eq(ProMenu::getMenuId,request.getMenuId());
                    }
                    if(!StringUtils.isEmpty(request.getTitle())){
                        lambdaQueryWrapper.eq(ProMenu::getTitle,request.getTitle());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMenu::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProMenu::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getIcon())){
                        lambdaQueryWrapper.eq(ProMenu::getIcon,request.getIcon());
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
                    if(!StringUtils.isEmpty(request.getJurisdiction())){
                        lambdaQueryWrapper.eq(ProMenu::getJurisdiction,request.getJurisdiction());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMenuRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProMenu> queryWrapper = new LambdaQueryWrapper<>();
                     ProMenuRequest request = proParameter.getObj();
                     if(request.getMenuId() != null){
                          queryWrapper.in(ProMenu::getMenuId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getTitle())){
                          queryWrapper.in(ProMenu::getTitle,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getName())){
                          queryWrapper.in(ProMenu::getName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPath())){
                          queryWrapper.in(ProMenu::getPath,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getIcon())){
                          queryWrapper.in(ProMenu::getIcon,request.getIds());
                     }
                     if(request.getParentId() != null){
                          queryWrapper.in(ProMenu::getParentId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getType())){
                          queryWrapper.in(ProMenu::getType,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProMenu::getCreateTime,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getJurisdiction())){
                          queryWrapper.in(ProMenu::getJurisdiction,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
