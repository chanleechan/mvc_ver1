package com.kh.pugis.insa.support.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.kh.pugis.insa.support.domain.Member;
import com.kh.pugis.insa.support.domain.b_appliance;
import com.kh.pugis.insa.support.domain.basketInfo;
import com.kh.pugis.insa.support.domain.book;
import com.kh.pugis.insa.support.domain.h_appliance;
import com.kh.pugis.insa.support.dao.service_dao;
//import com.kh.pugis.insa.support.dao.MemberDao;



public class serviceList {
	

	public serviceList() {}
	
//	public ArrayList<basketInfo> basketSearch() throws ClassNotFoundException{
//		ArrayList<basketInfo> basketList = 
//				new ArrayList<basketInfo>();	
//		basketList = new service_dao().point_basket(req);
//		return basketList;
//	}
	
	
	public int saveBasket(HttpServletRequest req, HttpSession session ) throws ClassNotFoundException {
		int insert = 0;
		insert = new service_dao().point_basket(req,session);
		return insert;
	}
	
	public ArrayList<book> BookSearch(){
		ArrayList<book> bookList = 
				new ArrayList<book>();
		bookList = new service_dao().addmenu_book();
		
		return bookList;		
	}
	
	public ArrayList<h_appliance> h_appSearch(){
		ArrayList<h_appliance> appList = 
				new ArrayList<h_appliance>();
		appList = new service_dao().addmenu_H_appliances();
		
		return appList;
	}

	//업무가전 select
	public ArrayList<b_appliance> b_appSearch() {
		ArrayList<b_appliance> appList = 
				new ArrayList<b_appliance>();
		appList = new service_dao().addmenu_b_appliances();
		
		return appList;
	}
	
	//장바구니 아이디별로
	public ArrayList<basketInfo> basketList_book(HttpSession session){
		ArrayList<basketInfo> basketList = 
				new ArrayList<basketInfo>();
		basketList = new service_dao().basket_menu_book(session);
		
		return basketList;
	}
	public ArrayList<basketInfo> basketList_happ(HttpSession session){
		ArrayList<basketInfo> basketList = 
				new ArrayList<basketInfo>();
		basketList = new service_dao().basket_menu_happ(session);
		
		return basketList;
	}
	public ArrayList<basketInfo> basketList_bapp(HttpSession session){
		ArrayList<basketInfo> basketList = 
				new ArrayList<basketInfo>();
		basketList = new service_dao().basket_menu_bapp(session);
		
		return basketList;
	}
	
	//회원가입
//	public ArrayList<Member> insertMember(){
//		ArrayList<Member> memberList = 
//				new ArrayList<Member>();
//		memberList = new MemberDao().inserMember();
//		
//		return memberList;
//	}
	
	public ArrayList<h_appliance> basket_h_appSearch(){
		ArrayList<h_appliance> appList = 
				new ArrayList<h_appliance>();
		appList = new service_dao().add_basket_H_app();
		
		return appList;
	}
	
	//basket_info 시퀀스 자동 증가
	public ArrayList<String> bSeqmax() {
		ArrayList<String> bSeqMax = 
				new ArrayList<String>();	
		bSeqMax = new service_dao().maxseq();
		return bSeqMax;
	}
	
	public ArrayList<String> sSeqmax(){
		ArrayList<String> sSeqMax = 
				new ArrayList<String>();
		sSeqMax = new service_dao().maxseq_s();
		return sSeqMax;
	}
	//결제 관련
	public int payOk(HttpServletRequest req) {
		int payOk= 0;
		service_dao sdt = new service_dao();
		payOk = sdt.pay(req);
		
		return payOk;
	}
	public int deleteBasket(HttpServletRequest req) {
		int delOk = 0;
		service_dao sdt = new service_dao();
		delOk = sdt.basket_delete(req);
		return delOk;
	}
	
}
