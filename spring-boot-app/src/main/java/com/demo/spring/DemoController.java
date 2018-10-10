package com.demo.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
 
	@RequestMapping(path="/greet/{name}",method=RequestMethod.GET,produces="text/plain")
	public String greet(@PathVariable("name")String name)
	{
		return name+ ",welcome to Spring RESt";
	}
	
	@RequestMapping(path="/greet",method=RequestMethod.GET,produces="text/plain")
	public String greet1()
	{
		return  "welcome to Spring RESt";
	}
	
}
