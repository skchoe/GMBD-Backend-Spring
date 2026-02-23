package com.ctd.gmbd.simple.restcontroller;

import java.util.List;

public class AuthResponse {
	
	private List<String> authNames;
	private String message;
	
	public AuthResponse(List<String> authNames, String msg) {
		super();
		this.authNames = authNames;
		this.message = msg;
	}

	public List<String> getAuthNames() {
		return authNames;
	}

	public void setAuthNames(List<String> authNames) {
		this.authNames = authNames;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
