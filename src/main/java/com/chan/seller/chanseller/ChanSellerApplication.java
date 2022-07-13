package com.chan.seller.chanseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ChanSellerApplication {

	@GetMapping("/hello")
	public String hello() {
		String baseUrl = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<>("wow");
		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request, String.class);
		return "content : " + response.getBody() + "\nstatus : " + response.getStatusCode().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(ChanSellerApplication.class, args);
	}

}
