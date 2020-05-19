package com.project.application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.application.dao.UserDAO;
import com.project.application.model.Address;
import com.project.application.model.Seller;
import com.project.application.model.User;
import com.project.application.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserAPI {

	@Autowired
	UserService userService;
	
	static Logger logger = LogManager.getLogger(UserAPI.class);
	
	@PostMapping(value="/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		try {
			String username = user.getUsername(), password = user.getPassword(), email = user.getEmail();
			User userRes = userService.login(username, password, email);
			return new ResponseEntity<User>(userRes, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
		}
	}
	
	@PostMapping(value="/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		try {
			String username = userService.signup(user);
			return new ResponseEntity<String>(username, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
	}
	
	@PostMapping(value="/address")
	public ResponseEntity<String> addAddress(@RequestBody Address address) {
		String email = address.getEmail();
		userService.addAddress(address, email);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping(value="/changepass")
	public ResponseEntity<String> changePassword(@RequestBody User user){
		String status = userService.changePassword(user);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteadd")
	public ResponseEntity<String> deleteAddress(@RequestParam  Integer addId){
		String res = "deleted";
		userService.deleteAddress(addId);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@PutMapping(value="/updateadd")
	public ResponseEntity<String> updateAddress(@RequestBody Address address){
		String res = userService.updateAddress(address);
		return new ResponseEntity<String>("updates", HttpStatus.OK);
	}
	
	@PutMapping(value="/updatedetails")
	public ResponseEntity<String> updateUserDetails(@RequestBody User user){
		String res = userService.updateUserDetails(user);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
