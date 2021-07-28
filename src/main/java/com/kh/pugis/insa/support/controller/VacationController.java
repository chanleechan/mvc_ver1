package com.kh.pugis.insa.support.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.kh.pugis.insa.support.dao.VacationDao;
import com.kh.pugis.insa.support.domain.Vacation_work;
import com.kh.pugis.insa.support.service.VacationService;


@Controller
@RequestMapping(value = "/vacation")

public class VacationController {
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	private static final Logger logger = LoggerFactory.getLogger(VacationController.class);
	
	@RequestMapping(value = "/vInsert.va", method = RequestMethod.GET)
	
	public String vInsert(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가등록.",locale);
		String pageNm = "";
		Vacation_work vw = new Vacation_work();
		
		int result = 0;
		try {
			result = new VacationService().insertVacation(vw, request);
			if(result > 0) {
				// 성공
				pageNm = "/insa/support/worker/index";
			} else { 
				// 실패
				model.addAttribute("msg", "휴가 신청 등록 실패!");
				//pageNm = "views/common/errorPage.jsp";
				pageNm = "/common/errorPage.jsp";
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/insertVacationOk", method = RequestMethod.POST)
	
	public String insertVacationOk(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가등록.",locale);
		String pageNm = "";
		
		pageNm = "insa/";
		
		return pageNm;
	}
	
	@RequestMapping(value = "/insertVacationNo", method = RequestMethod.POST)
	
	public String insertVacationNo(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가등록.",locale);
		String pageNm = "";
		
		pageNm = "insa/";
		
		return pageNm;
	}
	
	@RequestMapping(value = "/selectVacation", method = RequestMethod.GET)
	
	public String selectList(Model model,Locale locale, HttpServletRequest request ) throws IOException, SQLException  {
		logger.info("휴가 목록.",locale);
		
		ArrayList<Vacation_work> vacationList = null;
		VacationService vs = new VacationService();
		vacationList = vs.selectList();
		
		String page = "";
		if(vacationList != null) {
			
			model.addAttribute("vaList", vacationList);
			page = "/insa/support/vacation/vacationList";
		} else {
			page = "views/common/errorPage";
			model.addAttribute("msg", "공지사항 목록 불러오기 에러!");
		}
		
		
		
		return page;
	}
	
@RequestMapping(value = "/vNo.va", method = RequestMethod.POST)
	
	public String noVacation(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
		logger.info("휴가 목록.",locale);
		
		String status = request.getParameter("status");
		String pageNm = "";
		Vacation_work vw = new Vacation_work();
		
		vw.setStatus("반려");
		
		int result = 0;
		try {
			result = new VacationService().noVacation(vw);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result > 0) {
			pageNm = "vSelectOne.va?status=" + status;
		} else {
			model.addAttribute("msg","공지사항 수정 실패!!");
			
		
		}
		return pageNm;
	}

	@RequestMapping(value = "/vOk.va", method = RequestMethod.POST)

	public String okVacation(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
	logger.info("휴가 목록.",locale);
	
		String status = request.getParameter("status");
		String pageNm = "";
		Vacation_work vw = new Vacation_work();
		
		vw.setStatus("승인");
		
		int result = 0;
		try {
			result = new VacationService().noVacation(vw);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result > 0) {
			pageNm = "vSelectOne.va?status=" + status;
		} else {
			model.addAttribute("msg","공지사항 수정 실패!!");
			
		
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/SelectOne.va", method = RequestMethod.POST)

	public String selectOne(Model model,Locale locale, HttpServletRequest request ) throws IOException  {
	logger.info("휴가 목록.",locale);
	
		String vacation_code = request.getParameter("vacation_code");
		
		Vacation_work vw = null;
		try {
			vw = new VacationService().selectOne(vacation_code);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		String page = "";
		
		if(vw != null) {
			page = "views/vacation/vacationDetail.jsp";
			model.addAttribute("vacation_work", vw);
		}else {
			page = "views/common/errorPage.jsp";
			model.addAttribute("msg", "휴가 신청서 상세 보기 실패!");
		}
		return page;
		
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)

	public String header(Model model,Locale locale, HttpServletRequest request,HttpSession session ) throws IOException, SQLException  {
	logger.info("휴가 목록.",locale);
	
		int check = 0;
		String page = "";
		String emp_name = (String)session.getAttribute("emp_name");
		
		VacationDao vd = new VacationDao();
		 check = vd.empName(request,session);
		if(check > 0 || emp_name != null) {
			page = "/insa/support/worker/index";
		}
			
		
		
		return page;
	}
	
	@RequestMapping(value = "/vacationAdd", method = RequestMethod.GET)
	public String vacationAdd(Model model,Locale locale, HttpServletRequest request ) throws IOException, SQLException  {
	logger.info("휴가 목록.",locale);
		String page = "";
		
		page = "/insa/support/vacation/vacationForm";
		
		
		return page;
	}
	

}