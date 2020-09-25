package com.ameya.MobileAppAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MobileAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppApiApplication.class, args);
	}

}
