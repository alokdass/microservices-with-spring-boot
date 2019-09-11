package com.sapient.microservice.tradingmicroservice;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.microservice.model.TradeBean;

@RestController
public class TradeController {

//	@Autowired
//    private Queue queue;
	
	@Value("${jsa.activemq.queue}")
	String queue;
	
    @Autowired
    private JmsTemplate jmsTemplate;
	
	@Autowired
	private TradeServiceDao tradeService;
	
	@Autowired
	private PriceExchangeServiceProxy proxy;
	
	
	@PostMapping("/trade")
	public Resource<TradeBeanResponse> buyTradeFeign(@RequestBody TradeBean tradeBean) {
		tradeBean.setMarketPrice(proxy.getprice(tradeBean.getCommodities()).getMarketPrice());	
		
		tradeBean.setStatus("Initiated");
		int id = tradeService.save(tradeBean);
		
		jmsTemplate.convertAndSend(queue, tradeBean);
		
		TradeBeanResponse tradeBeanResponse = new TradeBeanResponse("Success");
		Resource<TradeBeanResponse> resource = new Resource<TradeBeanResponse>(tradeBeanResponse);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getTarde(id));
		resource.add(linkTo.withRel("trade-link"));		
		return resource;
		
	}
	
	@GetMapping("/trade")
	public List<TradeBean> getTarde(){
		return tradeService.findAll();
	}
	
	@GetMapping("/trade/{id}")
	public TradeBean getTarde(@PathVariable int id){
		return tradeService.findOne(id);
	}
}
