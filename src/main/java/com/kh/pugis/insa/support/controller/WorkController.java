package com.kh.pugis.insa.support.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.insa.support.domain.Worker;
import com.kh.pugis.insa.support.service.WorkerService;

@Controller
@RequestMapping(value = "/work")

public class WorkController {
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkController.class);
	
	@RequestMapping(value = "/searchKeyword.e", method = RequestMethod.POST)
	
	public String logout(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가등록.",locale);
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		String pageNm = "";
		
		WorkerService ws = new WorkerService();
		ArrayList<Worker> list = null;
		try {
			list = ws.searchKeyword(type, keyword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("workerList", list);
		pageNm = "/web/views/work/workerList.jsp";
		return pageNm;
	}
	
	@SuppressWarnings("unchecked")
	
	@RequestMapping(value = "/goWork", method = RequestMethod.GET)
	
	public String goWork(Model model,Locale locale, HttpServletRequest req,HttpSession session) throws IOException, SQLException, ParseException  {
		logger.info("휴가 목록.",locale);
		String pageNm = "";
		
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}
		
		int result = new WorkerService().insertGoWorker(req,session);
		
		
		if(result > 0) {
			pageNm = "/insa/support/totalPage/mainlogin";
		}else {
			model.addAttribute("msg", "출근 등록 실패!");

		}
		return pageNm;
	}
	
	@SuppressWarnings("unchecked")
	
	@RequestMapping(value = "/offWork", method = RequestMethod.GET)
	
	public String offWork(Model model,Locale locale, HttpServletRequest req,HttpSession session) throws IOException, SQLException, ParseException  {
		logger.info("휴가 목록.",locale);
		String pageNm = "";
		
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}
		
		int result = new WorkerService().insertOffWorker(req,session);
		
		
		if(result > 0) {
			pageNm = "/insa/support/totalPage/mainlogin";
		}else {
			model.addAttribute("msg", "퇴근 등록 실패!");

		}
		return pageNm;
	}
	
	@RequestMapping(value = "/workerList.w", method = RequestMethod.POST)
	
	public String noVacation(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가 목록.",locale);
		String pageNm = "";
		ArrayList<Worker> list = null;
		
		
		WorkerService ws = new WorkerService();
		
		try {
			list = ws.workerList();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(list.size() == 0) {
			model.addAttribute("msg", "일치하는 데이터가 없음");
			pageNm = "/views/common/errorPage.jsp";

			
		} else {
			model.addAttribute("workerList", list);
			pageNm ="/views/worker/workerList.jsp";
		}
		
		return pageNm;
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	
	public String header(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("출퇴근 메인입니다..",locale);
		
		
		String pageNm = "";
		String emp_code = (String)session.getAttribute("emp_code");
		model.addAttribute(emp_code);
		pageNm = "/insa/support/worker/header";
		
		return pageNm;
	}
}
