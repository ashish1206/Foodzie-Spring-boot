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
@Table(name="order")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordeId;
	private Integer quantity;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	private MenuEntity dish;
	public Integer getOrdeId() {
		return ordeId;
	}
	public void setOrdeId(Integer ordeId) {
		this.ordeId = ordeId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public MenuEntity getDish() {
		return dish;
	}
	public void setDish(MenuEntity dish) {
		this.dish = dish;
	}
	
}
