package com.sapient.microservices.tradingmicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

	@PostMapping("/trade")
	public String buyTrade(@RequestBody TradeBean tradebean) {
		List<TradeBean> list = new ArrayList<>();
		
		list.add(new TradeBean("Lorem","London","Aluminum",1560));
		list.add(new TradeBean("Ipsum","Singapore","Singapore",1345));
		list.add(new TradeBean("Dolor","Denver","Copper",1289));
		return "Success";
		
	}
}
