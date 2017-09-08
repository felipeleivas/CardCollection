package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CardCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardCollectionApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8080/autoUpdateTheDataBaseBecauseIDontKnowHowToImport", Void.class);
	}
}
