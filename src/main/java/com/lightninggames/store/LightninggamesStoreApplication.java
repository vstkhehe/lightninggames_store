package com.lightninggames.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lightninggames.store.controller"})
@ComponentScan(basePackages = {"com.lightninggames.store.security"})
@EntityScan(basePackages = {"com.lightninggames.store.model"})
public class LightninggamesStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightninggamesStoreApplication.class, args);
	}

}
