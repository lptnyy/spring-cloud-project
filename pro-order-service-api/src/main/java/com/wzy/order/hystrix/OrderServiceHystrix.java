package com.wzy.order.hystrix;
        import com.wzy.common.util.ServiceResponse;
        import com.wzy.order.OrderService;
        import com.wzy.pojo.Order;
        import org.springframework.stereotype.Component;

@Component
public class OrderServiceHystrix implements OrderService {

    @Override
    public ServiceResponse addOrder(Order order) {
        return ServiceResponse.getFAIL();
    }
}