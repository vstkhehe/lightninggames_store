package com.flashgames.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.flashgames.store.controller"})
@ComponentScan(basePackages = {"com.flashgames.store.security"})
@EntityScan(basePackages = {"com.flashgames.store.model"})
public class FlashgamesStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashgamesStoreApplication.class, args);
	}

}
