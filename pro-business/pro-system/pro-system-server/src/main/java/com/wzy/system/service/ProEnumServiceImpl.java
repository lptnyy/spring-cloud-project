package com.wzy.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import com.wzy.system.dto.ProEnum;
import com.wzy.system.request.ProEnumRequest;
import com.wzy.system.IProEnumService;
import com.wzy.system.mapper.ProEnumMapper;

@RestController
@Api(value = "枚举表 ")
public class ProEnumServiceImpl implements IProEnumService {

    @Resource
    ProEnumMapper mapper;

    @Override
    public ServiceResponse<ProEnum> get(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<ProEnum>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getList(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getPageList(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
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
    public ServiceResponse<List<ProEnum>> findIdsList(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<List<ProEnum>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> queryWrapper = new LambdaQueryWrapper<>();
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum bean = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<ProEnum> save(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<ProEnum>()
                .run(serviceResponse -> {
                    ProEnum bean = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum bean = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.deleteById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnumRequest request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}
