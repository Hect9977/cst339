package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.OrderEntity;

// This class implements the RowMapper interface to map rows of a ResultSet to OrderEntity objects.
public class OrderRowMapper implements RowMapper<OrderEntity> {

    // The mapRow method is called for each row in the ResultSet and is responsible for creating an OrderEntity object from the current row's data.
    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderEntity(
            rs.getLong("ID"),
            rs.getString("ORDER_NO"),
            rs.getString("PRODUCT_NAME"),
            rs.getFloat("PRICE"),
            rs.getInt("QUANTITY")
        );
    }
}
