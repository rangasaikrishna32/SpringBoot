package com.demo.spring.dao;
import java.util.List;


import com.demo.spring.entity.Emp;


public interface EmpDao {
	public String save(Emp E);
	public String delete(int id);
	public Emp findById(int id);
	public List<Emp> getAll();

}
