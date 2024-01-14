package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    DataAccessInterface<OrderModel> service;
    
	@Override
	public void init() {
		System.out.println("Init from the OrdersBusnessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy from the OrdersBusnessService");
		
	}
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusnessService");

	}

	@Override
	public List<OrderModel> getOrders() {		
		return service.findAll();
	}

	@Override
	public boolean addOrder(OrderModel order) {
		return service.create(order);
	}

	@Override
	public boolean editOrder(OrderModel order) {
		return service.update(order);
	}

	@Override
	public boolean removeOrder(OrderModel order) {
		return service.delete(order);
	}

	@Override
	public OrderModel getOrderById(Long id) {
		return service.findById(id);
	}
}
