package com.Security.With_JWT_andJPA.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Security.With_JWT_andJPA.Filters.JwtRequestFilter;
import com.Security.With_JWT_andJPA.MyUserDetailService.MyUserDetailService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	
	@Autowired
	private MyUserDetailService myUserDetailService;
	@Autowired
	JwtRequestFilter JwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.userDetailsService(myUserDetailService);  // *1*  this auth provides method witch is userdetailService and we passes the the object of MyUserDetailService class so we goes to that class loader method that provided by userdetailService i mark as 2
	}
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/user").hasRole("USER").antMatchers("/admin").hasRole("ADMIN").antMatchers("/authenticate").permitAll().
				anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(JwtRequestFilter,UsernamePasswordAuthenticationFilter.class);	
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance(); 
	}
}	
