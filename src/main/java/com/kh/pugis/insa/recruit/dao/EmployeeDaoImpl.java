package com.kh.pugis.insa.recruit.dao;


//import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.pugis.insa.recruit.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;
	
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Employee> list1() {

		return sqlSession.selectList("Employee.getEmployeeList");
	}

	public List<Employee> list2() {

		//Update
		int userCode = 0;
		if (session.getAttribute("userCode") != null) {
		}
		if (userCode == 0) {
			return null;
		}

		return sqlSession.selectList("Employee.getEmployeeList");

	}
	

	
}
