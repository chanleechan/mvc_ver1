package com.kh.pugis.insa.recruit.service;

import java.util.List;
import javax.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.pugis.insa.recruit.dao.EmployeeDao;
import com.kh.pugis.insa.recruit.domain.WaitEmployee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Resource(name = "employeeDao")
	private EmployeeDao dao;
	
	@Override
	public List<WaitEmployee> employeeList() {
		return dao.employeeList();
	}
	@Override
	public List<WaitEmployee> employeeListAll() {
		return dao.employeeListAll();
	}
	
	@Override
	public List<WaitEmployee> newDept(String dept_code,String n_Emp_code) {
		return dao.deptUpdate( dept_code,n_Emp_code);
	}

}
