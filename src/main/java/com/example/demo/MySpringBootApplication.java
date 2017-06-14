package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.User;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com")
@EnableAspectJAutoProxy
public class MySpringBootApplication {

	@RequestMapping("/")
	public String name() {
		for (User u : this.userList()) {
			System.out.println(u.toString());
		}

		return "Hello Spring:" + this.userList().size();
	}

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

	@Autowired
	MongoOperations oper;

	@Autowired
	MongoTemplate mongoTemplate;

	public List<User> userList() {
		// DBCollection dbCollection = oper.getCollection("users");

		/*
		 * User user = new User(); user.setUsername("沙瑞金");
		 * this.mongoTemplate.save(user);
		 */

		List<User> u = this.mongoTemplate.findAll(User.class);

		return u;
	}

}
