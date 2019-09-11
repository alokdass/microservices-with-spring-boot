package com.sapient.microservice.tradingmicroservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

	
	
	@Autowired
	private TradeServiceDao tradeService;
	
	@Autowired
	private PriceExchangeServiceProxy proxy;
	
	
	@PostMapping("/trade")
	public Resource<TradeBean> buyTradeFeign(@RequestBody TradeBean tradeBean) {
		tradeBean.setMarketPrice(proxy.getprice(tradeBean.getCommodities()).getMarketPrice());		
		return tradeService.save(tradeBean);
		
	}
	
	@GetMapping("/trade")
	public List<TradeBean> getTarde(){
		return tradeService.findAll();
	}
	
	
}
