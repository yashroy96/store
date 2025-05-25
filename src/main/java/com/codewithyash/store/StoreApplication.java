package com.codewithyash.store;

import com.codewithyash.store.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		var context= SpringApplication.run(StoreApplication.class, args);
//		var user= context.getBean(User.class);
		var user = new User();
		user.setName("Yash");
		user.setEmail("yashroy96@gmail.com");
		user.setPassword("pwd");
	}

}
