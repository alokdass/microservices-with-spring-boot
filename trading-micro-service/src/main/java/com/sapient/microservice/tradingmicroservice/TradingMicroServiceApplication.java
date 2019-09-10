package com.sapient.microservice.tradingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sapient.microservice.tradingmicroservice")
@EnableDiscoveryClient
public class TradingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingMicroServiceApplication.class, args);
	}

}
