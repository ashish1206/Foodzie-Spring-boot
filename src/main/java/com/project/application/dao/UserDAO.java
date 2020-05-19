package com.project.application.dao;

import java.util.List;

import com.project.application.model.Address;
import com.project.application.model.Seller;
import com.project.application.model.User;

public interface UserDAO {
	public User checkLogin(String username, String password, String email);
	
	public String addUser(User user);
	
	public void addUserAddress(Address address, String email);
	
	public void changePassword(User user);
	
	public void updateAddress(Address address);

	public void deleteAddress(Integer addId);
}
