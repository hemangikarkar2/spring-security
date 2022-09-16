package com.example.JpqlExample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.JpqlExample.model.User;

@Repository

public interface UserRepository extends CrudRepository<User,Integer> {

	
	@Query("select u FROM User u")
	public List<User> getAllUser();

	@Query(value ="SELECT u FROM User u WHERE u.name=?1 AND u.city=?2")
	public List<User> findByNameAndCity(String name, String city);
	
	@Query(value ="SELECT u FROM User u WHERE u.name=?1" )
	public List<User> findByName(String name);
}
