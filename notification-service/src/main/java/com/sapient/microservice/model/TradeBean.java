package com.sapient.microservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//counterparties, commodities ,location and market price
@Entity
@Table(name = "TRADEDATA")
public class TradeBean implements Serializable{
	
	@Id
	//@GeneratedValue
	private int id;
	
	@Column
	private String counterParty;
	
	@Column
	private String location;
	
	@Column
	private String commodities;
	
	@Column
	private int marketPrice;
	
	private String status;

	public TradeBean() {
		
	}
	
	public TradeBean(int id,String counterParty, String location, String commodities, int marketPrice) {
		super();
		this.id = id;
		this.counterParty = counterParty;
		this.location = location;
		this.commodities = commodities;
		this.marketPrice = marketPrice;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCommodities() {
		return commodities;
	}

	public void setCommodities(String commodities) {
		this.commodities = commodities;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TradeBean [id=" + id + ", counterParty=" + counterParty + ", location=" + location + ", commodities="
				+ commodities + ", marketPrice=" + marketPrice + ", status=" + status + "]";
	}

	
	
	

}
