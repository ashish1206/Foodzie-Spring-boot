package com.project.application.service;

import java.util.List;

import com.project.application.model.Cart;
import com.project.application.model.Menu;

public interface CartService {

	public List<Cart> getCartByEmail(String email) throws Exception;
	
	public void addItemInCart(Menu dish, String email);
	
	public void removeItemFromCart(Cart cart);
	
	public void updateCart(Cart cart);
}
