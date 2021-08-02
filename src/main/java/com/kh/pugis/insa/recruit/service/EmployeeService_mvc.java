package com.kh.pugis.insa.recruit.service;

import java.util.ArrayList;

import com.kh.pugis.insa.recruit.dao.EmployeeDao_mvc;
import com.kh.pugis.insa.recruit.domain.WaitEmployee;
import com.kh.pugis.insa.support.domain.Employee;

public class EmployeeService_mvc {
	
	public EmployeeService_mvc() {
		
	}
	
	public ArrayList<WaitEmployee> waitList(){
		ArrayList<WaitEmployee> waitList = 
				new ArrayList<WaitEmployee>();
		waitList = new EmployeeDao_mvc().waitEmployeeList();
		
		return waitList;
	}
	
	public ArrayList<Employee> empList(){
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();
		empList = new EmployeeDao_mvc().allEmployeeList();
		
		return empList;
	}

}
