package com.kh.pugis.insa.support.service;

import com.kh.pugis.insa.support.utils.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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

	public Vacation_work selectOne(String vacation_code) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		Vacation_work vw = new VacationDao().selectOne(conn, vacation_code);
		
		conn.close();
		
		return vw;
	}

	public int okVacation(Vacation_work vw) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new VacationDao().okVacation(conn, vw);
		
		if(result > 0) conn.close();
		else conn.rollback();		
		conn.close();
		
		return result;
	}

	public int noVacation(Vacation_work vw) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new VacationDao().noVacation(conn, vw);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		conn.close();
		
		return result;
	}
	
	public ArrayList<String> vSeqmax(){
		ArrayList<String> vSeqMax = 
				new ArrayList<String>();
		vSeqMax = new VacationDao().maxseq();
		return vSeqMax;
	}

}
