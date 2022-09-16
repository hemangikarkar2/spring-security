package com.springboot.restAPI.springboot.Dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.restAPI.springboot.restapi.Entity.User;

public interface UserDao  extends JpaRepository<User, Integer>{

	void findAllById(int user2);

	//User searchByEmail(String email);





}
