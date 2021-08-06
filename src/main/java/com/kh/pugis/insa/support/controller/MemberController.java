package com.kh.pugis.insa.support.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.insa.support.dao.MemberDao;

@Controller
@RequestMapping(value = "/total")

public class MemberController {
	HttpServletRequest req;
	HttpServletResponse resp;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	
	public String logout(Locale locale)  {
		logger.info("로그아웃 처리.",locale);
		
		String pageNm = "insa/support/totalPage/logout";
		
		
		return pageNm;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	
	public String firstPage1(Locale locale)  {
		logger.info("메인 화면입니다..",locale);
		
		String pageNm = "insa/support/totalPage/main";
		
		
		return pageNm;
	}
	
//	@SuppressWarnings("unchecked")
//String value = session.getAttribute(session2).toString(); 부분

	@RequestMapping(value = "/loginPro", method = RequestMethod.POST)
	
	public String loginPro(Locale locale ,HttpServletRequest req, HttpSession session) throws IOException, SQLException  {
		logger.info("로그인화면입니다.",locale);
		
		int ck;
		String pageNm = null;
		String emp_id = req.getParameter("emp_id");
		String f_emp_pass = req.getParameter("f_emp_pass");
		MemberDao ma = new MemberDao();
		
		ck = ma.userCheck(emp_id, f_emp_pass, session);
		
			if(ck == 1) {
				session = req.getSession();
				session.setAttribute("emp_id", emp_id);
				pageNm = "insa/support/totalPage/mainlogin";
			}else if(ck == 0 || ck == -1){
				pageNm = "insa/support/totalPage/main";
				System.out.println("아이디나 비밀번호가 올바르지 않습니다.");
			}
			System.out.println(ck);		
		return pageNm;
	}	
	@RequestMapping(value = "/servicePage", method = RequestMethod.GET)
	
	public String servicePage(Locale locale)  {
		logger.info("서비스 메인화면입니다...",locale);
		
		String pageNm = "insa/support/service/serviceMain";
		
		
		return pageNm;
	}
	
	@RequestMapping(value = "/goMain", method = RequestMethod.GET)
	
	public String inputPro(Locale locale)  {
		logger.info("메인화면입니다..",locale);
		
		String pageNm = "insa/support/totalPage/mainlogin";
		
		
		return pageNm;
	}
	
	@RequestMapping(value = "/inputform", method = RequestMethod.GET)
	
	public String inputForm(Locale locale)  {
		logger.info("복지등록 화면입니다.",locale);
		
		String pageNm = "insa/support/totalPage/inputForm";
		
		
		return pageNm;
	}
	
	@RequestMapping(value = "/confirmId", method = RequestMethod.GET)
	
	public String confirmId(Locale locale, HttpServletRequest req) throws SQLException  {
		logger.info("복지등록 화면입니다.",locale);
		
		String emp_id = req.getParameter("emp_id");
		
		MemberDao md = new MemberDao();
		
		int i = md.confirmId(emp_id,req);
		
		String pageNm = "";
		
		if(i == 1) {
			 pageNm = "insa/support/totalPage/confirmIdOk";
		}else {
			pageNm = "insa/support/totalPage/confirmIdFail";
		}
		
		return pageNm;
	}
	
	@RequestMapping(value = "/joinMember", method = RequestMethod.GET)
	
	public String joinMember(Locale locale, HttpServletRequest req) throws SQLException  {
		logger.info("회원가입완료..",locale);
		int check = 0;
		MemberDao md = new MemberDao();
		check = md.insertMember(req);
		String pageNm = "";
		if(check == 1) {
			pageNm = "insa/support/totalPage/main";
		}else {
			pageNm = "insa/support/totalPage/main";
		}
		
		return pageNm;
	}
	
}
