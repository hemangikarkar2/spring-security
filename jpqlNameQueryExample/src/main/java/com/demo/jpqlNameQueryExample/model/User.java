package com.demo.jpqlNameQueryExample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="jpql_tbl")
//@NamedQuery(name = "User.getUserByName", query = "select u from User where u.name=?1")
//@NamedNativeQuery(name = "User.getUserByName", query = "select * from jpql_tbl u where u.name=?1", resultClass=User.class)
//@NamedNativeQuery(name = "User.getNameByCity", query = "select * from jpql_tbl u where u.city=?1", resultClass=User.class)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	private String lastname;
	private String country;
	private String city;
	private boolean status;
	
	
	public User() {
		super();
	}

	public User(int id, String name, String lastname, String country, String city, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.country = country;
		this.city = city;
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", country=" + country + ", city="
				+ city + ", status=" + status + "]";
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
