package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;


@Configuration
public class SpringConfig {

    // @Bean in SpringConfig to call init/destroy methods
    @Bean(
        name = "ordersBusinessService",
        initMethod = "init",
        destroyMethod = "destroy"
    )

    public OrdersBusinessServiceInterface getOrdersBusiness() {
        return new OrdersBusinessService();

        // later swap to: return new AnotherOrdersBusinessService();
    }
}
