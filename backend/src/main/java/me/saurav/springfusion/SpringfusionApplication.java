package me.saurav.springfusion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class SpringfusionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfusionApplication.class, args);
		System.out.println("[SPRING] App is running...");
	}

}
