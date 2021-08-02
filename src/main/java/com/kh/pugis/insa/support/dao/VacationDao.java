package com.kh.pugis.insa.support.dao;

import com.kh.pugis.insa.support.utils.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.pugis.insa.support.domain.Employee;
import com.kh.pugis.insa.support.domain.Vacation_work;

import com.kh.pugis.insa.support.service.VacationService;


public class VacationDao {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public VacationDao(){}
	

	public ArrayList<String> maxseq(){
		Vacation_work vacation = null;
		ArrayList<Vacation_work> vacationList = 
				new ArrayList<Vacation_work>();
		ArrayList<String> maxseq = new ArrayList<String>();
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select max(to_number(va_code)) from vacation_work";
			
			rs =stmt.executeQuery(sql);
			if(rs.next()) {
				vacation = new Vacation_work();
				vacation.setVa_code(rs.getString("max(to_number(va_code))"));
				vacationList.add(vacation);
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			
			for(int i = 0; i<vacationList.size(); i++) {
				maxseq.add(vacationList.get(i).getVa_code());
				System.out.println("va_code : "+maxseq);
			}
			
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
		return maxseq;
	}
	
	public String va_seq() {
		
		ArrayList<String> maxseq = new ArrayList<String>();
		VacationService svl = new VacationService();
		maxseq = svl.vSeqmax();
		if(maxseq.get(0) == null) {
			maxseq.add("0");
		}
		int lastIndex = maxseq.size()-1;
		
		String num = maxseq.get(lastIndex);
		
		int maxSeqInt = Integer.valueOf(num)+1;
		
		String seq = maxSeqInt+"";
		if(maxSeqInt == 0) {
			maxSeqInt = 1;
		}
		
		return seq;
	}
		
	
	public int insertVacation(Connection conn, Vacation_work vw, HttpServletRequest request) throws SQLException {
		conn = JDBCTemplate.getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		//		String vacation_code = request.getParameter("vacation_code");
		String emp_code = request.getParameter("emp_code");
		String n_emp_name = request.getParameter("n_emp_name");
		String vacation_startDate = request.getParameter("vacation_startDate");
		String vacation_endDate = request.getParameter("vacation_endDate");
		String vcontent = request.getParameter("vcontent");
		String status = "대기";
		String va_code = va_seq();
		

		Vacation_work vw1 = new Vacation_work();
		
		//		vw1.setVacation_code(vacation_code);
		vw1.setEmp_code(emp_code);
		vw1.setN_emp_name(n_emp_name);
		vw1.setVacation_startDate(vacation_startDate);
		vw1.setVacation_endDate(vacation_endDate);
		vw1.setVcontent(vcontent);
		vw1.setStatus(status);
		
		String sql = "INSERT INTO vacation_work VALUES(SYSDATE,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_code);
			pstmt.setString(2, n_emp_name);
			pstmt.setString(3, vacation_startDate);
			pstmt.setString(4, vacation_endDate);
			pstmt.setString(5, vcontent);
			pstmt.setString(6, status);
			pstmt.setString(7, va_code);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		return result;
	}

	public ArrayList<Vacation_work> selectList() throws SQLException {
		ArrayList<Vacation_work> list = null;
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM VACATION_WORK where status='대기' ORDER BY va_code ASC";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Vacation_work>();
			
			while (rs.next()) {
				Vacation_work vw = new Vacation_work();
				vw.setVacation_applyDay(rs.getString("vacation_applyday"));
				vw.setVa_code(rs.getString("va_code"));
				vw.setEmp_code(rs.getString("emp_code"));
				vw.setN_emp_name(rs.getString("n_emp_name"));
				vw.setVacation_startDate(rs.getString("vacation_startDate"));
				vw.setVacation_endDate(rs.getString("vacation_endDate"));
				vw.setVcontent(rs.getString("contents"));
				vw.setStatus(rs.getString("status"));
				list.add(vw);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
		}
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	public ArrayList<Vacation_work> selectListAll() throws SQLException {
		ArrayList<Vacation_work> list = null;
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM VACATION_WORK ORDER BY va_code ASC";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Vacation_work>();
			
			while (rs.next()) {
				Vacation_work vw = new Vacation_work();
				vw.setVacation_applyDay(rs.getString("vacation_applyday"));
				vw.setVa_code(rs.getString("va_code"));
				vw.setEmp_code(rs.getString("emp_code"));
				vw.setN_emp_name(rs.getString("n_emp_name"));
				vw.setVacation_startDate(rs.getString("vacation_startDate"));
				vw.setVacation_endDate(rs.getString("vacation_endDate"));
				vw.setVcontent(rs.getString("contents"));
				vw.setStatus(rs.getString("status"));
				list.add(vw);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
		}
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}

	public Vacation_work selectOne(Connection conn, String vacation_code) throws SQLException {
		Vacation_work vw = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = JDBCTemplate.getConnection();
		String sql = "SELECT * FROM VACATION WHERE EMP_CODE=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vacation_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vw = new Vacation_work();
				
				vw.setVa_code(vacation_code);
				vw.setEmp_code(rs.getString("emp_code"));
				vw.setN_emp_name(rs.getString("n_emp_name"));
				vw.setVacation_startDate(rs.getString("vacation_startDate"));
				vw.setVacation_endDate(rs.getString("vacation_endDate"));
				vw.setVcontent(rs.getString("vcontent"));
				vw.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
		}
		return vw;
	}

	public int vacationCommit(HttpServletRequest req, HttpSession session) throws SQLException {
		
		ArrayList<String> statusList = new ArrayList<String>();
		ArrayList<String> vaCodeList = new ArrayList<String>();
		String[] cdList = null;
		String[] okList = null;
		cdList = req.getParameterValues("va_code");
		okList = req.getParameterValues("vaStatus");
		
		if(okList !=null) {
			for(String temp:okList) {
				statusList.add(temp);
			}
		}
		if(cdList != null) {
			for(String temp:cdList) {
				vaCodeList.add(temp);
			}
		}
		int result = 0;
		
		if(vaCodeList.size() != 0) {
		
			conn = JDBCTemplate.getConnection();
			
			
			String sql = "UPDATE VACATION_WORK SET STATUS=? where va_code = ?";
			
			try {
				for(int i = 0; i<statusList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, statusList.get(i));
				pstmt.setString(2, vaCodeList.get(i));
				pstmt.executeUpdate();
				conn.commit();
				
				}
				result = 1;
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}else {
			result = 0;
		}

		
		return result;
	}
	
	public int empName(HttpServletRequest req, HttpSession session) throws SQLException {
		String emp_name = "";
		String manager = "";
		int check = 0;
		
		Employee emp = new Employee();
		String emp_code = req.getParameter("emp_code");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		conn = JDBCTemplate.getConnection();
		String sql = "select emp_name,manager from employee where emp_code =  ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp_code);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			emp.setEmp_name(rs.getString("emp_name"));
			emp.setManager(rs.getString("manager"));
			emp_name = emp.getEmp_name();
			manager = emp.getManager();
			session.setAttribute("emp_name", emp_name);
			session.setAttribute("manager", manager);
			check = 1;
		}
		
		return check;
	}

}
