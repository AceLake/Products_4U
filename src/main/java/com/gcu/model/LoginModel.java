package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
	
	@NotNull(message="User name is a required feild")
	@Size(min=1, max=32, message="You Must have the length under 32")
	private String username;
	@NotNull(message="Password is a required feild")
	@Size(min=1, max=32, message="You Must have the length under 32")
	private String password;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
