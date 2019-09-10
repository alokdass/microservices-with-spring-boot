package com.sapient.microservice.marketdataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketDataServiceController {
	
	@Autowired
	PriceDaoService priceDaoService;
	
	@GetMapping("/price/{materialName}")
	public MarketServiceBean getprice(@PathVariable String materialName) {
		return priceDaoService.findPriceOne(materialName);
		
	}

}
