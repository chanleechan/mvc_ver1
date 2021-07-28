package backup;


import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.pugis.insa.support.domain.b_appliance;
import com.kh.pugis.insa.support.domain.book;
import com.kh.pugis.insa.support.domain.h_appliance;
import com.kh.pugis.insa.support.service.serviceList;



	
@Controller
@RequestMapping(value = "/service")

public class serviceController_back {
	HttpServletRequest req;
	
	
	private static final Logger logger = LoggerFactory.getLogger(serviceController_back.class);
	

	
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
			pageNm = "insa/support/pointMenu/book";
			//pageNm ="testView/book";
		
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/happList", method = RequestMethod.GET)
	
	public String happList(Locale locale, Model model)  {
		logger.info("일반가전품목입니다..",locale);
		
		ArrayList<h_appliance> happList = null;
		
		serviceList serviceList = new serviceList();
		happList = serviceList.h_appSearch();
		
		String pageNm = "";
		if(happList.size() == 0) {
			model.addAttribute("searchResult", "일반가전이 품절되었습니다..");
		}else {
			model.addAttribute("searchResultList", happList);
			pageNm = "insa/support/pointMenu/appliances";
			//pageNm = "testView/work";
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/happListT", method = RequestMethod.GET)
	
	public String happListT(Locale locale, Model model)  {
		logger.info("일반가전품목입니다..",locale);
		
		ArrayList<h_appliance> happList = null;
		
		serviceList serviceList = new serviceList();
		happList = serviceList.h_appSearch();
		
		String pageNm = "";
		if(happList.size() == 0) {
			model.addAttribute("searchResult", "일반가전이 품절되었습니다..");
		}else {
			model.addAttribute("searchResultList", happList);
			pageNm = "testView/appliancesT";
			//pageNm = "testView/work";
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/bappList", method = RequestMethod.GET)
	
	public String bappList(Locale locale, Model model)  {
		logger.info("업무가전품목입니다..",locale);
		
		ArrayList<b_appliance> bappList = null;
		serviceList serviceList = new serviceList();
		bappList = serviceList.b_appSearch();
		
		String pageNm = "";
		if(bappList.size() == 0) {
			model.addAttribute("searchResult", "일반가전이 품절되었습니다..");
		}else {
			model.addAttribute("searchResultList", bappList);
			pageNm = "insa/support/pointMenu/work";
			//pageNm = "testView/appliances";
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/basketList", method = RequestMethod.GET)
	
	public String basketList(Locale locale, Model model ,HttpServletRequest req)  {
		logger.info("장바구니입니다..",locale);
		
		String[] h_app_name = req.getParameterValues("h_appcheck");
		String[] book_name = req.getParameterValues("bookcheck");
		String[] b_app_name = req.getParameterValues("b_appcheck");
		
		HttpSession session = req.getSession();
		//HttpSession session2 = req.getSession();
		ArrayList<book> book_List = null;
		ArrayList<h_appliance> h_app_List = null;
		ArrayList<b_appliance> b_app_List = null;
		
		String maxLangth = "max";
		serviceList service_BookList = new serviceList();
		book_List = service_BookList.BookSearch();
		
		serviceList service_H_appList = new serviceList();
		h_app_List = service_H_appList.h_appSearch();
		
		serviceList service_b_appList = new serviceList();
		b_app_List = service_b_appList.b_appSearch();
		
		ArrayList<book> b_List = new ArrayList<book>();
		ArrayList<h_appliance> n_appList = new ArrayList<h_appliance>();
		ArrayList<b_appliance> b_appList = new ArrayList<b_appliance>();

		
		ArrayList<String> arrayList_Book = new ArrayList<>();
		ArrayList<String> arrayList_H = new ArrayList<>();
		ArrayList<String> arrayList_B = new ArrayList<>();
		if(book_name !=null) {
			for(String temp:book_name) {
				arrayList_Book.add(temp);
			}
		}else if(h_app_name != null) {
			for(String temp:h_app_name) {
				arrayList_H.add(temp);
			}
		}else if(b_app_name != null) {
			for(String temp:b_app_name) {
				arrayList_B.add(temp);
			}
		}
		String pageNm = "";

//-----------------------------스위치--------------------------------//		
	int arrayH	= arrayList_H.size();
	int arrayBook = arrayList_Book.size();
	int arrayB = arrayList_B.size();
	switch(arrayH) {
	case 0 :
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("h_app장바구니 품목이 없습니다.");
		break;
	}
	switch(arrayBook) {
	case 0:
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("book 장바구니 품목이 없습니다.");
		break;
		
	}
	switch(arrayB) {
	case 0 :
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("b_app장바구니 품목이 없습니다.");
	
	}

//----------------------------일반 가전--------------------------------------------------//				
 
			if(h_app_List.size() > 0) {
				System.out.println("일반 가전입니다.");
				for(int i = 0 ; i < arrayList_H.size(); i ++) {
					session.setAttribute("h_appcheck", arrayList_H);
					System.out.println("현재 장바구니 세션 : " + arrayList_H.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_H.size() < h_app_List.size()) {
					for(int i = 0; i < h_app_List.size(); i ++) {
						if(arrayList_H.size() == h_app_List.size()) {
							break;
						}else {
							arrayList_H.add(maxLangth);
						}
					}
				}
				
//					System.out.println("arrayList_H 사이즈 : " + arrayList_H.size());
//					System.out.println("h_app_nameList 사이즈 : " + h_app_List.size());
				
					
				//중복 체크하여 n_appList에 넣어줌
				
				
				int idx = 0;
				for(int i = 0; i < h_app_List.size(); i ++) {
					for(int j = 0; j <arrayList_H.size(); j ++) {
						if(h_app_List.get(i).getH_app_name().equals(arrayList_H.get(j))){
							n_appList.add(idx,h_app_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				//-----------n_appList 값을 세션으로 만들어줌 ------------//

				
				ArrayList<String> hname = new ArrayList<String>();
				ArrayList<String> hcode = new ArrayList<String>();
				ArrayList<Integer> hprice = new ArrayList<Integer>();
				
				
				for(int i = 0; i<n_appList.size(); i ++) {
					hname.add(n_appList.get(i).getH_app_name());
					hcode.add(n_appList.get(i).getH_app_code());
					hprice.add(n_appList.get(i).getH_price());
					
				}
				for(int i = 0; i<hname.size(); i ++) {
					session.setAttribute("hname", hname);
					session.setAttribute("hcode", hcode);
					session.setAttribute("hprice", hprice);
				}
			
				//---------------------------------테스트--------------------------------------//
				
				

				
				for(int i = 0; i<n_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + n_appList.get(i).getH_app_name());
					System.out.println("인덱스 : " +i + " h_app_code : " + n_appList.get(i).getH_app_code());
					System.out.println("인덱스 : " +i + " h_app_price : " + n_appList.get(i).getH_price());
					System.out.println("인덱스 : " +i + " h_app_amount : " + n_appList.get(i).getH_amount());
					System.out.println("세션 hname : "+session.getAttribute("hname"));
					System.out.println("세션 hcode : "+session.getAttribute("hcode"));
					System.out.println("세션 hprice : "+session.getAttribute("hprice"));
					System.out.println();
				}
				if(n_appList.size() != 0) {
					model.addAttribute("searchResultList" , n_appList);
					//pageNm = "insa/support/pointMenu/cart2";
					pageNm = "testView/testC";
					System.out.println(n_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(n_appList.size() == 0){
					pageNm = "insa/support/pointMenu/cart2";
					System.out.println(n_appList.size());
					System.out.println("h_app장바구니 품목이 없습니다.");
				}
			}
//-----------------------도서--------------------------------------------------//
			 
			
			if(book_List.size() > 0) {
			System.out.println("도서입니다.");
				for(int i = 0 ; i < arrayList_Book.size(); i ++) {
					session.setAttribute("bookcheck", arrayList_Book);
					System.out.println("현재 장바구니 세션 : " + arrayList_Book.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_Book.size() < book_List.size()) {
					for(int i = 0; i < book_List.size(); i ++) {
						if(arrayList_Book.size() == book_List.size()) {
							break;
						}else {
							arrayList_Book.add(maxLangth);
						}
					}
				}
				
//				System.out.println("arrayList_Book 사이즈 : " + arrayList_Book.size());
//				System.out.println("book_List 사이즈 : " + arrayList_Book.size());
				int idx = 0;
				for(int i = 0; i < book_List.size(); i ++) {
					for(int j = 0; j <arrayList_Book.size(); j ++) {
						if(book_List.get(i).getBook_name().equals(arrayList_Book.get(j))){
							b_List.add(idx,book_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				
				for(int i = 0; i<b_List.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 Book_name : " + b_List.get(i).getBook_name());
					System.out.println("인덱스 : " +i + " Book_code : " + b_List.get(i).getBook_code());
					System.out.println("인덱스 : " +i + " Book_price : " + b_List.get(i).getBook_price());
					System.out.println("인덱스 : " +i + " Book_amount : " + b_List.get(i).getBook_amount());
					System.out.println();
				}
				if(b_List.size() != 0) {
					model.addAttribute("searchResultList3" , b_List);
					pageNm = "insa/support/pointMenu/cart2";
					System.out.println(b_List.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_List.size() == 0){
					pageNm = "insa/support/pointMenu/cart2";
					System.out.println(b_List.size());
					System.out.println("book장바구니 품목이 없습니다.");
				}
			}
//----------------------------------업무기구------------------------------------------//			
			if(b_app_List.size() > 0) {
				System.out.println("일반 가전입니다.");
				for(int i = 0 ; i < arrayList_B.size(); i ++) {
					session.setAttribute("b_appcheck", arrayList_B);
					System.out.println("현재 장바구니 세션 : " + arrayList_B.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_B.size() < b_app_List.size()) {
					for(int i = 0; i < b_app_List.size(); i ++) {
						if(arrayList_B.size() == b_app_List.size()) {
							break;
						}else {
							arrayList_B.add(maxLangth);
						}
					}
				}
				
//					System.out.println("arrayList_B 사이즈 : " + arrayList_B.size());
//					System.out.println("b_app_nameList 사이즈 : " + b_app_List.size());
				
					
				//중복 체크하여 n_appList에 넣어줌
				
				
				int idx = 0;
				for(int i = 0; i < b_app_List.size(); i ++) {
					for(int j = 0; j <arrayList_B.size(); j ++) {
						if(b_app_List.get(i).getB_app_name().equals(arrayList_B.get(j))){
							b_appList.add(idx,b_app_List.get(i));
							idx++;
							break;
						}
					}
				}
				for(int i = 0; i<b_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + b_appList.get(i).getB_app_name());
					System.out.println("인덱스 : " +i + " h_app_code : " + b_appList.get(i).getB_app_code());
					System.out.println("인덱스 : " +i + " h_app_price : " + b_appList.get(i).getB_price());
					System.out.println("인덱스 : " +i + " h_app_amount : " + b_appList.get(i).getB_amount());
					System.out.println();
				}
				if(b_appList.size() != 0) {
					model.addAttribute("searchResultList2" , b_appList);
					pageNm = "insa/support/pointMenu/cart2";
					System.out.println(b_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_appList.size() == 0){
					pageNm = "insa/support/pointMenu/cart2";
					System.out.println(b_appList.size());
					System.out.println("b_app장바구니 품목이 없습니다.");
				}
			}

		return pageNm;
	}
	
	@RequestMapping(value = "/testC", method = RequestMethod.GET)
	
	public String basket(Locale locale, Model model)  {
		logger.info("장바구니입니다..",locale);
		
		String[] h_app_name = req.getParameterValues("h_appcheck");
		String[] book_name = req.getParameterValues("bookcheck");
		String[] b_app_name = req.getParameterValues("b_appcheck");
		
		HttpSession session = req.getSession();
		//HttpSession session2 = req.getSession();
		ArrayList<book> book_List = null;
		ArrayList<h_appliance> h_app_List = null;
		ArrayList<b_appliance> b_app_List = null;
		
		String maxLangth = "max";
		serviceList service_BookList = new serviceList();
		book_List = service_BookList.BookSearch();
		
		serviceList service_H_appList = new serviceList();
		h_app_List = service_H_appList.h_appSearch();
		
		serviceList service_b_appList = new serviceList();
		b_app_List = service_b_appList.b_appSearch();
		
		ArrayList<book> b_List = new ArrayList<book>();
		ArrayList<h_appliance> n_appList = new ArrayList<h_appliance>();
		ArrayList<b_appliance> b_appList = new ArrayList<b_appliance>();

		
		ArrayList<String> arrayList_Book = new ArrayList<>();
		ArrayList<String> arrayList_H = new ArrayList<>();
		ArrayList<String> arrayList_B = new ArrayList<>();
		if(book_name !=null) {
			for(String temp:book_name) {
				arrayList_Book.add(temp);
			}
		}else if(h_app_name != null) {
			for(String temp:h_app_name) {
				arrayList_H.add(temp);
			}
		}else if(b_app_name != null) {
			for(String temp:b_app_name) {
				arrayList_B.add(temp);
			}
		}
		String pageNm = "";

//-----------------------------스위치--------------------------------//		
	int arrayH	= arrayList_H.size();
	int arrayBook = arrayList_Book.size();
	int arrayB = arrayList_B.size();
	switch(arrayH) {
	case 0 :
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("h_app장바구니 품목이 없습니다.");
		break;
	}
	switch(arrayBook) {
	case 0:
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("book 장바구니 품목이 없습니다.");
		break;
		
	}
	switch(arrayB) {
	case 0 :
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("b_app장바구니 품목이 없습니다.");
	
	}

//----------------------------일반 가전--------------------------------------------------//				
 
			if(h_app_List.size() > 0) {
				System.out.println("일반 가전입니다.");
				for(int i = 0 ; i < arrayList_H.size(); i ++) {
					session.setAttribute("h_appcheck", arrayList_H);
					System.out.println("현재 장바구니 세션 : " + arrayList_H.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_H.size() < h_app_List.size()) {
					for(int i = 0; i < h_app_List.size(); i ++) {
						if(arrayList_H.size() == h_app_List.size()) {
							break;
						}else {
							arrayList_H.add(maxLangth);
						}
					}
				}
				
//					System.out.println("arrayList_H 사이즈 : " + arrayList_H.size());
//					System.out.println("h_app_nameList 사이즈 : " + h_app_List.size());
				
					
				//중복 체크하여 n_appList에 넣어줌
				
				
				int idx = 0;
				for(int i = 0; i < h_app_List.size(); i ++) {
					for(int j = 0; j <arrayList_H.size(); j ++) {
						if(h_app_List.get(i).getH_app_name().equals(arrayList_H.get(j))){
							n_appList.add(idx,h_app_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				//-----------n_appList 값을 세션으로 만들어줌 ------------//

				
				ArrayList<String> hname = new ArrayList<String>();
				ArrayList<String> hcode = new ArrayList<String>();
				ArrayList<Integer> hprice = new ArrayList<Integer>();
				
				
				for(int i = 0; i<n_appList.size(); i ++) {
					hname.add(n_appList.get(i).getH_app_name());
					hcode.add(n_appList.get(i).getH_app_code());
					hprice.add(n_appList.get(i).getH_price());
					
				}
				for(int i = 0; i<hname.size(); i ++) {
					session.setAttribute("hname", hname);
					session.setAttribute("hcode", hcode);
					session.setAttribute("hprice", hprice);
				}
			//-------------------------------------------------------------------//
				
				

				
				for(int i = 0; i<n_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + n_appList.get(i).getH_app_name());
					System.out.println("인덱스 : " +i + " h_app_code : " + n_appList.get(i).getH_app_code());
					System.out.println("인덱스 : " +i + " h_app_price : " + n_appList.get(i).getH_price());
					System.out.println("인덱스 : " +i + " h_app_amount : " + n_appList.get(i).getH_amount());
					System.out.println("세션 hname : "+session.getAttribute("hname"));
					System.out.println("세션 hcode : "+session.getAttribute("hcode"));
					System.out.println("세션 hprice : "+session.getAttribute("hprice"));
					System.out.println();
				}
				
				
				if(n_appList.size() != 0) {
					model.addAttribute("searchResultList" , n_appList);
					pageNm = "testView/testC";
					System.out.println(n_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(n_appList.size() == 0){
					pageNm = "testView/testC";
					System.out.println(n_appList.size());
					System.out.println("h_app장바구니 품목이 없습니다.");
				}
			}
//-----------------------도서--------------------------------------------------//
			 
			
			if(book_List.size() > 0) {
			System.out.println("도서입니다.");
				for(int i = 0 ; i < arrayList_Book.size(); i ++) {
					session.setAttribute("bookcheck", arrayList_Book);
					System.out.println("현재 장바구니 세션 : " + arrayList_Book.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_Book.size() < book_List.size()) {
					for(int i = 0; i < book_List.size(); i ++) {
						if(arrayList_Book.size() == book_List.size()) {
							break;
						}else {
							arrayList_Book.add(maxLangth);
						}
					}
				}
				
//				System.out.println("arrayList_Book 사이즈 : " + arrayList_Book.size());
//				System.out.println("book_List 사이즈 : " + arrayList_Book.size());
				int idx = 0;
				for(int i = 0; i < book_List.size(); i ++) {
					for(int j = 0; j <arrayList_Book.size(); j ++) {
						if(book_List.get(i).getBook_name().equals(arrayList_Book.get(j))){
							b_List.add(idx,book_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				ArrayList<String> bookname = new ArrayList<String>();
				ArrayList<String> bookcode = new ArrayList<String>();
				ArrayList<Integer> bookprice = new ArrayList<Integer>();
				
				
				for(int i = 0; i<book_List.size(); i ++) {
					bookname.add(book_List.get(i).getBook_name());
					bookcode.add(book_List.get(i).getBook_code());
					bookprice.add(book_List.get(i).getBook_price());
					
				}
				for(int i = 0; i<book_List.size(); i ++) {
					session.setAttribute("bookname", bookname);
					session.setAttribute("bookcode", bookcode);
					session.setAttribute("bookprice", bookprice);
				}
				
				
				for(int i = 0; i<b_List.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 Book_name : " + b_List.get(i).getBook_name());
					System.out.println("인덱스 : " +i + " Book_code : " + b_List.get(i).getBook_code());
					System.out.println("인덱스 : " +i + " Book_price : " + b_List.get(i).getBook_price());
					System.out.println("인덱스 : " +i + " Book_amount : " + b_List.get(i).getBook_amount());
					System.out.println();
				}
				if(b_List.size() != 0) {
					//model.addAttribute("searchResultList3" , b_List);
					pageNm = "testView/testC";
					System.out.println(b_List.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_List.size() == 0){
					pageNm = "testView/testC";
					System.out.println(b_List.size());
					System.out.println("book장바구니 품목이 없습니다.");
				}
			}
//----------------------------------업무기구------------------------------------------//			
			if(b_app_List.size() > 0) {
				System.out.println("일반 가전입니다.");
				for(int i = 0 ; i < arrayList_B.size(); i ++) {
					session.setAttribute("b_appcheck", arrayList_B);
					System.out.println("현재 장바구니 세션 : " + arrayList_B.get(i));
				}
				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
				//길이가 장바구니가 짧으면 추가해줌
				if(arrayList_B.size() < b_app_List.size()) {
					for(int i = 0; i < b_app_List.size(); i ++) {
						if(arrayList_B.size() == b_app_List.size()) {
							break;
						}else {
							arrayList_B.add(maxLangth);
						}
					}
				}
				
//					System.out.println("arrayList_B 사이즈 : " + arrayList_B.size());
//					System.out.println("b_app_nameList 사이즈 : " + b_app_List.size());
				
					
				//중복 체크하여 n_appList에 넣어줌
				
				
				int idx = 0;
				for(int i = 0; i < b_app_List.size(); i ++) {
					for(int j = 0; j <arrayList_B.size(); j ++) {
						if(b_app_List.get(i).getB_app_name().equals(arrayList_B.get(j))){
							b_appList.add(idx,b_app_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				ArrayList<String> bname = new ArrayList<String>();
				ArrayList<String> bcode = new ArrayList<String>();
				ArrayList<Integer> bprice = new ArrayList<Integer>();
				
				
				for(int i = 0; i<b_appList.size(); i ++) {
					bname.add(b_app_List.get(i).getB_app_name());
					bcode.add(b_app_List.get(i).getB_app_code());
					bprice.add(b_app_List.get(i).getB_price());
					
				}
				for(int i = 0; i<bname.size(); i ++) {
					session.setAttribute("bname", bname);
					session.setAttribute("bcode", bcode);
					session.setAttribute("bprice", bprice);
				}
				for(int i = 0; i<b_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + b_appList.get(i).getB_app_name());
					System.out.println("인덱스 : " +i + " h_app_code : " + b_appList.get(i).getB_app_code());
					System.out.println("인덱스 : " +i + " h_app_price : " + b_appList.get(i).getB_price());
					System.out.println("인덱스 : " +i + " h_app_amount : " + b_appList.get(i).getB_amount());
					System.out.println();
				}
				if(b_appList.size() != 0) {
					//model.addAttribute("searchResultList2" , b_appList);
					pageNm = "testView/testC";
					System.out.println(b_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_appList.size() == 0){
					pageNm = "testView/testC";
					System.out.println(b_appList.size());
					System.out.println("b_app장바구니 품목이 없습니다.");
				}
			}

		return pageNm;
	}
}
