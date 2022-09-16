package com.demo.jpqlNameQueryExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpqlNameQueryExample.dao.UserRepository;
import com.demo.jpqlNameQueryExample.model.User;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	

	public List<User> userGetServiceByName(String name) {
		// TODO Auto-generated method stub
		return  userRepository.getUserByName(name);
	}




	public List<User> getNameByCity(String city) {
		// TODO Auto-generated method stub
		return userRepository.getNameByCity(city);
	}  
}
