package com.demo.spring.service;
import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HrService {

	@Autowired
	@Qualifier("empBean")
	private EmpDao dao;
	

	//public void setDao(EmpDao dao) {
	//	this.dao = dao;
	//}

	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}
}