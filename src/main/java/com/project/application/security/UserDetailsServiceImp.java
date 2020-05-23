package com.project.application.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.application.dao.UserDAO;
import com.project.application.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserDetailsImp userDetails;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDAO.getUserByEmail(userEmail);
//		userDetails.setUsername(user.getEmail());
//		userDetails.setPassword(user.getPassword());
//		userDetails.setPhoneNumber(user.getPhoneNumber());
//		userDetails.setUsername(user.getUsername());
//		userDetails.setAddresses(user.getAddresses());
//		return userDetails;
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
