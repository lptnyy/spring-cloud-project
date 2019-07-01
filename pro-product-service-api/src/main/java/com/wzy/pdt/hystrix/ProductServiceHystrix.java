package com.wzy.pdt.hystrix;

import com.wzy.pdt.ProductService;
import com.wzy.pojo.Pdt;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceHystrix implements ProductService {

    @Override
    public int update(Pdt pdt){
        return 0;
    }
}
