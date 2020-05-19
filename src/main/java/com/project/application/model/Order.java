package com.project.application.model;

import java.util.Date;
import java.util.List;

public class Order {
	private Integer orderId;
	private String userEmail;
	private Integer addId;
	private List<Menu> dishes;
	private String sellerEmail;
	private String address;
	private Date date;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public List<Menu> getDishes() {
		return dishes;
	}
	public void setDishes(List<Menu> dishes) {
		this.dishes = dishes;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
