package com.springsecutiyExample2.springsecutiryjpa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecutiyExample2.springsecutiryjpa.Model.User;
	


public interface UserRepository extends JpaRepository<User, Integer> {
		Optional<User> findByUserName(String userName);
}
