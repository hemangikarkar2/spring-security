package com.example.springsecurityjwtmysql.Service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurityjwtmysql.Model.User;
import com.example.springsecurityjwtmysql.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String) TODO 2)flow enters here in below
	 * method 3) here we created User class object whcih returns username
	 * password and granted authorities you can see by using ctrl +click if u
	 * dont want to granted authorities than u have to pass emplty arrylist
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = this.userRepository.findByUsername(username);

		if (user.isPresent()) {

			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.get().getRole())));
		}

		throw new UsernameNotFoundException("User Not found with username :" + username);
	}

}
