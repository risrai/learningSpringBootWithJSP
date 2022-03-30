package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService service;
	
	@GetMapping("/home")
	public String hello() {
		return "chal gaya!";
	}
	
	@GetMapping("/saveUser")
	public String saveUser(@RequestParam String userName,@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		User user=new User(userName,firstName,lastName,age);
		service.saveUser(user);
		return "user is saved";
	}
}
