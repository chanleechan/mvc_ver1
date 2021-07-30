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
	
//	public ArrayList<Member> inserMember() {
//		
//		Member addMemberList = null;
//		ArrayList<Member> memberList = 
//				new ArrayList<Member>();
//		
//		try {
//			conn = JDBCTemplate.getConnection();
//			System.out.println("DB연결 성공");
//			
//			stmt = conn.createStatement();
//			
//			String emp_code = req.getParameter("emp_code");
//			String emp_id = req.getParameter("emp_id");
//			String f_emp_pass = req.getParameter("f_emp_pass");
//			int f_service_point = Integer.parseInt(req.getParameter("f_service_point"));
//			
//			String sql ="INSERT INTO FIRST_JOIN(EMP_CODE, F_EMP_PASS, F_SERVICE_POINT, EMP_ID)"
//					+ " VALUES(?,?,?,?)";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emp_code);
//			pstmt.setString(2,f_emp_pass);
//			pstmt.setInt(3, f_service_point);
//			pstmt.setString(4, emp_id);
//			
//			conn.commit();
//			
//			sql = "select emp_code, f_emp_pass, f_service_point, emp_id from first_join ";
//			
//			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				addMemberList = new Member();
//				addMemberList.setEmp_code(rs.getString("emp_code"));
//				addMemberList.setF_emp_pass(rs.getString("f_emp_pass"));
//				addMemberList.setF_service_point(rs.getInt("f_service_point"));
//				addMemberList.setEmp_id(rs.getString("emp_id"));
//				memberList.add(addMemberList);
//			}
//			conn.commit();
//			rs.close();
//			stmt.close();
//			conn.close();
//			
//			System.out.println("복지 등록 완료");
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		
//		return memberList;
//		
//	}
	
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
