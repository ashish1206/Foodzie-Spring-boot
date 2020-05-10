package com.project.application.dao;

import java.util.List;

import com.project.application.model.Cart;
import com.project.application.model.Menu;

public interface CartDAO {

	public List<Cart> getCartByEmail(String email);
	
	public void addItemInCart(Menu dish, String email);
	
	public void removeItemFromCart(Cart cart);
	
	public void updateCartItem(Cart cart);
}
