package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class POSTClient {
	
	public static void main(String[] args) {
		RestTemplate rt=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", "text/plain");
		headers.set("Content-Type", "application/json");
		 
		 
		//Emp e=new Emp(501,"Sai","Krishna",45000);
		HttpEntity req=new HttpEntity<>(headers);
		
		
		
		ResponseEntity<String> resp=rt.exchange("http://localhost:8081/emp/Save",
				HttpMethod.POST,req,String.class);
		
		System.out.println(resp.getBody());
		
		/*ResponseEntity<List<Emp>> resp1=rt.exchange("http://localhost:8081/emp/list",
				HttpMethod.GET,req,
				new ParameterizedTypeReference<List<Emp>>(){} 
		);
		
		resp1.getBody().stream().forEach(e->System.out.println(e.getName()));*/
		
		
	}

}
