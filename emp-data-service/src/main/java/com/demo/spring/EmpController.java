package com.demo.spring;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(path="/emp/Save",method=RequestMethod.POST,consumes="application/json",produces="text/plain")
	public String addEmp(@RequestBody Emp e)
	{
		if(repo.existsById(e.getEmpId()))
		{
			return "Employee Already Exits";
		}
		else
		{
			repo.save(e);
			return "Emp Saved Successfully";
		}
		 
	}
	
	@RequestMapping(path="/emp/Update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public String updateEmp(@RequestBody Emp e)
	{
		 repo.save(e);
		 return "Emp Updated Successfully!!!";
		 
	}
	
	@RequestMapping(path="/emp/delete",method=RequestMethod.PUT,produces="application/json")
	public String deleteEmp(@RequestParam("id") int id)
	{
		 if(repo.existsById(id))
		 {
			 repo.deleteById(id);
			 return "Emp Deleted";
		 }
		 else
		 {
			 return "Emp Not Found";
		 }
		 
		 
	}
	
	@RequestMapping(path="/emp/list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList()
	{
		return repo.findAll();
		 
		 
	}
	
	
}
