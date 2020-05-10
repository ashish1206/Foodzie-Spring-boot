package com.project.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class UserCartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	private Integer quantity;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	private MenuEntity menu;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public MenuEntity getMenu() {
		return menu;
	}
	public void setMenu(MenuEntity menu) {
		this.menu = menu;
	}
	
}
