package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@EnableWebSecurity we are not using because the spring boot will take care
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests().antMatchers("/info").permitAll()
    	 .antMatchers("/emp/**").hasAnyRole("USER","ADMIN")
    	 .and().httpBasic().and().csrf().disable();
    }
    
    @Autowired
    private DataSource ds;
    
   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception
    {
    	//Invalid User Name :401 Unauthorized
    	//Role Not Assigned :403
    	auth.inMemoryAuthentication().withUser("sai").password("$2a$10$nxmL59knzgSEDFxFB/M14e1XKi02JX0hN3RC3h1MCuHLkS4f5PNX2").roles("USER");
    	auth.inMemoryAuthentication().withUser("sathu").password("$2a$10$nxmL59knzgSEDFxFB/M14e1XKi02JX0hN3RC3h1MCuHLkS4f5PNX2").roles("ADMIN");
    	auth.inMemoryAuthentication().withUser("arun").password("$2a$10$nxmL59knzgSEDFxFB/M14e1XKi02JX0hN3RC3h1MCuHLkS4f5PNX2").roles("CLIENT");
    }*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception
    {
       auth.jdbcAuthentication().dataSource(ds).
       usersByUsernameQuery("select username,password,enabled from users where username=?")
       .authoritiesByUsernameQuery("select username,authority from authorities where username=?");
       
    }
    @Bean
    //this password encoder is mandatory from spring 5 or or security 2.0.5
    public BCryptPasswordEncoder encoder()
    {
    	return new BCryptPasswordEncoder();
    }
  
}
