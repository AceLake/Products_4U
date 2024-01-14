package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	public boolean authenticate(String username, String password) {
		System.out.println(String.format("Hello from the SecurityBusinessService with a username %s and password of %s", username, password));
		return true;
	}
}
