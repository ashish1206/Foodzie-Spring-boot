package com.project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.application.model.Seller;
import com.project.application.model.Address;
import com.project.application.model.Menu;
import com.project.application.service.SellerService;

@CrossOrigin
@RestController
@RequestMapping(value="/seller")
public class SellerAPI {
	@Autowired
	SellerService sellerService;
	
	@PostMapping(value="/login")
	public ResponseEntity<Seller> login(@RequestBody Seller seller) {
		try {
			String email,password;
			email = seller.getEmail();
			password = seller.getPassword();
			Seller sellerRes = sellerService.login(email, password);
			return new ResponseEntity<Seller>(sellerRes, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
		}
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<String> register(@RequestBody Seller seller) {
		try {
			String sNameRes = sellerService.register(seller);
			return new ResponseEntity<String>(sNameRes, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
	}
	
	@GetMapping(value="/menu")
	public ResponseEntity<List<Menu>> getMenu(@RequestParam String email){
		try {
			List<Menu> menu = sellerService.getMenu(email);
			return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PutMapping(value="/addmenu")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu){
		String email = menu.getEmail();
		sellerService.addMenu(email, menu);
		return new ResponseEntity<String>("updated", HttpStatus.OK);
	}
	
	@GetMapping(value="/getsellers")
	public ResponseEntity<List<Seller>> getSellersByCity(@RequestParam String city){
		try {
			List<Seller> sellers = sellerService.getSellersByCity(city);
			return new ResponseEntity<List<Seller>>(sellers, HttpStatus.OK);
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PutMapping(value="/address")
	public ResponseEntity<String> updateAddress(@RequestBody Address address) {
		String res = sellerService.updateAddress(address);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@PutMapping(value="/changepass")
	public ResponseEntity<String> changePassword(@RequestBody Seller seller){
		String res = sellerService.changePassword(seller);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@PutMapping(value="/updatedetails")
	public ResponseEntity<String> updateSellerDetails(@RequestBody Seller seller){
		String res = sellerService.updateSellerDetails(seller);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
