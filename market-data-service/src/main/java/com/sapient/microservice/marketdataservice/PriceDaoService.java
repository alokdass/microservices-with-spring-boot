package com.sapient.microservice.marketdataservice;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class PriceDaoService {
	private static HashMap<String,MarketServiceBean> price = new HashMap<>();
	
	static {
		price.put("Aluminum", new MarketServiceBean(1000));
		price.put("Zinc", new MarketServiceBean(1500));
		price.put("Copper", new MarketServiceBean(2000));
	}
	
	public MarketServiceBean findPriceOne(String materialName) {
		return price.get(materialName);
	}
	
}
