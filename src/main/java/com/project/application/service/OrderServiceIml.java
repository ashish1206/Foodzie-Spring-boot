package com.project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.application.dao.OrderDAO;
import com.project.application.model.Order;

public class OrderServiceIml implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	@Override
	public List<Order> getOrders(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderDetails(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer placeOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
