package com.kh.pugis.insa.support.controller;


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

import com.kh.pugis.insa.support.dao.MemberDao;
import com.kh.pugis.insa.support.domain.B_Appliance;
import com.kh.pugis.insa.support.domain.BasketInfo;
import com.kh.pugis.insa.support.domain.Book;
import com.kh.pugis.insa.support.domain.H_Appliance;
import com.kh.pugis.insa.support.service.serviceList;

	
@Controller
@RequestMapping(value = "/test")

public class ServiceController {
	HttpServletRequest req;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	

	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	
	public String happList(Locale locale, Model model)  {
		logger.info("일반가전품목입니다..",locale);
		//-------------일반가전-----------//
		ArrayList<H_Appliance> happList = null;
		serviceList serviceList = new serviceList();
		happList = serviceList.h_appSearch();
		//-------------업무가전-----------//
		ArrayList<B_Appliance> bappList = null;
		serviceList = new serviceList();
		bappList = serviceList.b_appSearch();
		//-------------도서---------------//
		ArrayList<Book> bookList = null;
		serviceList = new serviceList();
		bookList = serviceList.BookSearch();
		
		String pageNm = "";
		if(happList.size() == 0 && bappList.size()==0 && bookList.size() == 0) {
			model.addAttribute("searchResult", "모든제품이 품절되었습니다.");
		}else {
			model.addAttribute("happList", happList);
			model.addAttribute("bookList",bookList);
			model.addAttribute("bappList",bappList);
			pageNm = "insa/support/test/product";
			//pageNm = "testView/work";
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/basketList", method = RequestMethod.POST)
	
	public String basketList(Locale locale, Model model ,HttpServletRequest req)  {
		logger.info("장바구니입니다..",locale);
		
		String[] h_app_code = req.getParameterValues("h_appcheck");
		String[] book_code = req.getParameterValues("bookcheck");
		String[] b_app_code = req.getParameterValues("b_appcheck");
		
		HttpSession session = req.getSession();
		//HttpSession session2 = req.getSession();
		ArrayList<Book> book_List = null;
		ArrayList<H_Appliance> h_app_List = null;
		ArrayList<B_Appliance> b_app_List = null;
		
		String maxLangth = "max";
		serviceList service_BookList = new serviceList();
		book_List = service_BookList.BookSearch();
		
		serviceList service_H_appList = new serviceList();
		h_app_List = service_H_appList.h_appSearch();
		
		serviceList service_b_appList = new serviceList();
		b_app_List = service_b_appList.b_appSearch();
		
		ArrayList<Book> b_List = new ArrayList<Book>();
		ArrayList<H_Appliance> n_appList = new ArrayList<H_Appliance>();
		ArrayList<B_Appliance> b_appList = new ArrayList<B_Appliance>();

		
		ArrayList<String> arrayList_Book = new ArrayList<String>();
		ArrayList<String> arrayList_H = new ArrayList<String>();
		ArrayList<String> arrayList_B = new ArrayList<String>();
		if(book_code !=null) {
			for(String temp:book_code) {
				arrayList_Book.add(temp);
			}
		} 
		if(h_app_code != null) {
			for(String temp:h_app_code) {
				arrayList_H.add(temp);
			}
		} 
		if(b_app_code != null) {
			for(String temp:b_app_code) {
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
		System.out.println("h_app장바구니 품목이 없습니다.(163)");
		break;
	}
	switch(arrayBook) {
	case 0:
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("book 장바구니 품목이 없습니다.(169)");
		break;
		
	}
	switch(arrayB) {
	case 0 :
		pageNm = "insa/support/pointMenu/cart2";
		System.out.println("b_app장바구니 품목이 없습니다.(176)");
	
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
						if(h_app_List.get(i).getH_app_code().equals(arrayList_H.get(j))){
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
//				for(int i = 0; i<hname.size(); i ++) {
//					session.setAttribute("hname", hname);
//					session.setAttribute("hcode", hcode);
//					session.setAttribute("hprice", hprice);
//				}
//				System.out.println("세션 hname : "+session.getAttribute("hname"));
//				System.out.println("세션 hcode : "+session.getAttribute("hcode"));
//				System.out.println("세션 hprice : "+session.getAttribute("hprice"));
//				System.out.println("");
			
				//---------------------------------테스트--------------------------------------//
				
				

				
				for(int i = 0; i<n_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 h_app_code : " + n_appList.get(i).getH_app_code());
					System.out.println("인덱스 : " +i + " h_app_code : " + n_appList.get(i).getH_app_code());
					System.out.println("인덱스 : " +i + " h_app_price : " + n_appList.get(i).getH_price());
					System.out.println("인덱스 : " +i + " h_app_amount : " + n_appList.get(i).getH_amount());
					System.out.println();
				}
				if(n_appList.size() != 0) {
					model.addAttribute("n_appList" , n_appList);
					//pageNm = "insa/support/pointMenu/cart2";
					pageNm = "insa/support/test/cart";
					System.out.println(n_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(n_appList.size() == 0){
					pageNm = "insa/support/test/cart";
					System.out.println(n_appList.size());
					System.out.println("h_app장바구니 품목이 없습니다.");
					System.out.println("line263");
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
						if(book_List.get(i).getBook_code().equals(arrayList_Book.get(j))){
							b_List.add(idx,book_List.get(i));
							idx++;
							break;
						}
					}
				}
				
				ArrayList<String> bookname = new ArrayList<String>();
				ArrayList<String> bookcode = new ArrayList<String>();
				ArrayList<Integer> bookprice = new ArrayList<Integer>();
				
				
				for(int i = 0; i<b_List.size(); i ++) {
					bookname.add(b_List.get(i).getBook_name());
					bookcode.add(b_List.get(i).getBook_code());
					bookprice.add(b_List.get(i).getBook_price());
					
				}
				for(int i = 0; i<b_List.size(); i ++) {
					session.setAttribute("bookname", bookname);
					session.setAttribute("bookcode", bookcode);
					session.setAttribute("bookprice", bookprice);
				}
				System.out.println("세션 bookname : "+session.getAttribute("bookname"));
				System.out.println("세션 bookcode : "+session.getAttribute("bookcode"));
				System.out.println("세션 bookprice : "+session.getAttribute("bookprice"));
				System.out.println("");
				
				
				for(int i = 0; i<b_List.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 Book_code : " + b_List.get(i).getBook_code());
					System.out.println("인덱스 : " +i + " Book_code : " + b_List.get(i).getBook_code());
					System.out.println("인덱스 : " +i + " Book_price : " + b_List.get(i).getBook_price());
					System.out.println("인덱스 : " +i + " Book_amount : " + b_List.get(i).getBook_amount());
					System.out.println();
				}
				if(b_List.size() != 0) {
					model.addAttribute("b_List" , b_List);
					pageNm = "insa/support/test/cart";
					System.out.println(b_List.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_List.size() == 0){
					pageNm = "insa/support/test/cart";
					System.out.println(b_List.size());
					System.out.println("book장바구니 품목이 없습니다.");
					System.out.println("line 316");
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
						if(b_app_List.get(i).getB_app_code().equals(arrayList_B.get(j))){
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
					bname.add(b_appList.get(i).getB_app_name());
					bcode.add(b_appList.get(i).getB_app_code());
					bprice.add(b_appList.get(i).getB_price());
					
				}
				for(int i = 0; i<b_appList.size(); i ++) {
					session.setAttribute("bname", bname);
					session.setAttribute("bcode", bcode);
					session.setAttribute("bprice", bprice);
				}
				
				System.out.println("세션 bname : "+session.getAttribute("bname"));
				System.out.println("세션 bcode : "+session.getAttribute("bcode"));
				System.out.println("세션 bprice : "+session.getAttribute("bprice"));
				System.out.println("");
				
				for(int i = 0; i<b_appList.size(); i ++) {
					System.out.println("인덱스 : " +i +" 중복된 b_app_code : " + b_appList.get(i).getB_app_code());
					System.out.println("인덱스 : " +i + " b_app_code : " + b_appList.get(i).getB_app_code());
					System.out.println("인덱스 : " +i + " b_app_price : " + b_appList.get(i).getB_price());
					System.out.println("인덱스 : " +i + " b_app_amount : " + b_appList.get(i).getB_amount());
					System.out.println();
				}
				if(b_appList.size() != 0) {
					model.addAttribute("b_appList" , b_appList);
					pageNm = "insa/support/test/cart";
					System.out.println(b_appList.size());
					System.out.println("장바구니 추가 완료");
				}else if(b_appList.size() == 0){
					pageNm = "insa/support/test/cart";
					System.out.println(b_appList.size());
					System.out.println("b_app장바구니 품목이 없습니다.");
					System.out.println("line 370");
				}
			}
			
			
		return pageNm;
	}
	
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	
	public String basket(Locale locale, Model model ,HttpServletRequest req, HttpSession session) throws ClassNotFoundException  {
		logger.info("장바구니입니다..",locale);
		
		String pageNm ="";
		
		int insert = 0;
		serviceList svt = new serviceList();
		insert = svt.saveBasket(req,session);
		
		if(insert == 0) {
			System.out.println("저장실패");
		}else {
			System.out.println("성공적으로 저장되었습니다");
			pageNm = "insa/support/test/serviceMain";
		}
		return pageNm;
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	
	public String basketList(Locale locale, Model model ,HttpSession session) {
		logger.info("장바구니입니다..",locale);
		MemberDao md = new MemberDao();
		String pageNm="";
		md.service_point(session);
		ArrayList<BasketInfo> basketListBook = null;
		ArrayList<BasketInfo> basketListH = null;
		ArrayList<BasketInfo> basketListB = null;
		
		serviceList svt = new serviceList();
		basketListBook = svt.basketList_book(session);
		basketListH = svt.basketList_happ(session);
		basketListB = svt.basketList_bapp(session);
		
		if(basketListBook.size() == 0 && basketListH.size() == 0 && basketListB.size() == 0) {
			System.out.println("장바구니가 없습니다.");
			
		}else {
			model.addAttribute("happList",basketListH);
			model.addAttribute("bappList",basketListB);
			model.addAttribute("basketList", basketListBook);

			
		}
		pageNm = "insa/support/test/basket";
		return pageNm;
	}
	
@RequestMapping(value = "/pay", method = RequestMethod.GET)
	
	public String pay(Locale locale, Model model ,HttpServletRequest req)  {
		logger.info("장바구니입니다..",locale);
		
		String pageNm = "";
		int result = 0;
		serviceList svt = new serviceList();
		result = svt.payOk(req);
		if(result == 0 ) {
			System.out.println("결제에 실패하였습니다.");
		}else {
			System.out.println("결제에 성공하였습니다.");
			pageNm = "insa/support/test/serviceMain";
		}
		
		return pageNm;
	}

@RequestMapping(value = "/deleteMenu", method = RequestMethod.GET)

public String deleteMenu(Locale locale, Model model ,HttpServletRequest req)  {
	logger.info("장바구니입니다..",locale);
	
	String pageNm = "insa/support/test/serviceMain";
	int result = 0;
	serviceList svt = new serviceList();
	result = svt.deleteBasket(req);
	if(result == 0) {
		System.out.println("결제에 실패하였습니다.");
	}else {
		System.out.println("결제에 성공하였습니다.");
	}
	return pageNm;
	}
}
