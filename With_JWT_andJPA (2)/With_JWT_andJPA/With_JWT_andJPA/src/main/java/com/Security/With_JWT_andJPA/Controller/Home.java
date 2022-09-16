package com.Security.With_JWT_andJPA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Security.With_JWT_andJPA.Model.AuthenticationRequest;
import com.Security.With_JWT_andJPA.Model.AuthenticationResponse;
import com.Security.With_JWT_andJPA.MyUserDetailService.MyUserDetailService;
import com.Security.With_JWT_andJPA.utill.JwtUtill;


@RestController
public class Home 
{
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Autowired
	private JwtUtill jwtTokenUtil;
	
	@RequestMapping("/wlc")
	public String hello()
	{
		return "<h2>welcome</h2>";
	}

	@RequestMapping("/user")
	public String getuser()
	{
		return "<h2>welcome user</h2>";
	}

	@RequestMapping("/admin")
	public String getadmin()
	{
		return "<h2>welcome admin</h2>";
	}

	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		//UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername())
		//if(authenticationRequest.getUsername().equals(user.getUsername()) && authenticationRequest.getPasswor().equals(user.getPassword())
//		{
//		final String jwt=jwtTokenUtil.generateToken(user);
//		
//		 return ResponseEntity.ok(new AuthenticationResponse(jwt));
//		}
		try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
					 (authenticationRequest.getUsername(),authenticationRequest.getPassword()));
			 
		} catch (BadCredentialsException e) {

			throw new Exception("incorrect username or password"+e);
		}
	
		 final UserDetails userDetails=userDetailsService
				 .loadUserByUsername(authenticationRequest.getUsername());
	
		 final String jwt=jwtTokenUtil.generateToken(userDetails);
	
		 return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
		
	
	
}
