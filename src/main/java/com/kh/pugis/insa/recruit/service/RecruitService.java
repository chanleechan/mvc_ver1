package com.kh.pugis.insa.recruit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.pugis.insa.recruit.dao.RecruitDao;
import com.kh.pugis.insa.recruit.domain.WaitEmployee;
import com.kh.pugis.insa.support.domain.Employee;

public class RecruitService {
	
	public RecruitService() {
		
	}
	
	public ArrayList<WaitEmployee> waitList(){
		ArrayList<WaitEmployee> waitList = 
				new ArrayList<WaitEmployee>();
		waitList = new RecruitDao().waitEmployeeList();
		
		return waitList;
	}
	
	public ArrayList<Employee> empList(){
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();
		empList = new RecruitDao().allEmployeeList();
		
		return empList;
	}
	
	public int deptUpdate(HttpServletRequest req) {
		int result = 0;
		result = new RecruitDao().deptUpdate(req);
		
		return result;
	}

}
