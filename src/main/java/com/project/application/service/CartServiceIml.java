package com.project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.application.dao.CartDAO;
import com.project.application.model.Cart;
import com.project.application.model.Menu;
@Service(value="cartService")
public class CartServiceIml implements CartService {

	@Autowired
	CartDAO cartDAO;
	@Override
	public List<Cart> getCartByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		List<Cart> cart = cartDAO.getCartByEmail(email);
		if(cart!=null) {
			return cart;
		}
		else {
			throw new Exception("cart not found");
		}
	}

	@Override
	public void addItemInCart(Menu dish, String email) {
		// TODO Auto-generated method stub
		cartDAO.addItemInCart(dish, email);
	}

	@Override
	public void removeItemFromCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDAO.removeItemFromCart(cart);
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		if(cart.getQuantity()==0) {
			cartDAO.removeItemFromCart(cart);
		}
		else {
			cartDAO.updateCartItem(cart);
		}
	}

}
