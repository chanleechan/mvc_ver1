package com.kh.pugis.insa.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.pugis.insa.recruit.service.EmployeeService;

@Controller
@RequestMapping(value = "/employeeMybatis")
public class EmployeeController_mybatis {
	@Autowired EmployeeService employeeService;
	
	@RequestMapping(value="/employeeList")
	public String list1(Model model){
		model.addAttribute("list", employeeService.employeeList());
		return "/insa/recruit/employeeListAll";
	}
	
	@RequestMapping(value="/recruitMain")
	public String main(Model model){
		
		return "/insa/recruit/recruitMain";
	}
	
	@RequestMapping(value="/waitList")
	public String list2(Model model){
		model.addAttribute("list", employeeService.employeeListAll());
		return "insa/recruit/waitEmployeeList";
	}
	
	@RequestMapping(value="/deptUpdate")
	public String deptUpdate(Model model,String dept_code,String n_Emp_code){
		model.addAttribute("list", employeeService.newDept(dept_code, n_Emp_code));
		return "insa/recruit/waitEmployeeList";
	}
}
