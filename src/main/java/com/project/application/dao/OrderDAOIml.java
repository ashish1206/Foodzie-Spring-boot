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
import com.project.application.model.Address;
import com.project.application.model.Menu;
import com.project.application.model.Order;

@Repository(value="orderDAO")
public class OrderDAOIml implements OrderDAO {

	@Autowired
	EntityManager em;
	@Override
	public List<Order> getOrders(String email) {
		// TODO Auto-generated method stub
//		String sql = "select o from order_user_mapping o where o.user_email = '" + email +"'";
//		List<OrderUserMappingEntity> oumeList = em.createQuery(sql, OrderUserMappingEntity.class).getResultList();
		UserEntity ue = em.find(UserEntity.class, email);
		List<OrderUserMappingEntity> oumeList =  ue.getOrders();
		List<Order> orders = new ArrayList<Order>();
		for( OrderUserMappingEntity oume : oumeList) {
			Order order = new Order();
			order.setSellerEmail(oume.getSeller().getEmail());
			List<Menu> dishes = new ArrayList<Menu>();
			List<OrderMenuMappingEntity> ommeList = oume.getOrderMenuMappingEntity();
			for(OrderMenuMappingEntity omme : ommeList) {
				MenuEntity me = omme.getDish();
				Menu dish = new Menu();
				dish.setdId(me.getdId());
				dish.setDishName(me.getDishName());
				dish.setDescription(me.getDescription());
				dish.setQuantity(omme.getQuantity());
				dish.setPrice(me.getPrice());
				dishes.add(dish);
			}
			order.setDishes(dishes);
			AddressEntity ae = oume.getAddress();
			Address address = new Address();
			if(ae !=null) {
				address.setAddressLine1(ae.getAddressLine1());
				address.setAddressLine2(ae.getAddressLine2());
				address.setCity(ae.getCity());
				address.setPin(ae.getPin());
				address.setState(ae.getState());
				order.setAddress(address);
			}
			orders.add(order);
		}
		return orders;
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

	@Override
	public List<Order> getSellerOrder(String sellerEmail) {
		// TODO Auto-generated method stub
		SellerEntity se = em.find(SellerEntity.class, sellerEmail);
		List<OrderUserMappingEntity> oumeList = se.getOrdersUserMappingEntity();
		List<Order> orders = new ArrayList<Order>();
		for(OrderUserMappingEntity oume : oumeList) {
			Order order = new Order();
			order.setUserEmail(oume.getUser().getEmail());
			List<OrderMenuMappingEntity> ommeList = oume.getOrderMenuMappingEntity();
			List<Menu> dishes = new ArrayList<Menu>();
			for(OrderMenuMappingEntity omme : ommeList) {
				MenuEntity me = omme.getDish();
				Menu dish = new Menu();
				dish.setdId(me.getdId());
				dish.setDishName(me.getDishName());
				dish.setPrice(me.getPrice());
				dish.setQuantity(omme.getQuantity());
				dishes.add(dish);
			}
			order.setDishes(dishes);
			orders.add(order);
		}
		return orders;
	}

}
