package com.project.application.service;

import java.util.List;
import com.project.application.model.Order;

public interface OrderService {
	
	public List<Order> getOrders(String email);
	
	public Order getOrderDetails(Integer orderId);
	
	public Integer placeOrder(Order order);
	
	public List<Order> getSellerOrder(String sellerEmail);
}
