package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.controller.ProductsController;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

    @SuppressWarnings("unused")
    @Autowired
    private DataSource dataSource;
    @SuppressWarnings("unused")
    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    
    Logger logger = LoggerFactory.getLogger(ProductsController.class);

    public OrdersDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<OrderModel> findAll() {
        logger.info("Entering " + "findAll" + " method in the " + "OrdersDataService" + " class");
        String sql = "SELECT * FROM ORDERS";
        List<OrderModel> orders = new ArrayList<OrderModel>();
        try 
        {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while(srs.next()) 
            {
                orders.add(new OrderModel(srs.getLong("ID"),
                                          srs.getString("ORDER_NO"),
                                          srs.getString("PRODUCT_NAME"),
                                          srs.getFloat("PRICE"),
                                          srs.getInt("QUANTITY")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel findById(Long id) {
        logger.info("Entering " + "findById" + " method in the " + "OrdersDataService" + " class");
        String sql = "SELECT * FROM ORDERS WHERE ID = ?";
        
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
    
            if (srs.next()) {
                OrderModel order = new OrderModel(
                        srs.getLong("ID"),
                        srs.getString("ORDER_NO"),
                        srs.getString("PRODUCT_NAME"),
                        srs.getFloat("PRICE"),
                        srs.getInt("QUANTITY")
                );
                return order;
            } else {
                // Handle the case where no order with the given ID was found
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    @Override
    public boolean create(OrderModel order) {
        logger.info("Entering " + "create" + " method in the " + "OrdersDataService" + " class");
        String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME,PRICE,QUANTITY) VALUES(?,?,?,?)";
        try 
        {
            int rows = jdbcTemplateObject.update(sql,
                                                    order.getOrderNo(),
                                                    order.getProductName(),
                                                    order.getPrice(),
                                                    order.getQuantity());
            return rows == 1 ? true : false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean update(OrderModel order) {
        logger.info("Entering " + "update" + " method in the " + "OrdersDataService" + " class");
        String sql = "UPDATE ORDERS SET ORDER_NO = ?, PRODUCT_NAME = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";
        try {
            int rows = jdbcTemplateObject.update(sql,
                    order.getOrderNo(),
                    order.getProductName(),
                    order.getPrice(),
                    order.getQuantity(),
                    order.getId());
            return rows == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(OrderModel order) {
        logger.info("Entering " + "delete" + " method in the " + "OrdersDataService" + " class");
        String sql = "DELETE FROM ORDERS WHERE ID = ?";
        try {
            int rows = jdbcTemplateObject.update(sql, order.getId());
            return rows == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
