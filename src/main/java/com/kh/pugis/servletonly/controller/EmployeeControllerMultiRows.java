package com.kh.pugis.servletonly.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.servletonly.domain.EmployeeVoMultiRows;
import com.kh.pugis.servletonly.service.EmployeeServiceMultiRows;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/servlet")
public class EmployeeControllerMultiRows {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerMultiRows.class);
	
	@RequestMapping(value = "/selectall", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		ArrayList<EmployeeVoMultiRows> retArrList = null;
		
		// 서비스 코드 호출 : 서비스 객체 메소드에 emp_name 전달
		EmployeeServiceMultiRows usersvc = new EmployeeServiceMultiRows();
		// 일치하는 사원명의 정보를 담은 dao 객체를 받아옴
		retArrList = usersvc.userSearch();

		String pageNm = "";
		
		// 페이지 결정
		if(retArrList.size() == 0) {
			model.addAttribute("searchResult", "일치하는 데이터가 없습니다.");
			pageNm = "servletonly/error";
		} else {
			model.addAttribute("searchResultList", retArrList);
			pageNm = "servletonly/matchdata_multirows";
		}
		
		return pageNm;
	}
	
}
