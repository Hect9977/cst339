package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.OrderModel;

public class OrdersDataService {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplateObject;

    // Non-Default Constructor to initialize the DataSource and JdbcTemplate
    public OrdersDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // Implementing the Data Access Interface methods for OrderModel
    public List<OrderModel> findAll() {
        String sql = "SELECT * FROM ORDERS";
        List<OrderModel> orders = new ArrayList<>();

        try {
            // Execute the SQL query and process the results
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                OrderModel order = new OrderModel(
                        srs.getInt("ID"),
                        srs.getString("ORDER_NO"),
                        srs.getString("PRODUCT_NAME"),
                        srs.getFloat("PRICE"),
                        srs.getInt("QUANTITY"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Placeholder for findById implementation
    public OrderModel findById(int id) {
        return null; // Placeholder for findById implementation
    }

    // Implementing the create method to insert a new order into the database
    public boolean create(OrderModel order) {
        String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(),
                    order.getQuantity());

            // Return true if one row was inserted, otherwise return false
            return rows == 1 ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Placeholder for update implementation
    public boolean update(OrderModel order) {
        return true; // For now
    }

    // Placeholder for delete implementation
    public boolean delete(OrderModel order) {
        return true; // For now
    }
}
