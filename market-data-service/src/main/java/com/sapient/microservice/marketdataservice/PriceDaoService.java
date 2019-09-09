package com.sapient.microservice.marketdataservice;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class PriceDaoService {
	private static HashMap<String,Integer> price = new HashMap<>();
	
	static {
		price.put("AL", 1000);
	}
	
	public Integer findPriceOne(String materialName) {
		return price.get(materialName);
	}
	
}
