package com.example.springsecurityjwtmysql.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurityjwtmysql.Model.User;
//import com.example.springsecurityjwtmysql.Model.User;
import com.example.springsecurityjwtmysql.Model.UserDTO;
import com.example.springsecurityjwtmysql.Repository.UserRepository;

@Service
@Transactional

public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	PasswordEncoder passwordEncoder;



	@Override
	public String insertUser(UserDTO userDto) {
		User user = new User();
		String newPassword = passwordEncoder.encode(userDto.getPassword());
		user.setPassword(newPassword);
		user.setUsername(userDto.getUsername());
		user.setRole("ROLE_ADMIN");
		user.setActive(Boolean.TRUE);
		userRepository.save(user);
		return "User Added";
	}



}