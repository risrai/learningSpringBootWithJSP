package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> myUsers=new ArrayList<>();
		for(User user:userRepo.findAll()) {
			System.out.println(user);
			myUsers.add(user);
		}
	
		return myUsers;
	}
	
	public void deleteUser(int id){
		userRepo.deleteById(id);
	}
	
	public User updateUser(int id){
		return userRepo.findById(id).get();
	}
}
 