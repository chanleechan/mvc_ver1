package com.kh.pugis.insa.support.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.kh.pugis.insa.support.domain.Member;
import com.kh.pugis.insa.support.domain.B_Appliance;
import com.kh.pugis.insa.support.domain.BasketInfo;
import com.kh.pugis.insa.support.domain.Book;
import com.kh.pugis.insa.support.domain.H_Appliance;
import com.kh.pugis.insa.support.dao.Service_dao;
//import com.kh.pugis.insa.support.dao.MemberDao;



public class ServiceList {
	

	public ServiceList() {}	
	
	public int saveBasket(HttpServletRequest req, HttpSession session ) throws ClassNotFoundException {
		int insert = 0;
		insert = new Service_dao().point_basket(req,session);
		return insert;
	}
	
	public ArrayList<Book> BookSearch(){
		ArrayList<Book> bookList = 
				new ArrayList<Book>();
		bookList = new Service_dao().addmenu_book();
		
		return bookList;		
	}
	
	public ArrayList<H_Appliance> h_appSearch(){
		ArrayList<H_Appliance> appList = 
				new ArrayList<H_Appliance>();
		appList = new Service_dao().addmenu_H_appliances();
		
		return appList;
	}

	//업무가전 select
	public ArrayList<B_Appliance> b_appSearch() {
		ArrayList<B_Appliance> appList = 
				new ArrayList<B_Appliance>();
		appList = new Service_dao().addmenu_b_appliances();
		
		return appList;
	}
	
	//장바구니 아이디별로
	public ArrayList<BasketInfo> basketList_book(HttpSession session){
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		basketList = new Service_dao().basket_menu_book(session);
		
		return basketList;
	}
	public ArrayList<BasketInfo> basketList_happ(HttpSession session){
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		basketList = new Service_dao().basket_menu_happ(session);
		
		return basketList;
	}
	public ArrayList<BasketInfo> basketList_bapp(HttpSession session){
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		basketList = new Service_dao().basket_menu_bapp(session);
		
		return basketList;
	}
	
	public ArrayList<H_Appliance> basket_h_appSearch(){
		ArrayList<H_Appliance> appList = 
				new ArrayList<H_Appliance>();
		appList = new Service_dao().add_basket_H_app();
		
		return appList;
	}
	
	//basket_info 시퀀스 자동 증가
	public ArrayList<String> bSeqmax() {
		ArrayList<String> bSeqMax = 
				new ArrayList<String>();	
		bSeqMax = new Service_dao().maxseq();
		return bSeqMax;
	}
	
	public ArrayList<String> sSeqmax(){
		ArrayList<String> sSeqMax = 
				new ArrayList<String>();
		sSeqMax = new Service_dao().maxseq_s();
		return sSeqMax;
	}
	//결제 관련
	public int payOk(HttpServletRequest req) {
		int payOk= 0;
		Service_dao sdt = new Service_dao();
		payOk = sdt.pay(req);
		
		return payOk;
	}
	public int deleteBasket(HttpServletRequest req) {
		int delOk = 0;
		Service_dao sdt = new Service_dao();
		delOk = sdt.basket_delete(req);
		return delOk;
	}
	
}
