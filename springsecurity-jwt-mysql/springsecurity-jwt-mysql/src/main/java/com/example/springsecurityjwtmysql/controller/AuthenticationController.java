package com.example.springsecurityjwtmysql.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurityjwtmysql.Model.AuthenticationRequest;
import com.example.springsecurityjwtmysql.Model.AuthenticationResponse;
//import com.example.springsecurityjwtmysql.Model.User;
import com.example.springsecurityjwtmysql.Model.UserDTO;
import com.example.springsecurityjwtmysql.Service.JwtUtil;
import com.example.springsecurityjwtmysql.Service.MyUserDetailsService;
import com.example.springsecurityjwtmysql.Service.UserService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MyUserDetailsService  myUserDetailsService ;
	

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@RequestMapping("/home")
	public String hello(){
		return "hello welcome!!";
	}
	//1
	@PostMapping("home/signup")
	public String signUp(@RequestBody UserDTO user){
		
		return userService.insertUser(user);
		
	}
	@PostMapping("home/login")
	public String login(@RequestBody AuthenticationRequest authenticationRequest ,HttpServletResponse httpServletResponse){
	
	UserDetails user = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	
		System.out.println("user  ::" +user.getUsername());
		System.out.println("user  ::" + authenticationRequest.getUsername());
		if(authenticationRequest.getUsername().equals(user.getUsername()) && new  BCryptPasswordEncoder().matches(authenticationRequest.getPassword(),user.getPassword())){
	
			// BCryptPasswordEncoder().matches(authenticationRequest.getPassword(),user.getPassword())
			jwtUtil.setExpiration(2);
			return jwtUtil.generateToken(user);
		}
		return "Invalid Username or password";
		
	}
	@RequestMapping("/admin")
	public String admin(){
		return "welcome Admin !";
	}
	@RequestMapping("/user")
	public String user(){
		 return "welcome User!";
	} 
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e){
			throw  new Exception("Invalid Credentials!!",e);
		}
		final UserDetails userDetails =myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String Token = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(Token));
		
	}
	@GetMapping("/accesstoken")
	public String getAccessToken(HttpServletRequest  request){
		
		 final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		 String jwt = null;
		 
		 if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
			 jwt = authorizationHeader.substring(7);
			 username = jwtUtil.extractUsername(jwt);
		 }
		 if(username!= null){
			 UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
			 if(jwtUtil.validateToken(jwt, userDetails)){
				 return jwtUtil.generateToken(userDetails);
			 }else{
				 return "invalid token";
			 }
			 
		 }

		 return "invalid token";
		
	}

	
}
