package com.demo.spring.dao;
import com.demo.spring.entity.Emp;
import org.springframework.stereotype.Repository;

//@Repository
public class EmpDaoJdbcImpl implements EmpDao  {
	@Override
	public String save(Emp e) {
		System.out.println("JDBC: Emp Saved");
		return "saved";
	}
}
