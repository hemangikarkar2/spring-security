package com.Security.With_JWT_andJPA.MyUserDetailService;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Security.With_JWT_andJPA.Model.CustomeUser;
import com.Security.With_JWT_andJPA.Repository.UserRepository;


@Service 
public class MyUserDetailService implements UserDetailsService {
	
	
	@Autowired
	UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{                                                       //*2* flow enters here in below mwthod 
		Optional<CustomeUser> user=userRepository.findByUserName(userName);
		
		return new User(user.get().getUserName(),user.get().getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.get().getRoles())));   // *3* here we created User class object whcih returns username password and granted authorities you can see by using ctrl +click if u dont want to granted authorities than u have to pass emplty arrylist
	          	                                           //above method is checks and compare u dont need manually compare
	}
	
	

}
