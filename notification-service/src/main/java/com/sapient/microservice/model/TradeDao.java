package com.sapient.microservice.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeDao extends CrudRepository<TradeBean,Long>{
	
	

}
