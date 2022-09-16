package com.springboot.restAPI.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.restAPI.springboot.restapi.Entity.User;

public interface UserService {


	List<User> getAllUsers();

	void deleteById(int id);

	User save(User user);

	Optional<User> findById(int id);

	List<User> findAll();

	//User searchbyemail(String email);

	

}
