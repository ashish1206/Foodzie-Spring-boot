package com.project.application.service;


import com.project.application.model.Address;
import com.project.application.model.User;

public interface UserService {
	
	public User login(String username, String password, String email) throws Exception;
	
	public String signup(User user) throws Exception;
	
	public void addAddress(Address address, String email);

}
