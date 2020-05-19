package com.project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.model.Order;
import com.project.application.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping(value="/order")
public class OrderAPI {

	@Autowired
	OrderService orderService;
	@GetMapping(value="/getorder")
	public ResponseEntity<List<Order>> getOrders(@RequestParam String userEmail){
		List<Order> orders = orderService.getOrders(userEmail);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value="/getsellerorder")
	public ResponseEntity<List<Order>> getSellerOrder(@RequestParam String sellerEmail){
		List<Order> orders = orderService.getSellerOrder(sellerEmail);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value="/orderbyid")
	public ResponseEntity<Order> getOrderDetails(@RequestParam Integer orderId){
		return null;
	}
	
	@PostMapping(value="/placeorder")
	public ResponseEntity<Integer> placeOrder(@RequestBody Order order) {
		Integer orderId = orderService.placeOrder(order);
		return new ResponseEntity<Integer>(orderId, HttpStatus.OK);
	}
}
