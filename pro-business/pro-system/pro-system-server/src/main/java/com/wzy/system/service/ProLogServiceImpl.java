package com.wzy.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.wzy.system.dto.ProLog;
import com.wzy.system.request.ProLogRequest;
import com.wzy.system.IProLogService;
import com.wzy.system.mapper.ProLogMapper;

/**
 * <p>
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-07
 */
@RestController
@Api(value = "ProLogServiceImpl", description = "操作日志")
public class ProLogServiceImpl implements IProLogService {

    @Resource
    ProLogMapper mapper;

    @Override
    public ServiceResponse<ProLog> get(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<ProLog>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProLog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProLogRequest request = proParameter.getObj();
                    if(request.getLogId() != null){
                        lambdaQueryWrapper.eq(ProLog::getLogId,request.getLogId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProLog::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getValue())){
                        lambdaQueryWrapper.eq(ProLog::getValue,request.getValue());
                    }
                    if(!StringUtils.isEmpty(request.getClassName())){
                        lambdaQueryWrapper.eq(ProLog::getClassName,request.getClassName());
                    }
                    if(!StringUtils.isEmpty(request.getFunctionName())){
                        lambdaQueryWrapper.eq(ProLog::getFunctionName,request.getFunctionName());
                    }
                    if(request.getRunTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getRunTime,request.getRunTime());
                    }
                    if(!StringUtils.isEmpty(request.getSource())){
                        lambdaQueryWrapper.eq(ProLog::getSource,request.getSource());
                    }
                    if(!StringUtils.isEmpty(request.getBody())){
                        lambdaQueryWrapper.eq(ProLog::getBody,request.getBody());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getCreateTime,request.getCreateTime());
                    }
                    if (!StringUtils.isEmpty(request.getStartTime())) {
                        lambdaQueryWrapper.ge(ProLog::getCreateTime, request.getStartTime());
                    }
                    if (!StringUtils.isEmpty(request.getEndTime())) {
                        lambdaQueryWrapper.le(ProLog::getCreateTime, request.getEndTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProLog::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProLog>> getList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProLog>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProLog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProLogRequest request = proParameter.getObj();
                    if(request.getLogId() != null){
                        lambdaQueryWrapper.eq(ProLog::getLogId,request.getLogId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProLog::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getValue())){
                        lambdaQueryWrapper.eq(ProLog::getValue,request.getValue());
                    }
                    if(!StringUtils.isEmpty(request.getClassName())){
                        lambdaQueryWrapper.eq(ProLog::getClassName,request.getClassName());
                    }
                    if(!StringUtils.isEmpty(request.getFunctionName())){
                        lambdaQueryWrapper.eq(ProLog::getFunctionName,request.getFunctionName());
                    }
                    if(request.getRunTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getRunTime,request.getRunTime());
                    }
                    if(!StringUtils.isEmpty(request.getSource())){
                        lambdaQueryWrapper.eq(ProLog::getSource,request.getSource());
                    }
                    if(!StringUtils.isEmpty(request.getBody())){
                        lambdaQueryWrapper.eq(ProLog::getBody,request.getBody());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getCreateTime,request.getCreateTime());
                    }
                    if (!StringUtils.isEmpty(request.getStartTime())) {
                        lambdaQueryWrapper.ge(ProLog::getCreateTime, request.getStartTime());
                    }
                    if (!StringUtils.isEmpty(request.getEndTime())) {
                        lambdaQueryWrapper.le(ProLog::getCreateTime, request.getEndTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProLog::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProLog>> getPageList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProLog>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProLog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProLogRequest request = proParameter.getObj();
                    if(request.getLogId() != null){
                        lambdaQueryWrapper.eq(ProLog::getLogId,request.getLogId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProLog::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getValue())){
                        lambdaQueryWrapper.eq(ProLog::getValue,request.getValue());
                    }
                    if(!StringUtils.isEmpty(request.getClassName())){
                        lambdaQueryWrapper.eq(ProLog::getClassName,request.getClassName());
                    }
                    if(!StringUtils.isEmpty(request.getFunctionName())){
                        lambdaQueryWrapper.eq(ProLog::getFunctionName,request.getFunctionName());
                    }
                    if(request.getRunTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getRunTime,request.getRunTime());
                    }
                    if(!StringUtils.isEmpty(request.getSource())){
                        lambdaQueryWrapper.eq(ProLog::getSource,request.getSource());
                    }
                    if(!StringUtils.isEmpty(request.getBody())){
                        lambdaQueryWrapper.eq(ProLog::getBody,request.getBody());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getCreateTime,request.getCreateTime());
                    }
                    if (!StringUtils.isEmpty(request.getStartTime())) {
                        lambdaQueryWrapper.ge(ProLog::getCreateTime, request.getStartTime());
                    }
                    if (!StringUtils.isEmpty(request.getEndTime())) {
                        lambdaQueryWrapper.le(ProLog::getCreateTime, request.getEndTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProLog::getCreateTime);
                    Page<ProLog> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProLog> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProLog>> findIdsList(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProLog>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProLog> queryWrapper = new LambdaQueryWrapper<>();
                    ProLogRequest request = proParameter.getObj();
                    if(request.getLogId() != null){
                        queryWrapper.in(ProLog::getLogId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        queryWrapper.in(ProLog::getName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getValue())){
                        queryWrapper.in(ProLog::getValue,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getClassName())){
                        queryWrapper.in(ProLog::getClassName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getFunctionName())){
                        queryWrapper.in(ProLog::getFunctionName,request.getIds());
                    }
                    if(request.getRunTime() != null){
                        queryWrapper.in(ProLog::getRunTime,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getSource())){
                        queryWrapper.in(ProLog::getSource,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getBody())){
                        queryWrapper.in(ProLog::getBody,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProLog::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProLog::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> update(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProLog bean = new ProLog();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<ProLog> save(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<ProLog>()
                .run(serviceResponse -> {
                    ProLog bean = new ProLog();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<List<ProLog>> batchSave(ProParameter<List<ProLogRequest>> proParameter) throws Exception {
       return new ServiceResponse<List<ProLog>>()
               .run(serviceResponse -> {
                   List<ProLog> roles = proParameter.getObj()
                       .stream()
                       .map(proLogRequest -> {
                            ProLog proLog = new ProLog();
                            BeanUtils.copyProperties(proLogRequest, proLog);
                            mapper.insert(proLog);
                            return proLog;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> delete(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProLog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProLogRequest request = proParameter.getObj();
                    if(request.getLogId() != null){
                        lambdaQueryWrapper.eq(ProLog::getLogId,request.getLogId());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProLog::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getValue())){
                        lambdaQueryWrapper.eq(ProLog::getValue,request.getValue());
                    }
                    if(!StringUtils.isEmpty(request.getClassName())){
                        lambdaQueryWrapper.eq(ProLog::getClassName,request.getClassName());
                    }
                    if(!StringUtils.isEmpty(request.getFunctionName())){
                        lambdaQueryWrapper.eq(ProLog::getFunctionName,request.getFunctionName());
                    }
                    if(request.getRunTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getRunTime,request.getRunTime());
                    }
                    if(!StringUtils.isEmpty(request.getSource())){
                        lambdaQueryWrapper.eq(ProLog::getSource,request.getSource());
                    }
                    if(!StringUtils.isEmpty(request.getBody())){
                        lambdaQueryWrapper.eq(ProLog::getBody,request.getBody());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProLog::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProLogRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProLog> queryWrapper = new LambdaQueryWrapper<>();
                     ProLogRequest request = proParameter.getObj();
                     if(request.getLogId() != null){
                          queryWrapper.in(ProLog::getLogId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getName())){
                          queryWrapper.in(ProLog::getName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getValue())){
                          queryWrapper.in(ProLog::getValue,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getClassName())){
                          queryWrapper.in(ProLog::getClassName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getFunctionName())){
                          queryWrapper.in(ProLog::getFunctionName,request.getIds());
                     }
                     if(request.getRunTime() != null){
                          queryWrapper.in(ProLog::getRunTime,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getSource())){
                          queryWrapper.in(ProLog::getSource,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getBody())){
                          queryWrapper.in(ProLog::getBody,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProLog::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
