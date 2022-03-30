package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/welcome")
	public String getMyFirstJSPPage(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcome";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) {
		service.saveUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
	}
	
	@GetMapping("/register")
	public String registerUser(HttpServletRequest request) {
		request.setAttribute("mode","MODE_REGISTER");
		return "welcome";
	}
	
	@GetMapping("/showUsers")
	public String viewAllUsers(HttpServletRequest request) {
		request.setAttribute("users",service.getAllUsers());
		request.setAttribute("mode","MODE_VIEWALLUSERS");
		return "welcome";
	}
	
	@GetMapping("/delete-user")
	public String deleteUsers(@RequestParam int id,HttpServletRequest request) {
		service.deleteUser(id);
		request.setAttribute("users",service.getAllUsers());
		request.setAttribute("mode","MODE_VIEWALLUSERS");
		return "welcome";
	}
	
	@RequestMapping("/update-user")
	public String updateUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user",service.updateUser(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "welcome";
	}
	
}
