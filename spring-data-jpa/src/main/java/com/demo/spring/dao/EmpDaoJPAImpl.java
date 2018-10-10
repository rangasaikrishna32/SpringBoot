package com.demo.spring.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJPAImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public String save(Emp E) {
		// TODO Auto-generated method stub
		em.persist(E);
		return "emp Saved";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		Emp e=em.find(Emp.class, id);
		if (e == null) {
			return new Emp();
		}
		return e;
	}

	@Override
	public List<Emp> getAll() {
		 Query query=em.createQuery("select e from Emp e");
		 return query.getResultList();
		 
	}

}
