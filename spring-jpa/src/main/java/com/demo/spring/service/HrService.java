package com.demo.spring.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service
@Transactional
public class HrService {

	@Autowired	
	private EmpRepository empDao;
	

	//public void setDao(EmpDao dao) {
	//	this.dao = dao;
	//}
	
	public String registerEmployee(int id, String name, String city, double salary) {
		Emp e = empDao.save(new Emp(id, name, city, salary));
		return "Data Saved";
	}
	
	public void displayEmpInfo(int id)
	{
		Optional<Emp> o=empDao.findById(id);
		if(o.isPresent())
		{
			Emp emp=o.get();
			System.out.println(emp.getEmpId()+""+emp.getName());
		}
		else
		{
			System.out.println("No Data Dound");
		}
		
	}
	
	
	public void showEmpList()
	{
		empDao.findAll().stream().forEach(e->System.out.println(e.getEmpId()+""+e.getName())); 
	}
	
	public void listWithSalaryRange(double s1,double s2)
	{
		empDao.getEmpWithSalBetweenRange(30000, 60000).stream().forEach(e->System.out.println(e.getName()+ ""+e.getSalary()));
	}
}