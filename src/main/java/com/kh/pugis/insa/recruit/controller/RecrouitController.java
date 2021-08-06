package com.kh.pugis.insa.recruit.controller;


import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.insa.recruit.dao.RecruitDao;
import com.kh.pugis.insa.recruit.domain.WaitEmployee;
import com.kh.pugis.insa.support.domain.Employee;



@Controller
@RequestMapping(value = "/employee")

public class RecrouitController {
	HttpServletRequest req;
	HttpServletResponse resp;
	
	
	private static final Logger logger = LoggerFactory.getLogger(RecrouitController.class);
	
	@RequestMapping(value="/recruitMain")
	public String main(Locale locale,Model model){
		logger.info("직원배치 메인입니다.",locale);
		
		String pageNm = "/insa/recruit/recruitMain";
		
		return pageNm;
	}
	
	@RequestMapping(value="/waitEmployeeList")
	public String waitEmployeeList(Locale locale,Model model){
		logger.info("대기발령직원목록 입니다.",locale);
		String pageNm = "";
		ArrayList<WaitEmployee> waitList = null;
		RecruitDao ed = new RecruitDao();
		
		waitList = ed.waitEmployeeList();
		if(waitList.size() != 0) {
			model.addAttribute("waitList",waitList);
			pageNm = "/insa/recruit/waitEmployeeList";
		}else {
			pageNm = "/insa/recruit/waitEmployeeList";
			
		}
		
		return pageNm;
	}
	
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	
	public String logout(Locale locale, Model model)  {
		logger.info("부서있는 직원 목록입니다..",locale);
		String pageNm = "";
		ArrayList<Employee> empList = null;
		RecruitDao ed = new RecruitDao();
		empList = ed.allEmployeeList();
		if(empList.size() != 0) {
		model.addAttribute("empList",empList);
		pageNm = "insa/recruit/employeeListAll";
		}else {
			pageNm = "insa/recruit/employeeListAll";
		}
		
		return pageNm;
	}
	
	@RequestMapping(value = "/deptUpdate", method = RequestMethod.GET)
	
	public String deptUpdate(Locale locale, Model model,HttpServletRequest req)  {
		logger.info("부서있는 직원 목록입니다..",locale);
		String pageNm = "";
		int result = 0;
		
		RecruitDao ed = new RecruitDao();
		result = ed.deptUpdate(req);
		if(result != 0) {
		
			pageNm = "insa/support/totalPage/mainlogin";
			System.out.println("변경하였습니다.");
		}else {
			pageNm = "insa/support/totalPage/mainlogin";
		}
		
		return pageNm;
	}
	
}
