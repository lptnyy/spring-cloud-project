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
import com.wzy.system.dto.ProEnum;
import com.wzy.system.request.ProEnumRequest;
import com.wzy.system.IProEnumService;
import com.wzy.system.mapper.ProEnumMapper;

/**
 * <p>
    * 枚举表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@RestController
@Api(value = "ProEnumServiceImpl", description = "枚举表 ")
public class ProEnumServiceImpl implements IProEnumService {

    @Resource
    ProEnumMapper mapper;

    @Override
    public ServiceResponse<ProEnum> get(ProParameter<ProEnumRequest> proParameter) throws Exception {
        return new ServiceResponse<ProEnum>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if (request.getEnumId() != null) {
                        lambdaQueryWrapper.eq(ProEnum::getEnumId,request.getEnumId());
                    }
                    if(!StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr,request.getKeystr());
                    }
                    if(!StringUtils.isEmpty(request.getValuestr())){
                        lambdaQueryWrapper.eq(ProEnum::getValuestr,request.getValuestr());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProEnum::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProEnum::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProEnum::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getList(ProParameter<ProEnumRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if(request.getEnumId() != null){
                        lambdaQueryWrapper.eq(ProEnum::getEnumId,request.getEnumId());
                    }
                    if(!StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr,request.getKeystr());
                    }
                    if(!StringUtils.isEmpty(request.getValuestr())){
                        lambdaQueryWrapper.eq(ProEnum::getValuestr,request.getValuestr());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProEnum::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProEnum::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProEnum::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getPageList(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if(request.getEnumId() != null){
                        lambdaQueryWrapper.eq(ProEnum::getEnumId,request.getEnumId());
                    }
                    if(!StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr,request.getKeystr());
                    }
                    if(!StringUtils.isEmpty(request.getValuestr())){
                        lambdaQueryWrapper.eq(ProEnum::getValuestr,request.getValuestr());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProEnum::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProEnum::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProEnum::getCreateTime);
                    Page<ProEnum> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProEnum> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> findIdsList(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<List<ProEnum>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> queryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if(request.getEnumId() != null){
                        queryWrapper.in(ProEnum::getEnumId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getKeystr())){
                        queryWrapper.in(ProEnum::getKeystr,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getValuestr())){
                        queryWrapper.in(ProEnum::getValuestr,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        queryWrapper.in(ProEnum::getType,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProEnum::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProEnum::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> update(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum bean = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<ProEnum> save(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<ProEnum>()
                .run(serviceResponse -> {
                    ProEnum bean = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<List<ProEnum>> batchSave(ProParameter<List<ProEnumRequest>> proParameter) throws Exception{
       return new ServiceResponse<List<ProEnum>>()
               .run(serviceResponse -> {
                   List<ProEnum> roles = proParameter.getObj()
                       .stream()
                       .map(proEnumRequest -> {
                            ProEnum proEnum = new ProEnum();
                            BeanUtils.copyProperties(proEnumRequest, proEnum);
                            mapper.insert(proEnum);
                            return proEnum;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @Transactional
    public ServiceResponse<Integer> delete(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if(request.getEnumId() != null){
                        lambdaQueryWrapper.eq(ProEnum::getEnumId,request.getEnumId());
                    }
                    if(!StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr,request.getKeystr());
                    }
                    if(!StringUtils.isEmpty(request.getValuestr())){
                        lambdaQueryWrapper.eq(ProEnum::getValuestr,request.getValuestr());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProEnum::getType,request.getType());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProEnum::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @Transactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProEnumRequest> proParameter) throws Exception{
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProEnum> queryWrapper = new LambdaQueryWrapper<>();
                     ProEnumRequest request = proParameter.getObj();
                     if(request.getEnumId() != null){
                          queryWrapper.in(ProEnum::getEnumId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getKeystr())){
                          queryWrapper.in(ProEnum::getKeystr,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getValuestr())){
                          queryWrapper.in(ProEnum::getValuestr,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getType())){
                          queryWrapper.in(ProEnum::getType,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProEnum::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
