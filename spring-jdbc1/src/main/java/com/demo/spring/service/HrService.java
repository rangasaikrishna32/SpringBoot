package com.demo.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired	
	private EmpDao empDao;
	

	//public void setDao(EmpDao dao) {
	//	this.dao = dao;
	//}
	@Transactional
	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = empDao.save(new Emp(id, name, city, salary));
		return resp;
	}
}