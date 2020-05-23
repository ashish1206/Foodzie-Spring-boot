package com.project.application.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.application.dao.SellerDAO;
import com.project.application.model.Address;
import com.project.application.model.Menu;
import com.project.application.model.Seller;

@Service(value="sellerService")
@Transactional
public class SellerServiceIml implements SellerService {

	@Autowired
	SellerDAO sellerDAO;
	@Override
	public Seller login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		Seller seller = sellerDAO.checkLogin(email, password);
		if(seller!=null) {
			return seller;
		}
		else {
			throw new Exception("Invaild username or password");
		}
	}

	@Override
	public String register(Seller seller) throws Exception {
		// TODO Auto-generated method stub
		String sName = sellerDAO.addSeller(seller);
		if(sName != null) {
			return sName;
		}
		else {
			throw new Exception("Couldn't create user at this movement");
		}
	}

	@Override
	public List<Menu> getMenu(String email) throws Exception {
		// TODO Auto-generated method stub
		List<Menu> menu = sellerDAO.getMenu(email);
		if(menu != null) {
			return menu;
		}
		else {
			throw new Exception("Menu empty");
		}
	}

	@Override
	public void addMenu(String email, Menu menu) {
		// TODO Auto-generated method stub
		sellerDAO.addMenu(email, menu);
		
	}

	@Override
	public List<Seller> getSellersByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		List<Seller> sellers = sellerDAO.getSellersByCity(city);
		if(sellers != null) {
			return sellers;
		}
		else {
			throw new Exception("sellers not found");
		}
	}

	@Override
	public String updateAddress(Address address) {
		// TODO Auto-generated method stub
		String res = sellerDAO.updateAddress(address);
		return res;
	}

	@Override
	public String changePassword(Seller seller) {
		// TODO Auto-generated method stub
		sellerDAO.changePassword(seller);
		return "password updated";
	}

	@Override
	public String updateSellerDetails(Seller seller) {
		// TODO Auto-generated method stub
		sellerDAO.updateSellerDetails(seller);
		return "details updated";
	}
}
