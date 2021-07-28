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
import com.kh.pugis.insa.support.service.serviceList;


	
@Controller
@RequestMapping(value = "/backup")

public class bookList {
	HttpServletRequest req;
	
	
	private static final Logger logger = LoggerFactory.getLogger(bookList.class);
	
	@RequestMapping(value = "/bookList", method = RequestMethod.GET)
	
	public String firstPage(Locale locale, Model model)  {
		logger.info("처음화면입니다..",locale);
		
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
	
	
	



}
