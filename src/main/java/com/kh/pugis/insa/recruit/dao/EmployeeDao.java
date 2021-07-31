package com.kh.pugis.insa.recruit.dao;

import java.util.List;

import com.kh.pugis.insa.recruit.domain.WaitEmployee;
//mapper Interface
//mapper 파일에 기재된 sql을 호출하기 위한 인터페이스
//매핑 파일에 있는 sql을 인터페이스로 호출한다.
public interface EmployeeDao {
	
	List<WaitEmployee> employeeList();
	List<WaitEmployee> employeeListAll();
	List<WaitEmployee> deptUpdate(String dept_code,String n_Emp_code);
}



