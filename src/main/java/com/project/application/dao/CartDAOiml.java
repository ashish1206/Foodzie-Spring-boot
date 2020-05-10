package com.project.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.application.entity.MenuEntity;
import com.project.application.entity.UserCartEntity;
import com.project.application.entity.UserEntity;
import com.project.application.model.Cart;
import com.project.application.model.Menu;

@Repository(value="cartDAO")
public class CartDAOiml implements CartDAO {

	@Autowired
	EntityManager em;
	@Override
	public List<Cart> getCartByEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity ue = em.find(UserEntity.class, email);
		List<UserCartEntity> uce = ue.getCart();
		List<Cart> cart = new ArrayList<Cart>();
		for(UserCartEntity entityItem :  uce) {
			Cart cartItem = new Cart();
			cartItem.setQuantity(entityItem.getQuantity());
			MenuEntity me = entityItem.getMenu();
			Menu dish = new Menu();
			dish.setDishName(me.getDishName());
			dish.setDescription(me.getDescription());
			dish.setPrice(me.getPrice());
			dish.setdId(me.getdId());
			cartItem.setDish(dish);
			cartItem.setTotalAmount(dish.getPrice()*cartItem.getQuantity());
			cartItem.setCartId(entityItem.getCartId());
			cart.add(cartItem);
		}
		return cart;
	}

	@Override
	public void addItemInCart(Menu dish, String email) {
		// TODO Auto-generated method stub
		UserEntity ue = em.find(UserEntity.class, email);
		List<UserCartEntity> uceList = ue.getCart();
		UserCartEntity uce = new UserCartEntity();
		MenuEntity menuEntity = new MenuEntity();
		menuEntity.setDishName(dish.getDishName());
		menuEntity.setDescription(dish.getDescription());
		menuEntity.setPrice(menuEntity.getPrice());
		uce.setMenu(menuEntity);
		uce.setQuantity(dish.getQuantity());
		uceList.add(uce);
	}

	@Override
	public void removeItemFromCart(Cart cart) {
		// TODO Auto-generated method stub
		UserCartEntity uce =em.find(UserCartEntity.class, cart.getCartId());
		em.remove(uce);
	}

	@Override
	public void updateCartItem(Cart cart) {
		// TODO Auto-generated method stub
		UserCartEntity uce = em.find(UserCartEntity.class, cart.getCartId());
		uce.setQuantity(cart.getQuantity());
	}


}
