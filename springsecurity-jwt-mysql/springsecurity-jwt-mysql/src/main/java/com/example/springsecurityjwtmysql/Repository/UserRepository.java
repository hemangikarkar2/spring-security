package com.example.springsecurityjwtmysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityjwtmysql.Model.User;
import com.example.springsecurityjwtmysql.Model.UserDTO;
import com.example.springsecurityjwtmysql.Service.CustomUserDetails;
import com.sun.el.stream.Optional;

public interface UserRepository  extends JpaRepository<User, Long>{

	java.util.Optional<User> findByUsername(String username);

	

	

	




	

}
