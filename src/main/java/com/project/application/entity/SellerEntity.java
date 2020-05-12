package com.project.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.project.application.model.Order;


@Entity
@Table(name="seller", schema = "public")
public class SellerEntity {
	@Id
	private String email;
	private String sName;
	private String password;
	private String phoneNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="add_id", unique = true)
	private AddressEntity address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "email", unique = true)
	private List<MenuEntity> menu;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="seller_email")
	private List<OrderUserMappingEntity> ordersUserMappingEntity;
	
	public List<OrderUserMappingEntity> getOrdersUserMappingEntity() {
		return ordersUserMappingEntity;
	}
	public void setOrdersUserMappingEntity(List<OrderUserMappingEntity> ordersUserMappingEntity) {
		this.ordersUserMappingEntity = ordersUserMappingEntity;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public List<MenuEntity> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuEntity> menu) {
		this.menu = menu;
	}
	
}
