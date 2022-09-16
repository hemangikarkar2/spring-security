package com.example.springsecurityjwt.Service;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService{

	
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		return new User("foo","foo", new ArrayList<GrantedAuthority>());
		
		//return new User("foo","foo", (Collection<? extends GrantedAuthority>) new ArrayList<Object>());
	}

}
