package com.kh.pugis.insa.support.service;

import com.kh.pugis.insa.support.utils.JDBCTemplate;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.pugis.insa.support.dao.WorkerDao;
import com.kh.pugis.insa.support.domain.Employee;
import com.kh.pugis.insa.support.domain.Worker;

public class WorkerService {

	private WorkerDao wDao = new WorkerDao();
	
	public int insertGoWorker(HttpServletRequest req,HttpSession session) throws SQLException, ParseException {
		
		int result = wDao.insertGoWorker(req,session);
				
		return result;
	}
	
	public int insertOffWorker(HttpServletRequest req,HttpSession session) throws SQLException, ParseException {
		
		int result = wDao.insertOffWorker(req,session);
				
		return result;
	}

	public ArrayList<Worker> workerList() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Worker> list = new WorkerDao().workerList(conn);
		
		conn.close();
		
		return list;
	}

	public ArrayList<Worker> searchKeyword(String type, String keyword) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Worker> list = null;
		WorkerDao wDao = new WorkerDao();
		switch (type) {
		case "emp_code": list = wDao.searchKeywordCode(conn, keyword); break;
		case "o_emp_name" : list = wDao.searchKeywordName(conn, keyword); break;
		case "dept" : list = wDao.searchKeywordDept(conn, keyword); break;
		}
		conn.close();
		return list;
	}

	public Employee loginWorker(Employee emp) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		Employee result = new WorkerDao().loginWorker(conn, emp);
		
		conn.close();
		
		return result;
	}

}
