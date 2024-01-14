package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessInterface {
	public void test();
	public List<OrderModel> getOrders();
	public OrderModel getOrderById(Long id);
	public boolean addOrder(OrderModel order);
	public boolean editOrder(OrderModel order);
	public boolean removeOrder(OrderModel order);
	void init();
	public void destroy();
}
