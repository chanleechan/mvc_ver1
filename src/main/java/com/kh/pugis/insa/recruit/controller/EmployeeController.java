package com.kh.pugis.insa.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.pugis.insa.recruit.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	
	@RequestMapping(value="/list1")
	public String list1(Model model){
		model.addAttribute("list", employeeService.list1());
		return "insa/recruit/list";
	}
	
	@RequestMapping(value="/list2")
	public String list2(Model model){
		model.addAttribute("list", employeeService.list1());
		return "insa/recruit/main2";
	}
}
