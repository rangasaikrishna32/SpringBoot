package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {
	
	@JmsListener(destination = "testQueue", containerFactory = "containerFactory")
	public void receive(Message message) throws JMSException {

		TextMessage tm = (TextMessage) message;
		System.out.println(tm.getText());
	}

}
