package com.project.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_user_mapping", schema = "public")
public class OrderUserMappingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_email")
	private UserEntity user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="add_id")
	private AddressEntity address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seller_email")
	private SellerEntity seller;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<OrderMenuMappingEntity> orderMenuMappingEntity;
	
	public List<OrderMenuMappingEntity> getOrderMenuMappingEntity() {
		return orderMenuMappingEntity;
	}
	public void setOrderMenuMappingEntity(List<OrderMenuMappingEntity> orderMenuMappingEntity) {
		this.orderMenuMappingEntity = orderMenuMappingEntity;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public SellerEntity getSeller() {
		return seller;
	}
	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}
	
}
