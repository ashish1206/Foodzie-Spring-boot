package com.project.application.model;

public class AuthenticationResponse {
	public String jwt;
	
	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
}
