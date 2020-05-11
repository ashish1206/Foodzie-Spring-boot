package com.project.application.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.application.model.Order;

public class OrderDAOIml implements OrderDAO {

	@Autowired
	EntityManager em;
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
