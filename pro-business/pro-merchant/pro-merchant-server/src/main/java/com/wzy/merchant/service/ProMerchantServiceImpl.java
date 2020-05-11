package com.wzy.merchant.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.wzy.merchant.dto.ProMerchant;
import com.wzy.merchant.request.ProMerchantRequest;
import com.wzy.merchant.IProMerchantService;
import com.wzy.merchant.mapper.ProMerchantMapper;

/**
 * <p>
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-11
 */
@RestController
@Api(value = "ProMerchantServiceImpl", description = "商户表")
public class ProMerchantServiceImpl implements IProMerchantService {

    @Resource
    ProMerchantMapper mapper;

    @Override
    public ServiceResponse<ProMerchant> get(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<ProMerchant>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMerchant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMerchantRequest request = proParameter.getObj();
                    if(request.getMerchantId() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMerchantId,request.getMerchantId());
                    }
                    if(!StringUtils.isEmpty(request.getAbbreviation())){
                        lambdaQueryWrapper.eq(ProMerchant::getAbbreviation,request.getAbbreviation());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMerchant::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMerchant::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getLogoUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getLogoUrl,request.getLogoUrl());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMerchant::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getQualification())){
                        lambdaQueryWrapper.eq(ProMerchant::getQualification,request.getQualification());
                    }
                    if(request.getMargin() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMargin,request.getMargin());
                    }
                    if(!StringUtils.isEmpty(request.getCollectMoney())){
                        lambdaQueryWrapper.eq(ProMerchant::getCollectMoney,request.getCollectMoney());
                    }
                    if(!StringUtils.isEmpty(request.getTel())){
                        lambdaQueryWrapper.eq(ProMerchant::getTel,request.getTel());
                    }
                    if(!StringUtils.isEmpty(request.getPhone())){
                        lambdaQueryWrapper.eq(ProMerchant::getPhone,request.getPhone());
                    }
                    if(!StringUtils.isEmpty(request.getEmail())){
                        lambdaQueryWrapper.eq(ProMerchant::getEmail,request.getEmail());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMerchant::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMerchant::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMerchant::getArea,request.getArea());
                    }
                    if(!StringUtils.isEmpty(request.getAddress())){
                        lambdaQueryWrapper.eq(ProMerchant::getAddress,request.getAddress());
                    }
                    if(!StringUtils.isEmpty(request.getQq())){
                        lambdaQueryWrapper.eq(ProMerchant::getQq,request.getQq());
                    }
                    if(!StringUtils.isEmpty(request.getHomeUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getHomeUrl,request.getHomeUrl());
                    }
                    if(request.getStat() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getStat,request.getStat());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMerchant::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMerchant>> getList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMerchant>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMerchant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMerchantRequest request = proParameter.getObj();
                    if(request.getMerchantId() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMerchantId,request.getMerchantId());
                    }
                    if(!StringUtils.isEmpty(request.getAbbreviation())){
                        lambdaQueryWrapper.eq(ProMerchant::getAbbreviation,request.getAbbreviation());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMerchant::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMerchant::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getLogoUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getLogoUrl,request.getLogoUrl());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMerchant::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getQualification())){
                        lambdaQueryWrapper.eq(ProMerchant::getQualification,request.getQualification());
                    }
                    if(request.getMargin() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMargin,request.getMargin());
                    }
                    if(!StringUtils.isEmpty(request.getCollectMoney())){
                        lambdaQueryWrapper.eq(ProMerchant::getCollectMoney,request.getCollectMoney());
                    }
                    if(!StringUtils.isEmpty(request.getTel())){
                        lambdaQueryWrapper.eq(ProMerchant::getTel,request.getTel());
                    }
                    if(!StringUtils.isEmpty(request.getPhone())){
                        lambdaQueryWrapper.eq(ProMerchant::getPhone,request.getPhone());
                    }
                    if(!StringUtils.isEmpty(request.getEmail())){
                        lambdaQueryWrapper.eq(ProMerchant::getEmail,request.getEmail());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMerchant::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMerchant::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMerchant::getArea,request.getArea());
                    }
                    if(!StringUtils.isEmpty(request.getAddress())){
                        lambdaQueryWrapper.eq(ProMerchant::getAddress,request.getAddress());
                    }
                    if(!StringUtils.isEmpty(request.getQq())){
                        lambdaQueryWrapper.eq(ProMerchant::getQq,request.getQq());
                    }
                    if(!StringUtils.isEmpty(request.getHomeUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getHomeUrl,request.getHomeUrl());
                    }
                    if(request.getStat() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getStat,request.getStat());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMerchant::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMerchant>> getPageList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMerchant>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProMerchant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMerchantRequest request = proParameter.getObj();
                    if(request.getMerchantId() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMerchantId,request.getMerchantId());
                    }
                    if(!StringUtils.isEmpty(request.getAbbreviation())){
                        lambdaQueryWrapper.eq(ProMerchant::getAbbreviation,request.getAbbreviation());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMerchant::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMerchant::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getLogoUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getLogoUrl,request.getLogoUrl());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMerchant::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getQualification())){
                        lambdaQueryWrapper.eq(ProMerchant::getQualification,request.getQualification());
                    }
                    if(request.getMargin() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMargin,request.getMargin());
                    }
                    if(!StringUtils.isEmpty(request.getCollectMoney())){
                        lambdaQueryWrapper.eq(ProMerchant::getCollectMoney,request.getCollectMoney());
                    }
                    if(!StringUtils.isEmpty(request.getTel())){
                        lambdaQueryWrapper.eq(ProMerchant::getTel,request.getTel());
                    }
                    if(!StringUtils.isEmpty(request.getPhone())){
                        lambdaQueryWrapper.eq(ProMerchant::getPhone,request.getPhone());
                    }
                    if(!StringUtils.isEmpty(request.getEmail())){
                        lambdaQueryWrapper.eq(ProMerchant::getEmail,request.getEmail());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMerchant::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMerchant::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMerchant::getArea,request.getArea());
                    }
                    if(!StringUtils.isEmpty(request.getAddress())){
                        lambdaQueryWrapper.eq(ProMerchant::getAddress,request.getAddress());
                    }
                    if(!StringUtils.isEmpty(request.getQq())){
                        lambdaQueryWrapper.eq(ProMerchant::getQq,request.getQq());
                    }
                    if(!StringUtils.isEmpty(request.getHomeUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getHomeUrl,request.getHomeUrl());
                    }
                    if(request.getStat() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getStat,request.getStat());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMerchant::getCreateTime);
                    Page<ProMerchant> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProMerchant> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProMerchant>> findIdsList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProMerchant>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMerchant> queryWrapper = new LambdaQueryWrapper<>();
                    ProMerchantRequest request = proParameter.getObj();
                    if(request.getMerchantId() != null){
                        queryWrapper.in(ProMerchant::getMerchantId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getAbbreviation())){
                        queryWrapper.in(ProMerchant::getAbbreviation,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        queryWrapper.in(ProMerchant::getUserName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        queryWrapper.in(ProMerchant::getPassWord,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getLogoUrl())){
                        queryWrapper.in(ProMerchant::getLogoUrl,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        queryWrapper.in(ProMerchant::getName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getQualification())){
                        queryWrapper.in(ProMerchant::getQualification,request.getIds());
                    }
                    if(request.getMargin() != null){
                        queryWrapper.in(ProMerchant::getMargin,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getCollectMoney())){
                        queryWrapper.in(ProMerchant::getCollectMoney,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getTel())){
                        queryWrapper.in(ProMerchant::getTel,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPhone())){
                        queryWrapper.in(ProMerchant::getPhone,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getEmail())){
                        queryWrapper.in(ProMerchant::getEmail,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        queryWrapper.in(ProMerchant::getProvince,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        queryWrapper.in(ProMerchant::getCity,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        queryWrapper.in(ProMerchant::getArea,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getAddress())){
                        queryWrapper.in(ProMerchant::getAddress,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getQq())){
                        queryWrapper.in(ProMerchant::getQq,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getHomeUrl())){
                        queryWrapper.in(ProMerchant::getHomeUrl,request.getIds());
                    }
                    if(request.getStat() != null){
                        queryWrapper.in(ProMerchant::getStat,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProMerchant::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProMerchant::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> update(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMerchant bean = new ProMerchant();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<ProMerchant> save(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<ProMerchant>()
                .run(serviceResponse -> {
                    ProMerchant bean = new ProMerchant();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<List<ProMerchant>> batchSave(ProParameter<List<ProMerchantRequest>> proParameter) throws Exception {
       return new ServiceResponse<List<ProMerchant>>()
               .run(serviceResponse -> {
                   List<ProMerchant> roles = proParameter.getObj()
                       .stream()
                       .map(proMerchantRequest -> {
                            ProMerchant proMerchant = new ProMerchant();
                            BeanUtils.copyProperties(proMerchantRequest, proMerchant);
                            mapper.insert(proMerchant);
                            return proMerchant;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> delete(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMerchant> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMerchantRequest request = proParameter.getObj();
                    if(request.getMerchantId() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMerchantId,request.getMerchantId());
                    }
                    if(!StringUtils.isEmpty(request.getAbbreviation())){
                        lambdaQueryWrapper.eq(ProMerchant::getAbbreviation,request.getAbbreviation());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMerchant::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMerchant::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getLogoUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getLogoUrl,request.getLogoUrl());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMerchant::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getQualification())){
                        lambdaQueryWrapper.eq(ProMerchant::getQualification,request.getQualification());
                    }
                    if(request.getMargin() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getMargin,request.getMargin());
                    }
                    if(!StringUtils.isEmpty(request.getCollectMoney())){
                        lambdaQueryWrapper.eq(ProMerchant::getCollectMoney,request.getCollectMoney());
                    }
                    if(!StringUtils.isEmpty(request.getTel())){
                        lambdaQueryWrapper.eq(ProMerchant::getTel,request.getTel());
                    }
                    if(!StringUtils.isEmpty(request.getPhone())){
                        lambdaQueryWrapper.eq(ProMerchant::getPhone,request.getPhone());
                    }
                    if(!StringUtils.isEmpty(request.getEmail())){
                        lambdaQueryWrapper.eq(ProMerchant::getEmail,request.getEmail());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMerchant::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMerchant::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMerchant::getArea,request.getArea());
                    }
                    if(!StringUtils.isEmpty(request.getAddress())){
                        lambdaQueryWrapper.eq(ProMerchant::getAddress,request.getAddress());
                    }
                    if(!StringUtils.isEmpty(request.getQq())){
                        lambdaQueryWrapper.eq(ProMerchant::getQq,request.getQq());
                    }
                    if(!StringUtils.isEmpty(request.getHomeUrl())){
                        lambdaQueryWrapper.eq(ProMerchant::getHomeUrl,request.getHomeUrl());
                    }
                    if(request.getStat() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getStat,request.getStat());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMerchant::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProMerchant> queryWrapper = new LambdaQueryWrapper<>();
                     ProMerchantRequest request = proParameter.getObj();
                     if(request.getMerchantId() != null){
                          queryWrapper.in(ProMerchant::getMerchantId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getAbbreviation())){
                          queryWrapper.in(ProMerchant::getAbbreviation,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getUserName())){
                          queryWrapper.in(ProMerchant::getUserName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPassWord())){
                          queryWrapper.in(ProMerchant::getPassWord,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getLogoUrl())){
                          queryWrapper.in(ProMerchant::getLogoUrl,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getName())){
                          queryWrapper.in(ProMerchant::getName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getQualification())){
                          queryWrapper.in(ProMerchant::getQualification,request.getIds());
                     }
                     if(request.getMargin() != null){
                          queryWrapper.in(ProMerchant::getMargin,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getCollectMoney())){
                          queryWrapper.in(ProMerchant::getCollectMoney,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getTel())){
                          queryWrapper.in(ProMerchant::getTel,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPhone())){
                          queryWrapper.in(ProMerchant::getPhone,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getEmail())){
                          queryWrapper.in(ProMerchant::getEmail,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getProvince())){
                          queryWrapper.in(ProMerchant::getProvince,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getCity())){
                          queryWrapper.in(ProMerchant::getCity,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getArea())){
                          queryWrapper.in(ProMerchant::getArea,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getAddress())){
                          queryWrapper.in(ProMerchant::getAddress,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getQq())){
                          queryWrapper.in(ProMerchant::getQq,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getHomeUrl())){
                          queryWrapper.in(ProMerchant::getHomeUrl,request.getIds());
                     }
                     if(request.getStat() != null){
                          queryWrapper.in(ProMerchant::getStat,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProMerchant::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
