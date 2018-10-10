package com.demo.spring;
import com.demo.spring.service.HrService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		
		HrService service=(HrService)ctx.getBean("hr");
		
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 78000));
	}

}
