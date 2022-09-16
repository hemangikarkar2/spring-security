package com.example.springsecurityjwtmysql.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Long id;

	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column 
	private boolean active; 
	


	public User() {
		super();
	}

	public User(String string, String string2, List<SimpleGrantedAuthority> list) {
		
	}
	
	public User(Long id, String username, String password, String role, boolean active) {
		super();		//,String firstname, String lastname, String email
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username; 
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	
}
