package com.demo.jpqlNameQueryExample.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpqlNameQueryExample.dao.UserRepository;
import com.demo.jpqlNameQueryExample.model.User;
import com.demo.jpqlNameQueryExample.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/user/{name}")
	public ResponseEntity<List <User>> getUserByName(@PathVariable String name)
	{
		return new ResponseEntity<>(userService.userGetServiceByName(name) ,HttpStatus.OK);
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<User>> getUserByCity(@PathVariable String city){
		return new ResponseEntity<>(userService.getNameByCity(city), HttpStatus.OK);
		
	}
	
	
	
}
