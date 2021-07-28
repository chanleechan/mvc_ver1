package com.kh.pugis.servletonly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.pugis.servletonly.domain.EmployeeVoMultiRows;


public class EmployeeDaoMultiRows {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public EmployeeDaoMultiRows() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmployeeVoMultiRows> userSearch() {
		EmployeeVoMultiRows userdao = null;
		ArrayList<EmployeeVoMultiRows> retArrList = 
				new ArrayList<EmployeeVoMultiRows>();
		
		String jdbcUrl	= "jdbc:oracle:thin:@localhost:1521:xe";
		String userId 	= "woseven";
		String userPass = "woseven";

		// 데이터베이스 접속
		try {
			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);
			System.out.println("DB 연결 성공");
			
			stmt= conn.createStatement();
			
			String sql = "SELECT  EMP_ID, EMP_NAME, EMP_NO, EMAIL FROM EMPLOYEE";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				userdao = new EmployeeVoMultiRows();
				
				userdao.setEmp_id(rs.getString("emp_id"));
				userdao.setEmp_name(rs.getString("emp_name"));
				userdao.setEmp_no(rs.getString("emp_no"));
				userdao.setEmail(rs.getString("email"));
				retArrList.add(userdao);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		
		return retArrList;
	}
}
