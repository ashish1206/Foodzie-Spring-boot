package com.project.application.dao;

import java.util.List;

import com.project.application.model.Order;

public interface OrderDAO {
	public List<Order> getOrders(String email);
	
	public Order getOrderDetails(Integer orderId);
	
	public Integer placeOrder(Order order);
	
	public List<Order> getSellerOrder(String sellerEmail);
}
