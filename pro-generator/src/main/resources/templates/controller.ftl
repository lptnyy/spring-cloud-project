package ${genpkg};
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import ${serviceClassPath};
import ${dtoClassPath};
import ${requestClassPath};
import ${voClassPath};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@RestController
@RequestMapping(value = "${smClassName}")
@Api(value = "${className}Controller", description = "${tableComment}")
public class ${className}Controller {

    @Autowired
    I${className}Service ${smClassName}Service;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    public ServiceResponse<List<${className}Vo>> getPageList(@RequestBody ${className}Request request){
        return new ServiceResponse<List<${className}Vo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<${className}>> response = ${smClassName}Service.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<${className}> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<${className}Vo> returnList = resultList.stream()
                            .map(${smClassName} -> {
                                ${className}Vo ${smClassName}vo = new ${className}Vo();
                                BeanUtils.copyProperties(${smClassName},${smClassName}vo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return ${smClassName}vo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    public ServiceResponse<${className}Vo> get(@RequestBody ${className}Request request){
        return new ServiceResponse<${className}Vo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<${className}> response = ${smClassName}Service.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 组装返回的vo
                    ${className} ${smClassName} = response.getObj();
                    ${className}Vo ${smClassName}Vo = new ${className}Vo();
                    BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
                    return ${smClassName}Vo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    public ServiceResponse<${className}Vo> save(@RequestBody ${className}Request request){
        return new ServiceResponse<${className}Vo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<${className}> response = ${smClassName}Service.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    // 获取返回结果 包括数据库插入id
                    ${className} ${smClassName} = ${smClassName}Service.save(new ProParameter<>(request)).getObj();
                    ${className}Vo ${smClassName}Vo = new ${className}Vo();
                    BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
                    return ${smClassName}Vo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    public ServiceResponse<Integer> idsDelete(@RequestBody ${className}Request request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "批量删除")
    public ServiceResponse<Integer> delete(@RequestBody ${className}Request request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    public ServiceResponse<Integer> update(@RequestBody ${className}Request request){
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.copyState(serviceResponse);

                    return response.getObj();
                })
                .exec();
    }
}
