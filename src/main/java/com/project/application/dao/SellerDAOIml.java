package com.project.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.application.entity.AddressEntity;
import com.project.application.entity.MenuEntity;
import com.project.application.entity.SellerEntity;
import com.project.application.model.Address;
import com.project.application.model.Menu;
import com.project.application.model.Seller;

@Repository(value="sellerDAO")
public class SellerDAOIml implements SellerDAO{

	@Autowired
	EntityManager em;
	@Override
	public Seller checkLogin(String email, String password) {
		String sql = "select s from SellerEntity s where s.email = '" + email + "' and s.password = '" +  password + "'";
		SellerEntity se  = em.createQuery(sql, SellerEntity.class).getSingleResult();
		Seller seller = new Seller();
		if(se != null) {
			seller.setsName(se.getsName());
			seller.setEmail(se.getEmail());
			seller.setPhoneNumber(se.getPhoneNumber());
			AddressEntity ae = se.getAddress();
			if(ae != null) {
				Address address = new Address();
				address.setAddressLine1(ae.getAddressLine1());
				address.setAddressLine2(ae.getAddressLine2());
				address.setCity(ae.getCity());
				address.setPin(ae.getPin());
				address.setState(ae.getState());
				seller.setAddress(address);
			}
			else {
				seller.setAddress(null);
			}
			return seller;
			
		}
		else {
			return null;
		}
	}

	@Override
	public String addSeller(Seller seller) {
		// TODO Auto-generated method stub
		SellerEntity se = new SellerEntity();
		se.setEmail(seller.getEmail());
		se.setsName(seller.getsName());
		se.setPassword(seller.getPassword());
		se.setPhoneNumber(seller.getPhoneNumber());
		AddressEntity ae = new AddressEntity();
		Address address = seller.getAddress();
		ae.setAddressLine1(address.getAddressLine1());
		ae.setAddressLine2(address.getAddressLine2());
		ae.setCity(address.getCity());
		ae.setPin(address.getPin());
		ae.setState(address.getState());
		se.setAddress(ae);
		em.persist(se);
		return se.getsName();
	}

	@Override
	public List<Menu> getMenu(String email) {
		// TODO Auto-generated method stub
		SellerEntity se = em.find(SellerEntity.class, email);
		List<MenuEntity> me = se.getMenu();
		if(me != null) {
			List<Menu> menuList = new ArrayList<Menu>();
			for(MenuEntity menuEntity : me) {
				Menu menu = new Menu();
				menu.setDishName(menuEntity.getDishName());
				menu.setDescription(menuEntity.getDescription());
				menu.setPrice(menuEntity.getPrice());
				menuList.add(menu);
			}
			return menuList;
		}
		else {
			return null;
		}
	}

	@Override
	public void addMenu(String email, Menu menu) {
		// TODO Auto-generated method stub
		SellerEntity se = em.find(SellerEntity.class, email);
		List<MenuEntity> meList = se.getMenu();
		MenuEntity me = new MenuEntity();
		me.setDishName(menu.getDishName());
		me.setDescription(menu.getDescription());
		me.setPrice(menu.getPrice());
		meList.add(me);
	}
	
	@Override
	public List<Seller> getSellersByCity(String city) {
		// TODO Auto-generated method stub
		String sql ="select s from SellerEntity s join s.address a where a.city = '"+ city +"'";
//		String sql = "select s from SellerEntity s where s. = '" + city + "'";
		List<SellerEntity> se = em.createQuery(sql, SellerEntity.class).getResultList();
		List<Seller> sellers = new ArrayList<Seller>();
		for(SellerEntity sellerEntity : se) {
			Seller seller = new Seller();
			seller.setEmail(sellerEntity.getEmail());
			seller.setsName(sellerEntity.getsName());
			seller.setPhoneNumber(sellerEntity.getPhoneNumber());
			AddressEntity ae = sellerEntity.getAddress();
			Address address = new Address();
			address.setAddressLine1(ae.getAddressLine1());
			address.setAddressLine2(ae.getAddressLine2());
			address.setCity(ae.getCity());
			address.setPin(ae.getPin());
			address.setState(ae.getState());
			seller.setAddress(address);
			sellers.add(seller);
		}
		return sellers;
	}
}
