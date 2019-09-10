package com.sapient.microservice.tradingmicroservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="market-data-service", url="localhost:8100")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="market-data-service")
public interface PriceExchangeServiceProxy {
	
	@GetMapping("/market-data-service/price/{materialName}")
	public TradeBean getprice(@PathVariable String materialName);
}
