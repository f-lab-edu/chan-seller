package com.chan.seller.chanseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChanSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChanSellerApplication.class, args);
	}

}
