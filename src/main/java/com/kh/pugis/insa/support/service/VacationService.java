package com.kh.pugis.insa.support.service;

import com.kh.pugis.insa.support.utils.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.pugis.insa.support.dao.VacationDao;
import com.kh.pugis.insa.support.domain.Vacation_work;

public class VacationService {

	public VacationService(){}
	
	public int insertVacation(Vacation_work vw, HttpServletRequest request) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new VacationDao().insertVacation(conn, vw, request);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		conn.close();
		
		return result;
	}

	public ArrayList<Vacation_work> selectList() throws SQLException {
		ArrayList<Vacation_work> vacationList= null;
		vacationList = new VacationDao().selectList();
		
		
		return vacationList;
	}
	public ArrayList<Vacation_work> selectListAll() throws SQLException {
		ArrayList<Vacation_work> vacationList= null;
		vacationList = new VacationDao().selectListAll();
		
		
		return vacationList;
	}

	public ArrayList<Vacation_work> myVacationList(HttpSession session) throws SQLException {
		ArrayList<Vacation_work> myList = null;
		myList = new VacationDao().myVacationList(session);
		
		return myList;
	}

//	public int okVacation(Vacation_work vw) throws SQLException {
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = new VacationDao().okVacation( vw);
//		
//		if(result > 0) conn.close();
//		else conn.rollback();		
//		conn.close();
//		
//		return result;
//	}

	public int vacationCommit(HttpServletRequest req, HttpSession session) throws SQLException {
		
		
		int result = new VacationDao().vacationCommit(req,session);
		
		return result;
	}
	
	public ArrayList<String> vSeqmax(){
		ArrayList<String> vSeqMax = 
				new ArrayList<String>();
		vSeqMax = new VacationDao().maxseq();
		return vSeqMax;
	}

}
