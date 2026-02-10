package com.gcu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.OrdersDataService;
import com.gcu.model.OrderModel;

@Configuration
public class SpringConfig {

    // @Bean in SpringConfig to call init/destroy methods
    @Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")

    public OrdersBusinessServiceInterface getOrdersBusiness() {
        return new OrdersBusinessService();

        // later swap to: return new AnotherOrdersBusinessService();
    }

    @Bean
    public DataAccessInterface<OrderModel> ordersDataService(DataSource dataSource) {
        return new OrdersDataService(dataSource);
    }

}
