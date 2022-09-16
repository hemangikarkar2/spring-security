package com.example.springsecurityjwtmysql.SecurityConfigurer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springsecurityjwtmysql.Filter.JwtRequestFilter;
import com.example.springsecurityjwtmysql.Service.MyUserDetailsService;

/**
 * @author Hemangi Karkar
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	
		@Autowired
		MyUserDetailsService MyUserDetailsService;
		
		@Autowired
		JwtRequestFilter jwtRequestFilter;
	
		
		/**
		 * TODO
		 *  configure AuthenticationManager so that it knows from where to load user for matching credentials Use
		BCryptPasswordEncoder,
		this auth provides method witch is userdetailService and we passes the the object of MyUserDetailService class
		//so we goes to that class loader method that provided by userdetailService i mark as 2
		 */
		public void  configureglobal(AuthenticationManagerBuilder auth ) throws Exception{
		
		auth.userDetailsService(MyUserDetailsService);
		
		}

		
		@Bean
		@Override
		public AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
		}
		
		@Bean
		public PasswordEncoder passwordEncoder()
		{
			return  new BCryptPasswordEncoder();
					
					//BCryptPasswordEncoder();
					//NoOpPasswordEncoder.getInstance(); 
		}
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/user").hasRole("USER")
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/authenticate","/accesstoken","/home/signup","/home/login").permitAll().
			anyRequest().authenticated().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

			httpSecurity.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);	
			
	
		}
		
}
