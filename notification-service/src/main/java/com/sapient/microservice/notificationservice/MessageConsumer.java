package com.sapient.microservice.notificationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sapient.microservice.model.TradeBean;
import com.sapient.microservice.model.TradeDao;
@Component
@EnableJms
public class MessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    
    @Autowired
    private TradeDao tradeDao;
    
    @JmsListener(destination = "${jsa.activemq.queue}", containerFactory="jsaFactory")
    public void listener(TradeBean message){
        logger.info("Message received {} ", message);
        tradeDao.save(message);
        
        changeStatusAsProcessed(message);
       
    }
    
    private void changeStatusAsProcessed(TradeBean tradeBean) {
    	tradeBean.setStatus("Processed");
        tradeDao.save(tradeBean);
    }
}
