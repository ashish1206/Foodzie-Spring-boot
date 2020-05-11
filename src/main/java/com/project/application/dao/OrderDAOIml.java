package com.project.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.application.entity.AddressEntity;
import com.project.application.entity.MenuEntity;
import com.project.application.entity.OrderMenuMappingEntity;
import com.project.application.entity.OrderUserMappingEntity;
import com.project.application.entity.SellerEntity;
import com.project.application.entity.UserEntity;
import com.project.application.model.Menu;
import com.project.application.model.Order;

@Repository(value="orderDAO")
public class OrderDAOIml implements OrderDAO {

	@Autowired
	EntityManager em;
	@Override
	public List<Order> getOrders(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderDetails(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer placeOrder(Order order) {
		// TODO Auto-generated method stub
		OrderUserMappingEntity oume = new OrderUserMappingEntity();
		UserEntity ue = em.find(UserEntity.class, order.getUserEmail());
		SellerEntity se = em.find(SellerEntity.class, order.getSellerEmail());
		AddressEntity ae = em.find(AddressEntity.class, order.getAddId());
		oume.setUser(ue);
		oume.setSeller(se);
		oume.setAddress(ae);
		List<OrderMenuMappingEntity> ommeList = new ArrayList<OrderMenuMappingEntity>();
		List<Menu> dishes = order.getDishes();
		for(Menu dish : dishes) {
			OrderMenuMappingEntity omme = new OrderMenuMappingEntity();
			MenuEntity me = em.find(MenuEntity.class, dish.getdId());
			omme.setDish(me);
			omme.setQuantity(dish.getQuantity());
			omme.setTotalPrice(me.getPrice()*dish.getQuantity());
			ommeList.add(omme);
		}
		oume.setOrderMenuMappingEntity(ommeList);
		em.persist(oume);
		return oume.getOrderId();
	}

}
