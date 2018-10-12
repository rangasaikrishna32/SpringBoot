package com.demo.spring;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.demo.spring.repo")
//That will be taken care by the spring boot


public class DaoConfig {

	/*@Autowired
	DataSource ds;*/
	
	@Bean("ds")
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean empfb=new LocalContainerEntityManagerFactoryBean();
		//empfb.setDataSource(dataSource());
		empfb.setDataSource(ds);
		empfb.setPackagesToScan("com.demo.spring.entity");
		
		HibernateJpaVendorAdapter va=new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		
		empfb.setJpaVendorAdapter(va);
		return empfb;
		
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory empfb)
	{
		JpaTransactionManager txm=new JpaTransactionManager();
		txm.setEntityManagerFactory(empfb);
		return txm;
	}*/
	 
	
}
