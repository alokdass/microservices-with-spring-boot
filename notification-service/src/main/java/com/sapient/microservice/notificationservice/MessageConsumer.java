package com.sapient.microservice.notificationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sapient.microservice.model.TradeBean;
@Component
@EnableJms
public class MessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    //@JmsListener(destination = "test-queue")
    @JmsListener(destination = "${jsa.activemq.queue}", containerFactory="jsaFactory")
    public void listener(TradeBean message){
        logger.info("Message received {} ", message);
    }
}
