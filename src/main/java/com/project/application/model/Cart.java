package com.project.application.model;

public class Cart {
	private Integer cartId;
	private Integer quantity;
	private Menu dish;
	private Double totalAmount;
	public Integer getQuantity() {
		return quantity;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Menu getDish() {
		return dish;
	}
	public void setDish(Menu dish) {
		this.dish = dish;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
