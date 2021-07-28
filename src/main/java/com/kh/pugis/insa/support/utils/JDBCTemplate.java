package com.kh.pugis.insa.support.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() throws SQLException {
		 String jdbcUrl	= "jdbc:oracle:thin:@localhost:1521:xe";
		 String userId 	= "test2";
		 String userPass = "test2";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(jdbcUrl, userId, userPass);
		System.out.println("DB 연결 성공");
		
		return con;
	}
	
	public void close(Connection con) {
		
		close(con);
	}
	
	public void commit(Connection con) {
		
		commit(con);
	}
	
	public void rollback(Connection con) {
		
		rollback(con);
	}
	public void close(Statement stmt) {
		
		close(stmt);
	}
	
	public void close(ResultSet rs) {
		close(rs);
	}
	
}
