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
import com.wzy.system.dto.ProResourceFile;
import com.wzy.system.request.ProResourceFileRequest;
import com.wzy.system.IProResourceFileService;
import com.wzy.system.mapper.ProResourceFileMapper;

/**
 * <p>
    * 系统资源文件表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@RestController
@Api(value = "ProResourceFileServiceImpl", description = "系统资源文件表 ")
public class ProResourceFileServiceImpl implements IProResourceFileService {

    @Resource
    ProResourceFileMapper mapper;

    @Override
    public ServiceResponse<ProResourceFile> get(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<ProResourceFile>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProResourceFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProResourceFileRequest request = proParameter.getObj();
                    if(request.getFileId() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileId,request.getFileId());
                    }
                    if(!StringUtils.isEmpty(request.getFileName())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileName,request.getFileName());
                    }
                    if(!StringUtils.isEmpty(request.getPhysicsPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPhysicsPath,request.getPhysicsPath());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getMd5())){
                        lambdaQueryWrapper.eq(ProResourceFile::getMd5,request.getMd5());
                    }
                    if(request.getFileSize() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileSize,request.getFileSize());
                    }
                    if(!StringUtils.isEmpty(request.getFileDns())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileDns,request.getFileDns());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getType,request.getType());
                    }
                    if(!StringUtils.isEmpty(request.getSuffix())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSuffix,request.getSuffix());
                    }
                    if(!StringUtils.isEmpty(request.getSourceType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSourceType,request.getSourceType());
                    }
                    if(request.getUploadTime() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getUploadTime,request.getUploadTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProResourceFile::getUploadTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProResourceFile>> getList(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<List<ProResourceFile>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProResourceFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProResourceFileRequest request = proParameter.getObj();
                    if(request.getFileId() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileId,request.getFileId());
                    }
                    if(!StringUtils.isEmpty(request.getFileName())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileName,request.getFileName());
                    }
                    if(!StringUtils.isEmpty(request.getPhysicsPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPhysicsPath,request.getPhysicsPath());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getMd5())){
                        lambdaQueryWrapper.eq(ProResourceFile::getMd5,request.getMd5());
                    }
                    if(request.getFileSize() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileSize,request.getFileSize());
                    }
                    if(!StringUtils.isEmpty(request.getFileDns())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileDns,request.getFileDns());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getType,request.getType());
                    }
                    if(!StringUtils.isEmpty(request.getSuffix())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSuffix,request.getSuffix());
                    }
                    if(!StringUtils.isEmpty(request.getSourceType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSourceType,request.getSourceType());
                    }
                    if(request.getUploadTime() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getUploadTime,request.getUploadTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProResourceFile::getUploadTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProResourceFile>> getPageList(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<List<ProResourceFile>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProResourceFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProResourceFileRequest request = proParameter.getObj();
                    if(request.getFileId() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileId,request.getFileId());
                    }
                    if(!StringUtils.isEmpty(request.getFileName())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileName,request.getFileName());
                    }
                    if(!StringUtils.isEmpty(request.getPhysicsPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPhysicsPath,request.getPhysicsPath());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getMd5())){
                        lambdaQueryWrapper.eq(ProResourceFile::getMd5,request.getMd5());
                    }
                    if(request.getFileSize() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileSize,request.getFileSize());
                    }
                    if(!StringUtils.isEmpty(request.getFileDns())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileDns,request.getFileDns());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getType,request.getType());
                    }
                    if(!StringUtils.isEmpty(request.getSuffix())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSuffix,request.getSuffix());
                    }
                    if(!StringUtils.isEmpty(request.getSourceType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSourceType,request.getSourceType());
                    }
                    if(request.getUploadTime() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getUploadTime,request.getUploadTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProResourceFile::getUploadTime);
                    Page<ProResourceFile> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProResourceFile> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProResourceFile>> findIdsList(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<List<ProResourceFile>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProResourceFile> queryWrapper = new LambdaQueryWrapper<>();
                    ProResourceFileRequest request = proParameter.getObj();
                    if(request.getFileId() != null){
                        queryWrapper.in(ProResourceFile::getFileId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getFileName())){
                        queryWrapper.in(ProResourceFile::getFileName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPhysicsPath())){
                        queryWrapper.in(ProResourceFile::getPhysicsPath,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        queryWrapper.in(ProResourceFile::getPath,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMd5())){
                        queryWrapper.in(ProResourceFile::getMd5,request.getIds());
                    }
                    if(request.getFileSize() != null){
                        queryWrapper.in(ProResourceFile::getFileSize,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getFileDns())){
                        queryWrapper.in(ProResourceFile::getFileDns,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        queryWrapper.in(ProResourceFile::getType,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getSuffix())){
                        queryWrapper.in(ProResourceFile::getSuffix,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getSourceType())){
                        queryWrapper.in(ProResourceFile::getSourceType,request.getIds());
                    }
                    if(request.getUploadTime() != null){
                        queryWrapper.in(ProResourceFile::getUploadTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProResourceFile::getUploadTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProResourceFile bean = new ProResourceFile();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<ProResourceFile> save(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<ProResourceFile>()
                .run(serviceResponse -> {
                    ProResourceFile bean = new ProResourceFile();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProResourceFile>> batchSave(ProParameter<List<ProResourceFileRequest>> proParameter) {
       return new ServiceResponse<List<ProResourceFile>>()
               .run(serviceResponse -> {
                   List<ProResourceFile> roles = proParameter.getObj()
                       .stream()
                       .map(proResourceFileRequest -> {
                            ProResourceFile proResourceFile = new ProResourceFile();
                            BeanUtils.copyProperties(proResourceFileRequest, proResourceFile);
                            mapper.insert(proResourceFile);
                            return proResourceFile;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProResourceFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProResourceFileRequest request = proParameter.getObj();
                    if(request.getFileId() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileId,request.getFileId());
                    }
                    if(!StringUtils.isEmpty(request.getFileName())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileName,request.getFileName());
                    }
                    if(!StringUtils.isEmpty(request.getPhysicsPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPhysicsPath,request.getPhysicsPath());
                    }
                    if(!StringUtils.isEmpty(request.getPath())){
                        lambdaQueryWrapper.eq(ProResourceFile::getPath,request.getPath());
                    }
                    if(!StringUtils.isEmpty(request.getMd5())){
                        lambdaQueryWrapper.eq(ProResourceFile::getMd5,request.getMd5());
                    }
                    if(request.getFileSize() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileSize,request.getFileSize());
                    }
                    if(!StringUtils.isEmpty(request.getFileDns())){
                        lambdaQueryWrapper.eq(ProResourceFile::getFileDns,request.getFileDns());
                    }
                    if(!StringUtils.isEmpty(request.getType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getType,request.getType());
                    }
                    if(!StringUtils.isEmpty(request.getSuffix())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSuffix,request.getSuffix());
                    }
                    if(!StringUtils.isEmpty(request.getSourceType())){
                        lambdaQueryWrapper.eq(ProResourceFile::getSourceType,request.getSourceType());
                    }
                    if(request.getUploadTime() != null){
                        lambdaQueryWrapper.eq(ProResourceFile::getUploadTime,request.getUploadTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProResourceFileRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProResourceFile> queryWrapper = new LambdaQueryWrapper<>();
                     ProResourceFileRequest request = proParameter.getObj();
                     if(request.getFileId() != null){
                          queryWrapper.in(ProResourceFile::getFileId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getFileName())){
                          queryWrapper.in(ProResourceFile::getFileName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPhysicsPath())){
                          queryWrapper.in(ProResourceFile::getPhysicsPath,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPath())){
                          queryWrapper.in(ProResourceFile::getPath,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMd5())){
                          queryWrapper.in(ProResourceFile::getMd5,request.getIds());
                     }
                     if(request.getFileSize() != null){
                          queryWrapper.in(ProResourceFile::getFileSize,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getFileDns())){
                          queryWrapper.in(ProResourceFile::getFileDns,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getType())){
                          queryWrapper.in(ProResourceFile::getType,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getSuffix())){
                          queryWrapper.in(ProResourceFile::getSuffix,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getSourceType())){
                          queryWrapper.in(ProResourceFile::getSourceType,request.getIds());
                     }
                     if(request.getUploadTime() != null){
                          queryWrapper.in(ProResourceFile::getUploadTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
