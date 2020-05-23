package com.wzy.member.service;
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
import com.wzy.member.dto.ProMember;
import com.wzy.member.request.ProMemberRequest;
import com.wzy.member.IProMemberService;
import com.wzy.member.mapper.ProMemberMapper;

/**
 * <p>
    * 会员表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-23
 */
@RestController
@Api(value = "ProMemberServiceImpl", description = "会员表 ")
public class ProMemberServiceImpl implements IProMemberService {

    @Resource
    ProMemberMapper mapper;

    @Override
    public ServiceResponse<ProMember> get(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<ProMember>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMemberRequest request = proParameter.getObj();
                    if(request.getMemberId() != null){
                        lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
                    }
                    if(!StringUtils.isEmpty(request.getMemberNo())){
                        lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getHeadImg())){
                        lambdaQueryWrapper.eq(ProMember::getHeadImg,request.getHeadImg());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMember::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getSchool())){
                        lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
                    }
                    if(!StringUtils.isEmpty(request.getDepartment())){
                        lambdaQueryWrapper.eq(ProMember::getDepartment,request.getDepartment());
                    }
                    if(!StringUtils.isEmpty(request.getAdmissionTime())){
                        lambdaQueryWrapper.eq(ProMember::getAdmissionTime,request.getAdmissionTime());
                    }
                    if(!StringUtils.isEmpty(request.getEducation())){
                        lambdaQueryWrapper.eq(ProMember::getEducation,request.getEducation());
                    }
                    if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                        lambdaQueryWrapper.eq(ProMember::getDisplayPermissions,request.getDisplayPermissions());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMember::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> getList(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<List<ProMember>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMemberRequest request = proParameter.getObj();
                    if(request.getMemberId() != null){
                        lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
                    }
                    if(!StringUtils.isEmpty(request.getMemberNo())){
                        lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getHeadImg())){
                        lambdaQueryWrapper.eq(ProMember::getHeadImg,request.getHeadImg());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMember::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getSchool())){
                        lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
                    }
                    if(!StringUtils.isEmpty(request.getDepartment())){
                        lambdaQueryWrapper.eq(ProMember::getDepartment,request.getDepartment());
                    }
                    if(!StringUtils.isEmpty(request.getAdmissionTime())){
                        lambdaQueryWrapper.eq(ProMember::getAdmissionTime,request.getAdmissionTime());
                    }
                    if(!StringUtils.isEmpty(request.getEducation())){
                        lambdaQueryWrapper.eq(ProMember::getEducation,request.getEducation());
                    }
                    if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                        lambdaQueryWrapper.eq(ProMember::getDisplayPermissions,request.getDisplayPermissions());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMember::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> getPageList(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<List<ProMember>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMemberRequest request = proParameter.getObj();
                    if(request.getMemberId() != null){
                        lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
                    }
                    if(!StringUtils.isEmpty(request.getMemberNo())){
                        lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getHeadImg())){
                        lambdaQueryWrapper.eq(ProMember::getHeadImg,request.getHeadImg());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMember::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getSchool())){
                        lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
                    }
                    if(!StringUtils.isEmpty(request.getDepartment())){
                        lambdaQueryWrapper.eq(ProMember::getDepartment,request.getDepartment());
                    }
                    if(!StringUtils.isEmpty(request.getAdmissionTime())){
                        lambdaQueryWrapper.eq(ProMember::getAdmissionTime,request.getAdmissionTime());
                    }
                    if(!StringUtils.isEmpty(request.getEducation())){
                        lambdaQueryWrapper.eq(ProMember::getEducation,request.getEducation());
                    }
                    if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                        lambdaQueryWrapper.eq(ProMember::getDisplayPermissions,request.getDisplayPermissions());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
                    }
                    lambdaQueryWrapper.orderByDesc(ProMember::getCreateTime);
                    Page<ProMember> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProMember> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<ProMember>> findIdsList(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<List<ProMember>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMember> queryWrapper = new LambdaQueryWrapper<>();
                    ProMemberRequest request = proParameter.getObj();
                    if(request.getMemberId() != null){
                        queryWrapper.in(ProMember::getMemberId,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getMemberNo())){
                        queryWrapper.in(ProMember::getMemberNo,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        queryWrapper.in(ProMember::getUserName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        queryWrapper.in(ProMember::getPassWord,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getHeadImg())){
                        queryWrapper.in(ProMember::getHeadImg,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        queryWrapper.in(ProMember::getName,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getSchool())){
                        queryWrapper.in(ProMember::getSchool,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getDepartment())){
                        queryWrapper.in(ProMember::getDepartment,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getAdmissionTime())){
                        queryWrapper.in(ProMember::getAdmissionTime,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getEducation())){
                        queryWrapper.in(ProMember::getEducation,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                        queryWrapper.in(ProMember::getDisplayPermissions,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        queryWrapper.in(ProMember::getProvince,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        queryWrapper.in(ProMember::getCity,request.getIds());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        queryWrapper.in(ProMember::getArea,request.getIds());
                    }
                    if(request.getCreateTime() != null){
                        queryWrapper.in(ProMember::getCreateTime,request.getIds());
                    }
                    queryWrapper.orderByDesc(ProMember::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> update(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProMember bean = new ProMember();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<ProMember> save(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<ProMember>()
                .run(serviceResponse -> {
                    ProMember bean = new ProMember();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<List<ProMember>> batchSave(ProParameter<List<ProMemberRequest>> proParameter) {
       return new ServiceResponse<List<ProMember>>()
               .run(serviceResponse -> {
                   List<ProMember> roles = proParameter.getObj()
                       .stream()
                       .map(proMemberRequest -> {
                            ProMember proMember = new ProMember();
                            BeanUtils.copyProperties(proMemberRequest, proMember);
                            mapper.insert(proMember);
                            return proMember;
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> delete(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProMember> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProMemberRequest request = proParameter.getObj();
                    if(request.getMemberId() != null){
                        lambdaQueryWrapper.eq(ProMember::getMemberId,request.getMemberId());
                    }
                    if(!StringUtils.isEmpty(request.getMemberNo())){
                        lambdaQueryWrapper.eq(ProMember::getMemberNo,request.getMemberNo());
                    }
                    if(!StringUtils.isEmpty(request.getUserName())){
                        lambdaQueryWrapper.eq(ProMember::getUserName,request.getUserName());
                    }
                    if(!StringUtils.isEmpty(request.getPassWord())){
                        lambdaQueryWrapper.eq(ProMember::getPassWord,request.getPassWord());
                    }
                    if(!StringUtils.isEmpty(request.getHeadImg())){
                        lambdaQueryWrapper.eq(ProMember::getHeadImg,request.getHeadImg());
                    }
                    if(!StringUtils.isEmpty(request.getName())){
                        lambdaQueryWrapper.eq(ProMember::getName,request.getName());
                    }
                    if(!StringUtils.isEmpty(request.getSchool())){
                        lambdaQueryWrapper.eq(ProMember::getSchool,request.getSchool());
                    }
                    if(!StringUtils.isEmpty(request.getDepartment())){
                        lambdaQueryWrapper.eq(ProMember::getDepartment,request.getDepartment());
                    }
                    if(!StringUtils.isEmpty(request.getAdmissionTime())){
                        lambdaQueryWrapper.eq(ProMember::getAdmissionTime,request.getAdmissionTime());
                    }
                    if(!StringUtils.isEmpty(request.getEducation())){
                        lambdaQueryWrapper.eq(ProMember::getEducation,request.getEducation());
                    }
                    if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                        lambdaQueryWrapper.eq(ProMember::getDisplayPermissions,request.getDisplayPermissions());
                    }
                    if(!StringUtils.isEmpty(request.getProvince())){
                        lambdaQueryWrapper.eq(ProMember::getProvince,request.getProvince());
                    }
                    if(!StringUtils.isEmpty(request.getCity())){
                        lambdaQueryWrapper.eq(ProMember::getCity,request.getCity());
                    }
                    if(!StringUtils.isEmpty(request.getArea())){
                        lambdaQueryWrapper.eq(ProMember::getArea,request.getArea());
                    }
                    if(request.getCreateTime() != null){
                        lambdaQueryWrapper.eq(ProMember::getCreateTime,request.getCreateTime());
                    }
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMemberRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                     LambdaQueryWrapper<ProMember> queryWrapper = new LambdaQueryWrapper<>();
                     ProMemberRequest request = proParameter.getObj();
                     if(request.getMemberId() != null){
                          queryWrapper.in(ProMember::getMemberId,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getMemberNo())){
                          queryWrapper.in(ProMember::getMemberNo,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getUserName())){
                          queryWrapper.in(ProMember::getUserName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getPassWord())){
                          queryWrapper.in(ProMember::getPassWord,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getHeadImg())){
                          queryWrapper.in(ProMember::getHeadImg,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getName())){
                          queryWrapper.in(ProMember::getName,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getSchool())){
                          queryWrapper.in(ProMember::getSchool,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getDepartment())){
                          queryWrapper.in(ProMember::getDepartment,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getAdmissionTime())){
                          queryWrapper.in(ProMember::getAdmissionTime,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getEducation())){
                          queryWrapper.in(ProMember::getEducation,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getDisplayPermissions())){
                          queryWrapper.in(ProMember::getDisplayPermissions,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getProvince())){
                          queryWrapper.in(ProMember::getProvince,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getCity())){
                          queryWrapper.in(ProMember::getCity,request.getIds());
                     }
                     if(!StringUtils.isEmpty(request.getArea())){
                          queryWrapper.in(ProMember::getArea,request.getIds());
                     }
                     if(request.getCreateTime() != null){
                          queryWrapper.in(ProMember::getCreateTime,request.getIds());
                     }
                    return mapper.delete(queryWrapper);
                }).exec();
    }
}
