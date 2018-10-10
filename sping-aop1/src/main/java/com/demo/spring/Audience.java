package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {
	
	
	@Before("execution(* com.demo.spring.*.perform(..))")
	public void takeSeat()
	{
		System.out.println("Audience now take seats...");
	}
	@Before("execution(* com.demo.spring.*.perform(..))")
	public void switchedOffMobile()
	{
		System.out.println("Audience now switched off mobiles...");
	}
	@AfterReturning("execution(* com.demo.spring.*.perform(..))")
	public void applaud() {
		System.out.println("Good singing..Clap!Clap!Clap!");
	}
	

}
