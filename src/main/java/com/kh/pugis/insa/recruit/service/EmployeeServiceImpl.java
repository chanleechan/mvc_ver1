package com.kh.pugis.insa.recruit.service;

import java.util.List;
import javax.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.pugis.insa.recruit.dao.EmployeeDao;
import com.kh.pugis.insa.recruit.domain.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Resource(name = "employeeDao")
	private EmployeeDao dao;
	
	@Override
	public List<Employee> list1() {
		return dao.list1();
	}
}
