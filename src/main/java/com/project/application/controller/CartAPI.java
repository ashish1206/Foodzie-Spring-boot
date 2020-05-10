package com.project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.application.model.Cart;
import com.project.application.model.Menu;
import com.project.application.service.CartService;

@RestController
@RequestMapping(value="/cart")
public class CartAPI {

	@Autowired
	CartService cartService;
	
	@GetMapping(value="/getcart")
	public ResponseEntity<List<Cart>> getCartByEmail(@RequestParam String email){
		try {
			List<Cart> cart = cartService.getCartByEmail(email);
			return new ResponseEntity<List<Cart>>(cart, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PutMapping(value="/additem")
	public ResponseEntity<String> addItemInCart(@RequestBody Menu dish, @RequestParam String email){
		cartService.addItemInCart(dish, email);
		return new ResponseEntity<String>("add item in cart", HttpStatus.OK);
	}
	
	@PutMapping(value="/updatecart")
	public ResponseEntity<String> updateCart(@RequestBody Cart cart){
		cartService.updateCart(cart);
		return new ResponseEntity<String>("updated cart", HttpStatus.OK);
	}
	
	@PutMapping(value="/removeitem")
	public ResponseEntity<String> removeItemFromCart(@RequestBody Cart cart){
		cartService.removeItemFromCart(cart);
		return new ResponseEntity<String>("item removed", HttpStatus.OK);
	}
}
