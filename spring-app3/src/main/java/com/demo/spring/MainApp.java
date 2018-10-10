package com.demo.spring;
import com.demo.spring.service.HrService;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//HrService service=(HrService)ctx.getBean(HrService.class);
		//HrService service=(HrService)ctx.getBean("hrService");
		HrService service=ctx.getBean(HrService.class);
		//HrService service=(HrService)ctx.getBean("empBean");
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 78000));
	}

}
