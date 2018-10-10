package com.demo.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;
@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	JdbcTemplate jt;
	
	
	public String save(Emp e) {
		// TODO Auto-generated method stub
		int count=jt.update( con -> {
			String insert_sql="insert into EMP(empno,name,address,salary) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insert_sql);
			pst.setInt(1, e.getEmpId());
			pst.setString(2,e.getName());
			pst.setString(3, e.getCity());
			pst.setDouble(4, e.getSalary());
			return pst;
		}	
	    );
		return "Data Saved";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		jt.update((con)-> {
			PreparedStatement pst = con
					.prepareStatement("delete from emp where empno=?");
			pst.setInt(1, id);
			
			return pst;
	     });
		return "deleted";
		
	}

	@Override
	public Emp findById(int id) {
		Emp emp=	jt.queryForObject("select * from emp where empno="+id, (rs,rowNum)-> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"),
					rs.getString("ADDRESS"),
					rs.getDouble("SALARY"));
		});
		return emp;
	}
	
	@Override
	public List<Emp> getAll()
	{
		 List<Emp> empList= jt.query("select * from emp", new RowMapper<Emp>() {
				@Override
				public Emp mapRow(ResultSet rs,int rowNum) throws SQLException{
					return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
				  
				}
			});
		return empList;
	}
	

}
