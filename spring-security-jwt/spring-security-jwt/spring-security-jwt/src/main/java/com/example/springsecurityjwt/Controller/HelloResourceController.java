package com.example.springsecurityjwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurityjwt.Model.AuthenticationRequest;
import com.example.springsecurityjwt.Model.AuthenticationResponse;
import com.example.springsecurityjwt.Service.JwtUtil;

@RestController
public class HelloResourceController {

	@Autowired
	UserDetailsService userDetailsService; 
	
	@Autowired
	private  JwtUtil jwtTokenUitl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{	
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e){
			throw new Exception("Incorrect username or password !!");	
		}
		
		 UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		String jwt = jwtTokenUitl.generateToken(userDetails);
		 return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
		
	}
}
