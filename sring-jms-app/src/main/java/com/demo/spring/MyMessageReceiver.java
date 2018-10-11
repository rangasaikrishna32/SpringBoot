package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyMessageReceiver   {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
         ApplicationContext ctx=new AnnotationConfigApplicationContext(JmsConfig.class);
         JmsTemplate jt=ctx.getBean(JmsTemplate.class);
         
         TextMessage tm=(TextMessage) jt.receive("testQueue");
         System.out.println("Message Received");
         
         System.out.println("Message Received..."+tm.getText());
	}

}
