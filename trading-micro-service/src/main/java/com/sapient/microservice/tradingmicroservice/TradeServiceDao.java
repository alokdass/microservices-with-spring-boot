package com.sapient.microservice.tradingmicroservice;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class TradeServiceDao {
	
	public static List<TradeBean> list = new ArrayList<>();
	
	private static int count = 0;
	
	static {
		list.add(new TradeBean(++count,"Lorem","London","Aluminum",0));
		list.add(new TradeBean(++count,"Ipsum","Singapore","Zinc",0));
		list.add(new TradeBean(++count,"Dolor","Denver","Copper",0));
	}
	
	public Resource<TradeBean> save(TradeBean tradeBean) {
		if(tradeBean.getId() == 0) {
			tradeBean.setId(++count);
		}
		list.add(tradeBean);
		
		Resource<TradeBean> resource = new Resource<TradeBean>(tradeBean);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findOne(tradeBean.getId()));
		resource.add(linkTo.withRel("link"));
		
		
		return resource;
	}

	public List<TradeBean> findAll() {
		// TODO Auto-generated method stub
		return list;
	}
	
	public TradeBean findOne(int id) {
		for(TradeBean tradeBean: list) {
			if(id == tradeBean.getId()) 
				return tradeBean;
		}
		return null;
	}

}
