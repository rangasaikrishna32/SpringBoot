package com.demo.spring;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpController {
	
	@Autowired
	private EmpRepository repo;
 
	@RequestMapping(path="/emp/{id}",method=RequestMethod.GET,produces="application/json")
	public Emp findEmpById(@PathVariable("id")int id)
	{
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		else
		{
			throw new RuntimeException("No Emp Found");
		}
	}
	
	@RequestMapping(path="/emp",method=RequestMethod.GET,produces="application/json")
	public Emp findEmpById1(@PathParam("id")int id)
	{
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		else
		{
			throw new RuntimeException("No Emp Found");
		}
	}
}
