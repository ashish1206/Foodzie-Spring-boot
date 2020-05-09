package com.project.application.service;

import java.util.List;

import com.project.application.model.Seller;
import com.project.application.model.Menu;

public interface SellerService {
	public Seller login(String email, String password) throws Exception;
	
	public String register(Seller user) throws Exception;
	
	public List<Menu> getMenu(String email) throws Exception;
	
	public void addMenu(String email, Menu menu);
	
	public List<Seller> getSellersByCity(String city) throws Exception;
}
