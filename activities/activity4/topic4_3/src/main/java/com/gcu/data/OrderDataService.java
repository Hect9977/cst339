package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    // Keeping the repository for reads (findAll)
    private final OrdersRepository ordersRepository;

    // Adding DataSource + JdbcTemplate
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplateObject;

    // The Constructor injection for both Repository + DataSource
    public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // Overriding findById() and findAll() to use Repository
    @Override
    public OrderEntity findById(int id) {
        return null; // for now
    }

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<>();

        try {
            // If you completed Step 2 and changed repository to return List<OrderEntity>, this works:
            Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
            orderIterable.forEach(orders::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    // Overriding create() to use JdbcTemplate + SQL
    @Override
    public boolean create(OrderEntity order) {
        try {
            // Using JdbcTemplate to execute an INSERT statement
            String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";

            int rows = jdbcTemplateObject.update(
                sql,
                order.getOrderNo(),
                order.getProductName(),
                order.getPrice(),
                order.getQuantity()
            );

            return rows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // For now, update and delete can just return true as placeholders
    @Override
    public boolean update(OrderEntity t) {
        return true; 
    }

    @Override
    public boolean delete(OrderEntity t) {
        return true;
    }
}
