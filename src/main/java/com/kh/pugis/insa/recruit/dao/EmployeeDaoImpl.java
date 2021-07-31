package com.kh.pugis.insa.recruit.dao;



import java.util.List;

//import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.pugis.insa.recruit.domain.WaitEmployee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SqlSession sqlSession;
//	private HttpSession session;
	
	
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}

	
	@Override
	public List<WaitEmployee> employeeList() {

		return sqlSession.selectList("Employee.getEmployeeList");
	}
	@Override
	public List<WaitEmployee> employeeListAll() {

		return sqlSession.selectList("Employee.waitEmployeeList");
	}
	
	@Override
	public List<WaitEmployee> deptUpdate(
			@RequestParam("dept_code")String dept_code, 
			@RequestParam("n_Emp_code")String n_Emp_code
			) {

		return sqlSession.selectList("Employee.newDept");
	}
	
}
