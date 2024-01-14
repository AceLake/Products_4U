package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class MyTestService implements MyTestInterface {

	@Override
	public void test() {
		System.out.println("Hello from MyTestService using an interface");

	}

}
