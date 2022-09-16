package com.springboot.restAPI.springboot.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restAPI.springboot.Dao.UserDao;
import com.springboot.restAPI.springboot.Service.UserService;
import com.springboot.restAPI.springboot.restapi.Entity.User;



@RestController

public class UserController {

	/*@GetMapping
	public ResponseEntity<Object> hello()
	{
		return new ResponseEntity<Object>("heloo", HttpStatus.OK);
	}*/
	
	@Autowired 
	UserService userService;
	@Autowired
	UserDao userDao;

	//creating post mapping that post the user detail in the database
	@PostMapping("/user")
	public User SaveUser(@Valid @RequestBody User user)
	{   
		return userService.save(user); 
		
	}
	//creating put mapping that updates the user detail   
	@PutMapping("/user/edit/{id}") 
	public User updateUser(@RequestBody User user,@PathVariable int id)
	{    
		user.setId(id);
		return userService.save(user);
		
	}

	//creating a delete mapping that deletes a specified user
	@DeleteMapping("/user/{id}") 
	public void  deleteUser(@PathVariable int id){	
		userService.deleteById(id);
	}
	 
	@GetMapping("/user") 
	private  List<User> getAllUsers(){
		return userService.findAll();
		
	}
	//find a specific user detail 
	@GetMapping("/user/{id}") 
	public User user(@PathVariable int id) {
		Optional<User> user =userService.findById(id);

		if (!user.isPresent())
		{ System.out.println("Not found");}

		return user.get();
	}
	 @PostMapping("/users")
	    ResponseEntity<String> SaveUser1(@Valid @RequestBody User user) {
	        return ResponseEntity.ok("User is valid");
	    }
/*	 @GetMapping("/user/{email}")
	   public User searchbyemail(@PathVariable("email") String email){
		
		 
		 return userService.searchbyemail(email);
		 
	 }  
	*/

	    }

