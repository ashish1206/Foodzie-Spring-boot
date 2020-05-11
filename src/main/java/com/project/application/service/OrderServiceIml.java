package com.project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.application.dao.OrderDAO;
import com.project.application.model.Order;

@Service(value="orderService")
@Transactional
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
		return orderDAO.placeOrder(order);
	}

}
