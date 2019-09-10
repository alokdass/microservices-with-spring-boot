package com.sapient.microservice.marketdataservice;

public class MarketServiceBean {
	
	
	private int marketPrice;
	
	public MarketServiceBean(int marketPrice) {
		super();
		this.marketPrice = marketPrice;
	}


	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}

}
