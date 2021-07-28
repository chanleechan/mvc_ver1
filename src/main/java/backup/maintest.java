package backup;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.insa.support.domain.book;
import com.kh.pugis.insa.support.domain.h_appliance;
import com.kh.pugis.insa.support.service.serviceList;


	
@Controller
@RequestMapping(value = "/backup")

public class maintest {
	HttpServletRequest req;
	
	
	private static final Logger logger = LoggerFactory.getLogger(maintest.class);
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	
	public String firstPage(Locale locale)  {
		logger.info("서비스메인 화면입니다.",locale);
		
		String pageNm = "insa/support/serviceMain";
		
		
		return pageNm;
	}
	
	@RequestMapping(value = "/bookList", method = RequestMethod.GET)
	
	public String bookList(Locale locale, Model model)  {
		logger.info("도서품목입니다.",locale);
		
		ArrayList<book> bookList = null;
		
		serviceList serviceList = new serviceList();
		bookList = serviceList.BookSearch();
		
		String pageNm = "";
		if(bookList.size() == 0) {
			model.addAttribute("searchResult", "도서품목이 품절되었습니다.");
		}else {
			model.addAttribute("searchResultList", bookList);
			pageNm = "insa/support/bookList";
		
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/hList", method = RequestMethod.GET)
	
	public String h_appList(Locale locale, Model model)  {
		logger.info("일반가전품목입니다..",locale);
		
		ArrayList<h_appliance> h_appList = null;
		
		serviceList serviceList = new serviceList();
		h_appList = serviceList.h_appSearch();
		
		String pageNm = "";
		if(h_appList.size() == 0) {
			model.addAttribute("searchResult", "일반가전이 품절되었습니다..");
		}else {
			model.addAttribute("searchResultList", h_appList);
			pageNm = "insa/support/bookList";
		}
		return pageNm;
	}

}
