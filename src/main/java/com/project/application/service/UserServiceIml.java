package com.project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.application.dao.SellerDAO;
import com.project.application.dao.UserDAO;
import com.project.application.model.Address;
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

	@Override
	public String changePassword(User user) {
		// TODO Auto-generated method stub
		userDAO.changePassword(user);
		return "success";
	}

	@Override
	public String updateAddress(Address address) {
		// TODO Auto-generated method stub
		userDAO.updateAddress(address);
		return "updated";
	}

	@Override
	public void deleteAddress(Integer addId) {
		// TODO Auto-generated method stub
		userDAO.deleteAddress(addId);
	}

	@Override
	public String updateUserDetails(User user) {
		// TODO Auto-generated method stub
		userDAO.updateUserDetails(user);
		return "updated";
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User user = userDAO.getUserByEmail(userEmail);
		return user;
	}

	@Override
	public User getUserDetailsByUseremail(String userEmail) {
		// TODO Auto-generated method stub
		return userDAO.getUserDetailsByUseremail(userEmail);
	}
	
}
