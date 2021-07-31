package com.kh.pugis.insa.recruit.service;

import java.util.List;
import com.kh.pugis.insa.recruit.domain.WaitEmployee;

public interface EmployeeService {
	List<WaitEmployee> employeeList();
	List<WaitEmployee> employeeListAll();
	List<WaitEmployee> newDept(String dept_code,String n_Emp_code);
	
}
