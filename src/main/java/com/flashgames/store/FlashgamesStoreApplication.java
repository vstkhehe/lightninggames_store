package com.flashgames.store;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.flashgames.store.controller.JogoController;

@SpringBootApplication
@ComponentScan({"com.flashgames.store.controller"})
@ComponentScan(basePackages = {"com.flashgames.store.security"})
@EntityScan(basePackages = {"com.flashgames.store.model"})
public class FlashgamesStoreApplication {

	public static void main(String[] args) {
		new File(JogoController.uploadDirectory).mkdir();
		SpringApplication.run(FlashgamesStoreApplication.class, args);
	}

}
