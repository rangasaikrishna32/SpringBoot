package com.demo.spring.service;
import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class HrService {

	EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}
}