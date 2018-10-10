package com.demo.spring.dao;
import com.demo.spring.entity.Emp;
import org.springframework.stereotype.Repository;

//@Repository
public class EmpDaoJPAImpl implements EmpDao  {
	@Override
	public String save(Emp e) {
		System.out.println("JPA: Emp Saved");
		return "saved";
	}
}
