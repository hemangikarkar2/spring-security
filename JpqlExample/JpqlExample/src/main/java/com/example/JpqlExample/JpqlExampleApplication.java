package com.example.JpqlExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JpqlExample.model.User;
import com.example.JpqlExample.service.UserService;

@SpringBootApplication
public class JpqlExampleApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(JpqlExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
			findByNameAndCity();
			findByname();
	}
	private void findByNameAndCity(){
		List<User> userList = userService.findByNameAndCity("Hemangi","Ahmedabad");
		userList.forEach(System.out::println);
	}
	
	private void findByname(){
		List<User> usersList = userService.findByName("chahna");
		usersList.forEach(System.out::println);
	}
}
