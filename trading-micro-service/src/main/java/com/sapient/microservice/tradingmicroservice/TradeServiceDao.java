package com.sapient.microservice.tradingmicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.microservice.model.TradeBean;

@Component
public class TradeServiceDao {

	public static List<TradeBean> list = new ArrayList<>();

	private static int count = 0;

	static {
		list.add(new TradeBean(++count, "Lorem", "London", "Aluminum", 0));
		list.add(new TradeBean(++count, "Ipsum", "Singapore", "Zinc", 0));
		list.add(new TradeBean(++count, "Dolor", "Denver", "Copper", 0));
	}

	public int save(TradeBean tradeBean) {
		if (tradeBean.getId() == 0) {
			tradeBean.setId(++count);
		}
		list.add(tradeBean);
		return tradeBean.getId();
	}

	public List<TradeBean> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	public TradeBean findOne(int id) {
		for (TradeBean tradeBean : list) {
			if (id == tradeBean.getId())
				return tradeBean;
		}
		return null;
	}

}
