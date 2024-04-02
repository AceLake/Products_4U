package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.controller.ProductsController;
import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    DataAccessInterface<OrderModel> service;
    Logger logger = LoggerFactory.getLogger(ProductsController.class);

	@Override
	public void init() {
		logger.info("Entering " + "init" + " method in the " + "OrdersBusinessService" + " class");
		System.out.println("Init from the OrdersBusnessService");
	}
	
	@Override
	public void destroy() {
		logger.info("Entering " + "destroy" + " method in the " + "OrdersBusinessService" + " class");
		System.out.println("Destroy from the OrdersBusnessService");
		
	}
	
	@Override
	public void test() {
		logger.info("Entering " + "test" + " method in the " + "OrdersBusinessService" + " class");
		System.out.println("Hello from the OrdersBusnessService");

	}

	@Override
	public List<OrderModel> getOrders() {	
		logger.info("Entering " + "getOrders" + " method in the " + "OrdersBusinessService" + " class");	
		return service.findAll();
	}

	@Override
	public boolean addOrder(OrderModel order) {
		logger.info("Entering " + "addOrder" + " method in the " + "OrdersBusinessService" + " class");	
		return service.create(order);
	}

	@Override
	public boolean editOrder(OrderModel order) {
		logger.info("Entering " + "editOrder" + " method in the " + "OrdersBusinessService" + " class");
		return service.update(order);
	}

	@Override
	public boolean removeOrder(OrderModel order) {
		logger.info("Entering " + "removeOrder" + " method in the " + "OrdersBusinessService" + " class");
		return service.delete(order);
	}

	@Override
	public OrderModel getOrderById(Long id) {
		logger.info("Entering " + "getOrderById" + " method in the " + "OrdersBusinessService" + " class");
		return service.findById(id);
	}
}
