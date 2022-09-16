package com.springboot.restAPI.springboot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.restAPI.Exception.customException;
import com.springboot.restAPI.springboot.Dao.UserDao;
import com.springboot.restAPI.springboot.restapi.Entity.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired UserDao userDao;
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		int user2 = user.getId();
		List<User> user3 = new ArrayList<>();
		if(user3.equals(user2)){
			userDao.save(user);
		}	
		else{
			throw new customException("email is already existed!!");
		}
		return userDao.save(user);
	}
	//deleting a specific record by using the method deleteById() 
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}
	
	//getting all users record by using the method findaAll() 
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		userDao.findAll();
		return users;
	}

	@Override
	public Optional<User> findById(int id) {
		
			if(true){
			throw new customException("user is valid");
		}
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	/*	@Override
	public User searchbyemail(String email) {
		// TODO Auto-generated method stub
		
		return userDao.searchByEmail(email);
	}
*/


}
