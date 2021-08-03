package com.kh.pugis.insa.support.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.kh.pugis.insa.support.domain.Member;
import com.kh.pugis.insa.support.domain.Member_Account;
import com.kh.pugis.insa.support.utils.JDBCTemplate;

public class MemberDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	HttpServletRequest req;
	
	public MemberDao() {
		
	}
	
	public int userCheck(String emp_id, String f_emp_pass,HttpSession session) throws SQLException {
		int ck = 0;
		
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");

		String sql = "select emp_code, f_emp_pass, f_service_point, emp_id from first_join where emp_id = ?";
		String emp_code="";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp_id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			if(f_emp_pass.equals(rs.getString("f_emp_pass"))) {
				emp_code = rs.getString("emp_code");
				session.setAttribute("emp_code", emp_code);
				conn.commit();
				ck = 1;
			}else {
				ck = 0;
			}
		}else {
			ck = -1;
		}
		conn.close();
		rs.close();
		pstmt.close();
		
		return ck;
	}
	public void service_point(HttpSession session) {
		Member_Account member = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			String emp_id = "";
			int f_service_point = 0;
			emp_id = (String)session.getAttribute("emp_id");
			String sql = "select f_service_point from first_join where emp_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				member = new Member_Account();
				member.setF_service_point(rs.getInt("f_service_point"));
				f_service_point = member.getF_service_point();
				session.setAttribute("f_service_point", f_service_point);
			}
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public int insertMember(HttpServletRequest req) throws SQLException {
		int result = 0;
		
		conn = JDBCTemplate.getConnection();
		String emp_id = req.getParameter("emp_id");
		String f_emp_pass = req.getParameter("f_emp_pass");
		String emp_code = req.getParameter("emp_code");
		
		if(emp_id != null) {
		
			String sql = "insert into first_join(emp_code,f_emp_pass,emp_id) values(?,?,?)";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_code);
			pstmt.setString(2, f_emp_pass);
			pstmt.setString(3, emp_id);
			pstmt.executeQuery();
			conn.commit();
			
			String insertServicePoint = "update first_join set f_service_point = "
					+ "(select b.m_point "
					+ "from  point_master b, employee c ,first_join a "
					+ "where a.emp_code = ? "
					+ "and c.service_point = b.point_code "
					+ "and c.emp_code = a.emp_code "
					+ ") "
					+ "where emp_code= ?";
			pstmt2 = conn.prepareStatement(insertServicePoint);
			pstmt2.setString(1, emp_code);
			pstmt2.setString(2, emp_code);
			pstmt2.executeQuery();
			conn.commit();
			
			result = 1;
		}else {
			result = 0;
		}
		pstmt.close();
		pstmt2.close();
		conn.close();
		
		return result;
	}
	
	public int confirmId(String emp_id,HttpServletRequest req) throws SQLException {
		int check = 0;
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		String sql = "select emp_id from first_join where emp_id = ?";
		System.out.println("emp_id "+ emp_id);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp_id);
		
		rs = pstmt.executeQuery();
		
		
		if(rs.next()) {
				System.out.println(rs.getString("emp_id"));
				check = 0;
			}else {
				check = 1;
				//check = 0;
			}
		
		conn.close();
		pstmt.close();
		rs.close();
		
		return check;
		
	}	
}
