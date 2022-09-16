package com.example.JpqlExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JpqlExample.dao.UserRepository;
import com.example.JpqlExample.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public  List<User> findByNameAndCity(String name,String city){
		return  userRepository.findByNameAndCity(name,city);
	}  
	
	public  List<User> findByName(String name){
		return  userRepository.findByName(name);
	}  

//			List<User> alluser =userRepository.getAllUser();
	

}

