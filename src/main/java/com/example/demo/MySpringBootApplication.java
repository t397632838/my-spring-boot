package com.example.demo;

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
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy
public class MySpringBootApplication {

	@RequestMapping("/")
	public String name() {
		return "Hello Spring" + this.count().size();
	}

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

	@Autowired
	MongoOperations oper;

	@Autowired
	MongoTemplate mongoTemplate;

	public DBCursor count() {
		DBCollection dbCollection = oper.getCollection("users");
		User user = new User();
		user.setName("沙瑞金");
		this.mongoTemplate.save(user);

		return dbCollection.find();
	}

}
