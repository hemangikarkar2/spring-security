package com.springsecutiy.SpringSecurityDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@EnableWebSecurity 
  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
		//set my configuration  on the auth object
		auth.inMemoryAuthentication()
			.withUser("User")
			.password("user@123")
			.roles("USER")
			.and()   //it returns object that is a same state in inmemoryauthentication returns
			.withUser("Admin")
			.password("admin")
			.roles("ADMIN"); 
			
	}
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		
		return NoOpPasswordEncoder.getInstance();
		
	}
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests() // maapping path to role
					//.antMatchers("/**").hasAnyRole("Admin")// /** all parts in current level and any nested level is below this
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/user").hasAnyRole("USER" ,"ADMIN")
					.antMatchers("/").permitAll()
					.and().formLogin();
	}
	
	
}
