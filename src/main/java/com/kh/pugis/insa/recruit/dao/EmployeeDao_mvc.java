package com.kh.pugis.insa.recruit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.pugis.insa.recruit.domain.WaitEmployee;
import com.kh.pugis.insa.support.domain.Employee;
import com.kh.pugis.insa.support.utils.JDBCTemplate;

public class EmployeeDao_mvc {
	
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	public ArrayList<WaitEmployee> waitEmployeeList(){
		WaitEmployee waitArrayList = null;
		ArrayList<WaitEmployee> waitList = 
				new ArrayList<WaitEmployee>();	
		try {
			conn = JDBCTemplate.getConnection();			
			String sql = "select a.n_emp_code, a.n_emp_name,n_emp_phone, a.n_emp_gender, b.dept_name, c.rank_name  "
					+ "from waitemployee a , department b, rank c "
					+ "where a.dept_code = b.dept_code and a.rank_id = c.rank_id and a.dept_code = 'd8'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				waitArrayList = new WaitEmployee();
				
				waitArrayList.setN_Emp_code(rs.getString("n_emp_code"));
				waitArrayList.setN_Emp_name(rs.getString("n_emp_name"));
				waitArrayList.setN_Emp_phone(rs.getString("n_emp_phone"));
				waitArrayList.setN_Emp_gender(rs.getString("n_emp_gender"));
				waitArrayList.setDept_name(rs.getString("dept_name"));
				waitArrayList.setRank_id(rs.getString("rank_name"));
				waitList.add(waitArrayList);
			}
			
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return waitList;
	}
	
	public ArrayList<Employee> allEmployeeList(){
		Employee empArrayList = null;
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();	
		try {
			conn = JDBCTemplate.getConnection();			
			String sql = "select a.emp_code, a.emp_name,a.emp_phone, a.emp_gender, b.dept_name, c.rank_name "
					+ "from employee a , department b, rank c "
					+ "where a.dept_code = b.dept_code and a.rank_id = c.rank_id";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				empArrayList = new Employee();
				empArrayList.setEmp_code(rs.getString("emp_code"));
				empArrayList.setEmp_name(rs.getString("emp_name"));
				empArrayList.setEmp_phone(rs.getString("emp_phone"));
				empArrayList.setEmp_gender(rs.getString("emp_gender"));
				empArrayList.setDept_code(rs.getString("dept_name"));
				empArrayList.setRank_id(rs.getString("rank_name"));
				empList.add(empArrayList);
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

}
