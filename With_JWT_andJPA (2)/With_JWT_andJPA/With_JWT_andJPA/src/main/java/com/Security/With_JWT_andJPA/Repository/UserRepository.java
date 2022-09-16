package com.Security.With_JWT_andJPA.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Security.With_JWT_andJPA.Model.CustomeUser;

public interface UserRepository extends JpaRepository<CustomeUser, Long> {
	
	Optional<CustomeUser> findByUserName(String username);

}
