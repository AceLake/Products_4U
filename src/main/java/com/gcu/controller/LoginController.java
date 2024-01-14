package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.MyTestInterface;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	// this is loosely coupled
	@Autowired
	public OrdersBusinessInterface service;
	@Autowired
	public SecurityBusinessService security;
	@Autowired
	private MyTestInterface serviceTest;
	
	
	@GetMapping("/")
	public String display(Model model) {
		System.out.println("Here");
		model.addAttribute("title","Login Form");
		model.addAttribute("loginModel",new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		service.test();
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		serviceTest.test();
		
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");
			return "Login";
		}
		
		List<OrderModel> orders = service.getOrders();
		
		model.addAttribute("title","My Orders");
		model.addAttribute("orders", orders);
		return "orders";
	}
}
