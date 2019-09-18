package com.wzy.pdt.service;

import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.ServiceResponseEnum;
import com.wzy.pdt.ProductService;
import com.wzy.pojo.Pdt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "产品接口api")
@RefreshScope
public class ProductServiceImpl implements ProductService {

    @Override
    @ApiOperation(value = "测试订单信息", notes = "就是测试接口")
    public ServiceResponse update(Pdt pdt) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(ServiceResponseEnum.SUCCESS.getValue());
        return serviceResponse;
    }
}
