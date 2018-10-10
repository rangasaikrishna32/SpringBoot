package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.demo.spring.dao.EmpDaoJPAImpl;

@Configuration
@ComponentScan(basePackages={"com.demo"})
public class AppConfig {
@Bean
 public EmpDaoJPAImpl empBean()
 {
	 return new EmpDaoJPAImpl();
 }
}
