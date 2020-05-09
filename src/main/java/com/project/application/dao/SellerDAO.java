package com.project.application.dao;

import java.util.List;

import com.project.application.model.Seller;
import com.project.application.model.Menu;

public interface SellerDAO {
	public Seller checkLogin(String email, String password);
	
	public String addSeller(Seller seller);
	
	public List<Menu> getMenu(String email);
	
	public void addMenu(String email, Menu menu);
	
	public List<Seller> getSellersByCity(String city);
}
