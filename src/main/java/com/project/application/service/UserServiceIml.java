package com.project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.application.dao.UserDAO;
import com.project.application.model.Address;
import com.project.application.model.Seller;
import com.project.application.model.User;

@Service(value="userService")
@Transactional
public class UserServiceIml implements UserService {

	@Autowired
	UserDAO userDAO;
	@Override
	public User login(String username, String password, String email) throws Exception {
		// TODO Auto-generated method stub
		User user = userDAO.checkLogin(username, password, email);
		if(user != null) {
			return user;
		}
		else {
			throw new Exception("Incorrect username or password");
		}
	}

	@Override
	public String signup(User user) throws Exception {
		// TODO Auto-generated method stub
		String username = userDAO.addUser(user);
		if(username != null) {
			return username;
		}
		else {
			throw new Exception("Couldn't create user at this movement");
		}
	}

	@Override
	public void addAddress(Address address, String email) {
		// TODO Auto-generated method stub
		userDAO.addUserAddress(address, email);
	}
	
}
