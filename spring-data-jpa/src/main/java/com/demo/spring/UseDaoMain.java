package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.spring.service.HrService;

public class UseDaoMain {
	
	public static void main(String[] args)
	{
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hr=ctx.getBean(HrService.class);
		
		hr.registerEmployee(505,"Sai Krishna","OOTY",500);
		
	}

}
