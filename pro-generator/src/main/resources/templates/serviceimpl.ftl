package ${genpkg};
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
import ${dtoClassPath};
import ${requestClassPath};
import ${serviceClassPath};
import ${mapperClassPath};

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@RestController
@Api(value = "${className}ServiceImpl", description = "${tableComment}")
public class ${className}ServiceImpl implements I${className}Service {

    @Resource
    ${className}Mapper mapper;

    @Override
    public ServiceResponse<${className}> get(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<${className}>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<${className}> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ${className}Request request = proParameter.getObj();
                    <#list fields as field>
                    <#if field.type == 'String'>
                    if(!StringUtils.isEmpty(request.get${field.fieldName2}())){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                    <#else >
                    if(request.get${field.fieldName2}() != null){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                    </#if>
                    </#list>
                    lambdaQueryWrapper.orderByDesc(${className}::getCreateTime);
                    return mapper.selectOne(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<${className}>> getList(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<List<${className}>>()
                .run((serviceResponse) -> {
                    LambdaQueryWrapper<${className}> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ${className}Request request = proParameter.getObj();
         <#list fields as field>
             <#if field.type == 'String'>
                    if(!StringUtils.isEmpty(request.get${field.fieldName2}())){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
             <#else >
                    if(request.get${field.fieldName2}() != null){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
             </#if>
         </#list>
                    lambdaQueryWrapper.orderByDesc(${className}::getCreateTime);
                    return mapper.selectList(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<List<${className}>> getPageList(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<List<${className}>>()
                .run((serviceResponse -> {
                    LambdaQueryWrapper<${className}> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ${className}Request request = proParameter.getObj();
             <#list fields as field>
                 <#if field.type == 'String'>
                    if(!StringUtils.isEmpty(request.get${field.fieldName2}())){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                 <#else >
                    if(request.get${field.fieldName2}() != null){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                 </#if>
             </#list>
                    lambdaQueryWrapper.orderByDesc(${className}::getCreateTime);
                    Page<${className}> page = new Page<>(proParameter.getRequestPage().getPageNum(),proParameter.getRequestPage().getPageSize());
                    IPage<${className}> pageResult = mapper.selectPage(page, lambdaQueryWrapper);
                    serviceResponse.setPageNo(proParameter.getRequestPage().getPageNum())
                            .setPageSize(proParameter.getRequestPage().getPageSize())
                            .setCount(pageResult.getTotal())
                            .setPages(pageResult.getPages());
                    return pageResult.getRecords();
                })).exec();
    }

    @Override
    public ServiceResponse<List<${className}>> findIdsList(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<List<${className}>>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<${className}> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.orderByDesc(${className}::getCreateTime);
                    return mapper.selectList(queryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ${className} bean = new ${className}();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    return mapper.updateById(bean);
                }).exec();
    }

    @Override
    public ServiceResponse<${className}> save(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<${className}>()
                .run(serviceResponse -> {
                    ${className} bean = new ${className}();
                    BeanUtils.copyProperties(proParameter.getObj(),bean);
                    mapper.insert(bean);
                    return bean;
                }).exec();
    }

    @Override
    public ServiceResponse<List<${className}>> batchSave(ProParameter<List<${className}Request>> proParameter) {
       return new ServiceResponse<List<${className}>>()
               .run(serviceResponse -> {
                   List<${className}> roles = proParameter.getObj()
                       .stream()
                       .map(${smClassName}Request -> {
                            ${className} ${smClassName} = new ${className}();
                            BeanUtils.copyProperties(${smClassName}Request, ${smClassName});
                            mapper.insert(${smClassName});
                            return ${smClassName};
                       }).collect(Collectors.toList());
                   return roles;
               }).exec();
     }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    LambdaQueryWrapper<${className}> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                    ${className}Request request = proParameter.getObj();
             <#list fields as field>
                 <#if field.type == 'String'>
                    if(!StringUtils.isEmpty(request.get${field.fieldName2}())){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                 <#else >
                    if(request.get${field.fieldName2}() != null){
                        lambdaQueryWrapper.eq(${className}::get${field.fieldName2},request.get${field.fieldName2}());
                    }
                 </#if>
             </#list>
                    return mapper.delete(lambdaQueryWrapper);
                }).exec();
    }

    @Override
    public ServiceResponse<Integer> idsDelete(ProParameter<${className}Request> proParameter) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {
                    ${className}Request request = proParameter.getObj();
                    return mapper.deleteBatchIds(request.getIds());
                }).exec();
    }
}
