package com.demo.spring.dao;
import com.demo.spring.entity.Emp;

public class EmpDaoJdbcImpl implements EmpDao  {
	@Override
	public String save(Emp e) {
		System.out.println("JDBC: Emp Saved");
		return "saved";
	}
}
