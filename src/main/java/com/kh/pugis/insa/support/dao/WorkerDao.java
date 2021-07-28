package com.kh.pugis.insa.support.dao;
import com.kh.pugis.insa.support.utils.JDBCTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.kh.pugis.insa.support.domain.Employee;
import com.kh.pugis.insa.support.domain.Worker;

public class WorkerDao {
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public int insertGoWorker(HttpServletRequest req,HttpSession session) throws SQLException, ParseException {
	
		Date time = new Date();
		SimpleDateFormat todate = new SimpleDateFormat("yyyy-mm-dd",Locale.KOREA);
		SimpleDateFormat goWork = new SimpleDateFormat("HH:mm:ss",Locale.KOREA);
		SimpleDateFormat rateCheck = new SimpleDateFormat("HH:mm:ss",Locale.KOREA);
		Date rate = rateCheck.parse("09:00:00");
		Date work = goWork.parse(goWork.format(time));
		
		conn = JDBCTemplate.getConnection();
		
		int result = 0;
		String today = todate.format(time); 
		String dept = "";
		String emp_code = (String)session.getAttribute("emp_code");
		String o_emp_name = (String)session.getAttribute("emp_name");
		String time_now = goWork.format(time);
		String status = "";
		if(rate.before(work)) {
			status = "지각";
		}else {
			status = "정상출근";
		}
		
		String sql = "select dept_code from employee where emp_code = ?";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, emp_code);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			dept = rs.getString("dept_code");
		}

		sql = "INSERT INTO GO_WORKER VALUES(SYSDATE, ?, ?, ?, ?, ?)";
		
		Worker wk = new Worker();
		wk.setToday(today);
		wk.setDept(dept);
		wk.setEmp_code(emp_code);
		wk.setO_emp_name(o_emp_name);
		wk.setTime_now(time_now);
		wk.setStatus(status);
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wk.getDept());
			pstmt.setString(2, wk.getEmp_code());
			pstmt.setString(3, wk.getO_emp_name());
			pstmt.setString(4, wk.getTime_now());
			pstmt.setString(5,wk.getStatus());
			
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
		}
		pstmt.close();
		rs.close();
		conn.close();
		
		return result;
	}
	
	public int insertOffWorker(HttpServletRequest req,HttpSession session) throws SQLException, ParseException {
		
		Date time = new Date();
		SimpleDateFormat todate = new SimpleDateFormat("yyyy-mm-dd",Locale.KOREA);
		SimpleDateFormat goWork = new SimpleDateFormat("HH:mm:ss",Locale.KOREA);
//		SimpleDateFormat rateCheck = new SimpleDateFormat("HH:mm:ss",Locale.KOREA);
//		Date rate = rateCheck.parse("09:00:00");
//		Date work = goWork.parse(goWork.format(time));
		
		conn = JDBCTemplate.getConnection();
		
		int result = 0;
		String today = todate.format(time); 
		String dept = "";
		String emp_code = (String)session.getAttribute("emp_code");
		String o_emp_name = (String)session.getAttribute("emp_name");
		String time_now = goWork.format(time);
		String status = "퇴근";
		
		
		String sql = "select dept_code from employee where emp_code = ?";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, emp_code);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			dept = rs.getString("dept_code");
		}

		sql = "INSERT INTO OFF_WORKER VALUES(SYSDATE, ?, ?, ?, ?, ?)";
		
		Worker wk = new Worker();
		wk.setToday(today);
		wk.setDept(dept);
		wk.setEmp_code(emp_code);
		wk.setO_emp_name(o_emp_name);
		wk.setTime_now(time_now);
		wk.setStatus(status);
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wk.getDept());
			pstmt.setString(2, wk.getEmp_code());
			pstmt.setString(3, wk.getO_emp_name());
			pstmt.setString(4, wk.getTime_now());
			pstmt.setString(5,wk.getStatus());
			
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
		}
		pstmt.close();
		rs.close();
		conn.close();
		
		return result;
	}

	public ArrayList<Worker> workerList(Connection conn) throws SQLException {
		ArrayList<Worker> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM WORKER ORDER BY EMP_CODE";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Worker>();
			
			while (rs.next()) {
				Worker w = new Worker();
				
				w.setToday(rs.getString("today"));
				w.setDept(rs.getString("dept"));
				w.setEmp_code(rs.getString("emp_code"));
				w.setO_emp_name(rs.getString("o_emp_name"));
				w.setTime_now(rs.getString("time_now"));
				w.setStatus(rs.getString("status"));
				
				list.add(w);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			conn.close();
			stmt.close();
			
		}
		
		return list;
	}

	public ArrayList<Worker> searchKeywordCode(Connection conn, String keyword) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCTemplate.getConnection();
		String sql = "SELECT * FROM WORKER WHERE EMP_CODE=?";
		ArrayList<Worker> list = new ArrayList<Worker>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Worker w = new Worker();
				w.setToday(rs.getString("today"));
				w.setDept(rs.getString("dept"));
				w.setEmp_code(rs.getString("emp_code"));
				w.setO_emp_name(rs.getString("o_emp_name"));
				w.setTime_now(rs.getString("time_now"));
				w.setStatus(rs.getString("status"));
				
				list.add(w);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
		}
		
		return list;
	}

	public ArrayList<Worker> searchKeywordName(Connection conn, String keyword) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCTemplate.getConnection();
		String sql = "SELECT * FROM WORKER WHERE O_EMP_NAME LIKE (?)";
		ArrayList<Worker> list = new ArrayList<Worker>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Worker w = new Worker();
				w.setToday(rs.getString("today"));
				w.setDept(rs.getString("dept"));
				w.setEmp_code(rs.getString("emp_code"));
				w.setO_emp_name(rs.getString("o_emp_name"));
				w.setTime_now(rs.getString("time_now"));
				w.setStatus(rs.getString("status"));
				
				list.add(w);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			pstmt.close();
			rs.close();
			
		}
		return list;
	}

	public ArrayList<Worker> searchKeywordDept(Connection conn, String keyword) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCTemplate.getConnection();
		String sql = "SELECT * FROM WORKER WHERE DEPT=?";
		ArrayList<Worker> list = new ArrayList<Worker>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Worker w = new Worker();
				w.setToday(rs.getString("today"));
				w.setDept(rs.getString("dept"));
				w.setEmp_code(rs.getString("emp_code"));
				w.setO_emp_name(rs.getString("o_emp_name"));
				w.setTime_now(rs.getString("time_now"));
				w.setStatus(rs.getString("status"));
				
				list.add(w);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
		}
		return list;
	}

	public Employee loginWorker(Connection conn, Employee emp) throws SQLException {
		Employee result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM E WHERE EMP_CODE=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmp_code());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = new Employee();
				result.setEmp_code(emp.getEmp_code());
				result.setEmp_name(emp.getEmp_name());
				result.setEmp_gender(emp.getEmp_gender());
				result.setEmp_phone(emp.getEmp_phone());
				result.setDept_code(emp.getDept_code());
				result.setRank_id(emp.getRank_id());
				result.setEmp_retire(emp.getEmp_retire());
				result.setService_point(emp.getService_point());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
		}
		
		return result;
	}

}
