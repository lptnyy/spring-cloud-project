package com.wzy.pdt;

import com.wzy.common.util.ServiceResponse;
import com.wzy.pdt.hystrix.ProductServiceHystrix;
import com.wzy.pojo.Pdt;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product-service", fallback = ProductServiceHystrix.class)
public interface ProductService {

    /**
     * 添加订单信息
     * @param pdt
     * @return
     */
    public ServiceResponse update(Pdt pdt);
}
