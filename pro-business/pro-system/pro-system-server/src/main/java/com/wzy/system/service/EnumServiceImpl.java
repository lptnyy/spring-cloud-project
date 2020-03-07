package com.wzy.system.service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.IProEnumService;
import com.wzy.system.dto.ProEnum;
import com.wzy.system.mapper.proenum.ProEnumMapper;
import com.wzy.system.request.ProEnumRequest;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "枚举操作接口")
public class EnumServiceImpl implements IProEnumService {

    @Resource
    ProEnumMapper proEnumMapper;

    @Override
    public ServiceResponse<ProEnum> get(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<ProEnum>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if (StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr, request.getKeystr());
                    }
                    return proEnumMapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getList(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if (StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr, request.getKeystr());
                    }
                    return proEnumMapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<ProEnum>> getPageList(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<List<ProEnum>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<ProEnum> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ProEnumRequest request = proParameter.getObj();
                    if (StringUtils.isEmpty(request.getKeystr())){
                        lambdaQueryWrapper.eq(ProEnum::getKeystr, request.getKeystr());
                    }
                    Page<ProEnum> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<ProEnum> pageResult = proEnumMapper.selectPage(page, lambdaQueryWrapper);
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
                    queryWrapper.in(ProEnum::getEnumId, proParameter.getObj().getIds());
                    return proEnumMapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum proEnum = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),proEnum);
                    return proEnumMapper.updateById(proEnum);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> save(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum proEnum = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),proEnum);
                    int resultNum = proEnumMapper.insert(proEnum);
                    serviceResponse.setInsertLastId(proEnum.getEnumId());
                    return resultNum;
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnum proEnum = new ProEnum();
                    BeanUtils.copyProperties(proParameter.getObj(),proEnum);
                    return proEnumMapper.deleteById(proEnum);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<ProEnumRequest> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ProEnumRequest request = proParameter.getObj();
                    return proEnumMapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}
