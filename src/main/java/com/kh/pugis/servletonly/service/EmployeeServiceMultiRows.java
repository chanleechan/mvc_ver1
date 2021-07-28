package com.kh.pugis.servletonly.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.pugis.servletonly.dao.EmployeeDaoMultiRows;
import com.kh.pugis.servletonly.domain.EmployeeVoMultiRows;

public class EmployeeServiceMultiRows {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public EmployeeServiceMultiRows() {}
	
	public ArrayList<EmployeeVoMultiRows> userSearch() {
		ArrayList<EmployeeVoMultiRows> retArrList = 
				new ArrayList<EmployeeVoMultiRows>();
		retArrList = new EmployeeDaoMultiRows().userSearch();
		return retArrList;
	}
}
