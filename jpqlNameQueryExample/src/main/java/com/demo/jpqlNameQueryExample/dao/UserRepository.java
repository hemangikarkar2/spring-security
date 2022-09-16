package com.demo.jpqlNameQueryExample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.jpqlNameQueryExample.model.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Integer>{



	//@Query("select u from User u where u.name=?1 ")
	//@Query(value ="SELECT * from jpql_tbl u  where u.name=?1 ", nativeQuery = true)
	public List<User>  getUserByName(String name);

	@Query(value ="SELECT * from jpql_tbl n where n.city=?1", nativeQuery =true)

	public List<User> getNameByCity(String city); 
}
