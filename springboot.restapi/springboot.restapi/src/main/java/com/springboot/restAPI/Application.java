package com.springboot.restAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.restAPI.springboot.Dao.UserDao;
import com.springboot.restAPI.springboot.restapi.Entity.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
    /*
     * @Bean
     * public CommandLineRunner run(UserDao userDao) throws Exception {
        return (String[] args) -> {
            User user1 = new User("hema","karkar", "hema@gmail.com");
            User user2 = new User("pooja","bhatt", "pooja2@gmail.com");
            userDao.save(user1);
            userDao.save(user2);
            userDao.findAll().forEach(System.out::println);
  }      };*/

}