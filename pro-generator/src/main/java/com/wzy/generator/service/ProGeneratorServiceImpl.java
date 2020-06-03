package com.wzy.generator.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.generator.mapper.ProGeneratorMapper;
import com.wzy.generator.request.ProGeneratorRequest;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import com.wzy.generator.dto.ProGenerator;

/**
 * <p>
    * 代码生成表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-10
 */
@RestController
@Api(value = "ProGeneratorServiceImpl", description = "代码生成表")
public class ProGeneratorServiceImpl implements IProGeneratorService {

    @Resource
    ProGeneratorMapper mapper;

    @Override
    public ServiceResponse<ProGenerator> get(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<ProGenerator>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProGenerator> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProGeneratorRequest request = proParameter.getObj();
                    if(request.getGenId() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getGenId,request.getGenId());
                    }
                    if(!StringUtils.isEmpty(request.getMysql())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysql,request.getMysql());
                    }
                    if(!StringUtils.isEmpty(request.getApiPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getApiPkg,request.getApiPkg());
                    }
                    if(!StringUtils.isEmpty(request.getControllerPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getControllerPkg,request.getControllerPkg());
                    }
                    if(!StringUtils.isEmpty(request.getVoPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getVoPkg,request.getVoPkg());
                    }
                    if(!StringUtils.isEmpty(request.getServicePkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServicePkg,request.getServicePkg());
                    }
                    if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServiceImplPkg,request.getServiceImplPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMapperPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getMapperPkg,request.getMapperPkg());
                    }
                    if(!StringUtils.isEmpty(request.getDtoPgk())){
                        lambdaQueryWrapper.eq(ProGenerator::getDtoPgk,request.getDtoPgk());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlUser())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlUser,request.getMysqlUser());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlPass())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlPass,request.getMysqlPass());
                    }
                    if(!StringUtils.isEmpty(request.getTableName())){
                        lambdaQueryWrapper.eq(ProGenerator::getTableName,request.getTableName());
                    }
                    if(!StringUtils.isEmpty(request.getFeignClientService())){
                        lambdaQueryWrapper.eq(ProGenerator::getFeignClientService,request.getFeignClientService());
                    }
                    if(!StringUtils.isEmpty(request.getGateWayPath())){
                        lambdaQueryWrapper.eq(ProGenerator::getGateWayPath,request.getGateWayPath());
                    }
                    if(!StringUtils.isEmpty(request.getLogSourceName())){
                        lambdaQueryWrapper.eq(ProGenerator::getLogSourceName,request.getLogSourceName());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlDev())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlDev,request.getMysqlDev());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProGenerator::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProGenerator>> getList(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProGenerator>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProGenerator> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProGeneratorRequest request = proParameter.getObj();
                    if(request.getGenId() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getGenId,request.getGenId());
                    }
                    if(!StringUtils.isEmpty(request.getMysql())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysql,request.getMysql());
                    }
                    if(!StringUtils.isEmpty(request.getApiPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getApiPkg,request.getApiPkg());
                    }
                    if(!StringUtils.isEmpty(request.getControllerPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getControllerPkg,request.getControllerPkg());
                    }
                    if(!StringUtils.isEmpty(request.getVoPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getVoPkg,request.getVoPkg());
                    }
                    if(!StringUtils.isEmpty(request.getServicePkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServicePkg,request.getServicePkg());
                    }
                    if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServiceImplPkg,request.getServiceImplPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMapperPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getMapperPkg,request.getMapperPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlDev())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlDev,request.getMysqlDev());
                    }
                    if(!StringUtils.isEmpty(request.getDtoPgk())){
                        lambdaQueryWrapper.eq(ProGenerator::getDtoPgk,request.getDtoPgk());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlUser())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlUser,request.getMysqlUser());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlPass())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlPass,request.getMysqlPass());
                    }
                    if(!StringUtils.isEmpty(request.getTableName())){
                        lambdaQueryWrapper.eq(ProGenerator::getTableName,request.getTableName());
                    }
                    if(!StringUtils.isEmpty(request.getFeignClientService())){
                        lambdaQueryWrapper.eq(ProGenerator::getFeignClientService,request.getFeignClientService());
                    }
                    if(!StringUtils.isEmpty(request.getGateWayPath())){
                        lambdaQueryWrapper.eq(ProGenerator::getGateWayPath,request.getGateWayPath());
                    }
                    if(!StringUtils.isEmpty(request.getLogSourceName())){
                        lambdaQueryWrapper.eq(ProGenerator::getLogSourceName,request.getLogSourceName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProGenerator::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProGenerator>> getPageList(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProGenerator>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProGenerator> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProGeneratorRequest request = proParameter.getObj();
                    if(request.getGenId() != null) {
                        lambdaQueryWrapper.eq(ProGenerator::getGenId,request.getGenId());
                    }
                    if(!StringUtils.isEmpty(request.getMysql())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysql,request.getMysql());
                    }
                    if(!StringUtils.isEmpty(request.getApiPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getApiPkg,request.getApiPkg());
                    }
                    if(!StringUtils.isEmpty(request.getControllerPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getControllerPkg,request.getControllerPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlDev())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlDev,request.getMysqlDev());
                    }
                    if(!StringUtils.isEmpty(request.getVoPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getVoPkg,request.getVoPkg());
                    }
                    if(!StringUtils.isEmpty(request.getServicePkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServicePkg,request.getServicePkg());
                    }
                    if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServiceImplPkg,request.getServiceImplPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMapperPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getMapperPkg,request.getMapperPkg());
                    }
                    if(!StringUtils.isEmpty(request.getDtoPgk())){
                        lambdaQueryWrapper.eq(ProGenerator::getDtoPgk,request.getDtoPgk());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlUser())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlUser,request.getMysqlUser());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlPass())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlPass,request.getMysqlPass());
                    }
                    if(!StringUtils.isEmpty(request.getTableName())){
                        lambdaQueryWrapper.eq(ProGenerator::getTableName,request.getTableName());
                    }
                    if(!StringUtils.isEmpty(request.getFeignClientService())){
                        lambdaQueryWrapper.eq(ProGenerator::getFeignClientService,request.getFeignClientService());
                    }
                    if(!StringUtils.isEmpty(request.getGateWayPath())){
                        lambdaQueryWrapper.eq(ProGenerator::getGateWayPath,request.getGateWayPath());
                    }
                    if(!StringUtils.isEmpty(request.getLogSourceName())){
                        lambdaQueryWrapper.eq(ProGenerator::getLogSourceName,request.getLogSourceName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProGenerator::getCreateTime);
                    Page<ProGenerator> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProGenerator> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProGenerator>> findIdsList(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<List<ProGenerator>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProGenerator> queryWrapper = new LambdaQueryWrapper<>();
                    ProGeneratorRequest request = proParameter.getObj();
                    if(request.getGenId() != null){
                        queryWrapper.in(ProGenerator::getGenId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMysql())){
                        queryWrapper.in(ProGenerator::getMysql,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getApiPkg())){
                        queryWrapper.in(ProGenerator::getApiPkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getControllerPkg())){
                        queryWrapper.in(ProGenerator::getControllerPkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getVoPkg())){
                        queryWrapper.in(ProGenerator::getVoPkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getServicePkg())){
                        queryWrapper.in(ProGenerator::getServicePkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                        queryWrapper.in(ProGenerator::getServiceImplPkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMapperPkg())){
                        queryWrapper.in(ProGenerator::getMapperPkg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getDtoPgk())){
                        queryWrapper.in(ProGenerator::getDtoPgk,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlUser())){
                        queryWrapper.in(ProGenerator::getMysqlUser,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlPass())){
                        queryWrapper.in(ProGenerator::getMysqlPass,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getTableName())){
                        queryWrapper.in(ProGenerator::getTableName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getFeignClientService())){
                        queryWrapper.in(ProGenerator::getFeignClientService,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getGateWayPath())){
                        queryWrapper.in(ProGenerator::getGateWayPath,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getLogSourceName())){
                        queryWrapper.in(ProGenerator::getLogSourceName,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProGenerator::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProGenerator::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProGenerator bean = new ProGenerator();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<ProGenerator> save(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<ProGenerator>()
                .run(serviceResponse -> {
                    ProGenerator bean = new ProGenerator();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProGenerator>> batchSave(ProParameter<List<ProGeneratorRequest>> proParameter) throws Exception {
       return new ServiceResponse<List<ProGenerator>>()
               .run(serviceResponse -> {
                   List<ProGenerator> roles = proParameter.getObj()
                       .stream()
                       .map(proGeneratorRequest -> {
                            ProGenerator proGenerator = new ProGenerator();
                            BeanUtils.copyProperties(proGeneratorRequest, proGenerator);
                            mapper.insert(proGenerator);
                            return proGenerator;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProGenerator> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProGeneratorRequest request = proParameter.getObj();
                    if(request.getGenId() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getGenId,request.getGenId());
                    }
                    if(!StringUtils.isEmpty(request.getMysql())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysql,request.getMysql());
                    }
                    if(!StringUtils.isEmpty(request.getApiPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getApiPkg,request.getApiPkg());
                    }
                    if(!StringUtils.isEmpty(request.getControllerPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getControllerPkg,request.getControllerPkg());
                    }
                    if(!StringUtils.isEmpty(request.getVoPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getVoPkg,request.getVoPkg());
                    }
                    if(!StringUtils.isEmpty(request.getServicePkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServicePkg,request.getServicePkg());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlDev())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlDev,request.getMysqlDev());
                    }
                    if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getServiceImplPkg,request.getServiceImplPkg());
                    }
                    if(!StringUtils.isEmpty(request.getMapperPkg())){
                        lambdaQueryWrapper.eq(ProGenerator::getMapperPkg,request.getMapperPkg());
                    }
                    if(!StringUtils.isEmpty(request.getDtoPgk())){
                        lambdaQueryWrapper.eq(ProGenerator::getDtoPgk,request.getDtoPgk());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlUser())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlUser,request.getMysqlUser());
                    }
                    if(!StringUtils.isEmpty(request.getMysqlPass())){
                        lambdaQueryWrapper.eq(ProGenerator::getMysqlPass,request.getMysqlPass());
                    }
                    if(!StringUtils.isEmpty(request.getTableName())){
                        lambdaQueryWrapper.eq(ProGenerator::getTableName,request.getTableName());
                    }
                    if(!StringUtils.isEmpty(request.getFeignClientService())){
                        lambdaQueryWrapper.eq(ProGenerator::getFeignClientService,request.getFeignClientService());
                    }
                    if(!StringUtils.isEmpty(request.getGateWayPath())){
                        lambdaQueryWrapper.eq(ProGenerator::getGateWayPath,request.getGateWayPath());
                    }
                    if(!StringUtils.isEmpty(request.getLogSourceName())){
                        lambdaQueryWrapper.eq(ProGenerator::getLogSourceName,request.getLogSourceName());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProGenerator::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProGeneratorRequest> proParameter) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProGenerator> queryWrapper = new LambdaQueryWrapper<>();
                     ProGeneratorRequest request = proParameter.getObj();
                     if(request.getGenId() != null){
                          queryWrapper.in(ProGenerator::getGenId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMysql())){
                          queryWrapper.in(ProGenerator::getMysql,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getApiPkg())){
                          queryWrapper.in(ProGenerator::getApiPkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getControllerPkg())){
                          queryWrapper.in(ProGenerator::getControllerPkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getVoPkg())){
                          queryWrapper.in(ProGenerator::getVoPkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getServicePkg())){
                          queryWrapper.in(ProGenerator::getServicePkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getServiceImplPkg())){
                          queryWrapper.in(ProGenerator::getServiceImplPkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMapperPkg())){
                          queryWrapper.in(ProGenerator::getMapperPkg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getDtoPgk())){
                          queryWrapper.in(ProGenerator::getDtoPgk,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMysqlUser())){
                          queryWrapper.in(ProGenerator::getMysqlUser,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMysqlPass())){
                          queryWrapper.in(ProGenerator::getMysqlPass,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getTableName())){
                          queryWrapper.in(ProGenerator::getTableName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getFeignClientService())){
                          queryWrapper.in(ProGenerator::getFeignClientService,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getGateWayPath())){
                          queryWrapper.in(ProGenerator::getGateWayPath,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getLogSourceName())){
                          queryWrapper.in(ProGenerator::getLogSourceName,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProGenerator::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
