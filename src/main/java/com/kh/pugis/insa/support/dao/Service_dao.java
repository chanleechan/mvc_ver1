package com.kh.pugis.insa.support.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.pugis.insa.support.domain.Book;
import com.kh.pugis.insa.support.domain.H_Appliance;
import com.kh.pugis.insa.support.domain.ServiceInfo;
import com.kh.pugis.insa.support.utils.JDBCTemplate;
import com.kh.pugis.insa.support.service.ServiceList;
import com.kh.pugis.insa.support.domain.B_Appliance;
import com.kh.pugis.insa.support.domain.BasketInfo;

public class Service_dao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	PreparedStatement pstmt3;
	

	
	public ArrayList<Book> addmenu_book() {
		//복지메뉴추가(도서)
		
		Book addBookList = null;
		ArrayList<Book> bookList = 
				new ArrayList<Book>();
		
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select book_code,book_name, book_price, book_amount from BOOK";
			
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				addBookList = new Book();
				
				addBookList.setBook_code(rs.getString("book_code"));
				addBookList.setBook_name(rs.getString("book_name"));
				addBookList.setBook_price(rs.getInt("book_price"));
				addBookList.setBook_amount(rs.getInt("book_amount"));
				bookList.add(addBookList);
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
				
				
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
			
		return bookList;
	}
	
	public ArrayList<H_Appliance> addmenu_H_appliances() {
		//복지메뉴추가(일반가전)
		
		H_Appliance appList = null;		
		ArrayList<H_Appliance> addHList = 
				new ArrayList<H_Appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select h_app_code,h_app_name, h_price, h_amount from h_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new H_Appliance();
						
				appList.setH_app_code(rs.getString("h_app_code"));
				appList.setH_app_name(rs.getString("h_app_name"));
				appList.setH_price(rs.getInt("h_price"));
				appList.setH_amount(rs.getInt("h_amount"));
				addHList.add(appList);
				
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
						
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
		return addHList;
	}
	
	public ArrayList<H_Appliance> add_basket_H_app(){
		H_Appliance appList = null;		
		ArrayList<H_Appliance> addHList = 
				new ArrayList<H_Appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select h_app_name from h_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new H_Appliance();
						
				appList.setH_app_name(rs.getString("h_app_name"));
				
				addHList.add(appList);
				
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
						
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
		return addHList;
	}

	public ArrayList<B_Appliance> addmenu_b_appliances() {
		//복지메뉴추가(업무가전)
		
		B_Appliance appList = null;		
		ArrayList<B_Appliance> addBList = 
				new ArrayList<B_Appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select b_app_code,b_app_name, b_price, b_amount from b_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new B_Appliance();
						
				appList.setB_app_code(rs.getString("b_app_code"));
				appList.setB_app_name(rs.getString("b_app_name"));
				appList.setB_price(rs.getInt("b_price"));
				appList.setB_amount(rs.getInt("b_amount"));
				addBList.add(appList);
				
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
						
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
		
		return addBList;
	}
	//결제

	public int pay(HttpServletRequest req) {
		int payOk = 0;
		ArrayList<String> ck_happArr = new ArrayList<String>();
		ArrayList<String> ck_happCode = new ArrayList<String>();
		
		ArrayList<String> ck_bappArr = new ArrayList<String>();
		ArrayList<String> ck_bappCode = new ArrayList<String>();
		
		ArrayList<String> ck_bookArr = new ArrayList<String>();
		ArrayList<String> ck_bookCode = new ArrayList<String>();
		
		String[] ck_bookStr = null;		
		ck_bookStr = req.getParameterValues("bookcheck");	
		String[] ck_bookC = null;
		ck_bookC = req.getParameterValues("book_code");
		
		String[] ck_happStr = null;
		ck_happStr = req.getParameterValues("h_appcheck");
		String[] ck_happC = null;
		ck_happC = req.getParameterValues("h_app_code");
		
		String[] ck_bappStr = null;
		ck_bappStr = req.getParameterValues("b_appcheck");
		String[] ck_bappC = null;
		ck_bappC = req.getParameterValues("b_app_code");
		
		String serviceSeq = service_seq();
		System.out.println(serviceSeq);
		String basketSeq = basket_seq();
		System.out.println(basketSeq);
		if(ck_happStr != null) {
			for(String temp:ck_happStr) {
				ck_happArr.add(temp);
			}
		}
		if(ck_happC != null) {
			for(String temp:ck_happC) {
				ck_happCode.add(temp);
			}
		}
		
		if(ck_bappStr != null) {
			for(String temp:ck_bappStr) {
				ck_bappArr.add(temp);
			}
		}
		if(ck_bappC != null) {
			for(String temp:ck_bappC) {
				ck_bappCode.add(temp);
			}
		}
		
		if(ck_bookStr != null) {
			for(String temp:ck_bookStr) {
				ck_bookArr.add(temp);
			}
		}
		if(ck_bookC != null) {
			for(String temp:ck_bookC) {
				ck_bookCode.add(temp);
			}
		}
		
		HttpSession session = req.getSession();
		String emp_code = (String)session.getAttribute("emp_code");
		
		
		try {
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");					
				String sql = "";
				String Service_menu_insert = "";
				String priceUpdate = "";
				String pointUpdate = "";
				
				if(ck_bookArr.size() != 0) {
					
					Service_menu_insert = "insert into service_menu(basket_seq,emp_code,book_code, pay_seq) "
							+ "select basket_seq, emp_code, book_code,? "
							+ "from basket_info "
							+ "where basket_seq = ?";
					 
					for(int i = 0 ; i<ck_bookArr.size(); i++) {						
						pstmt = conn.prepareStatement(Service_menu_insert);
						pstmt.setString(1, serviceSeq);
						pstmt.setString(2, ck_bookArr.get(i));
						
						pstmt.executeUpdate();
						conn.commit();
						
					}
					priceUpdate = "update service_menu "
							+ "set book_price = "
							+ "(select book_price from book "
							+ "where service_menu.book_code = book.book_code) "
							+ "where service_menu.basket_seq = ? ";
							
					
					for(int i = 0; i<ck_bookArr.size(); i++) {
						pstmt= conn.prepareStatement(priceUpdate);
						pstmt.setString(1, ck_bookArr.get(i));
						
						pstmt.executeUpdate();
						conn.commit();
					}
					
					for(int i = 0; i<ck_bookCode.size(); i++) {
					pointUpdate = "update first_join set f_service_point = "
							+ "(f_service_point -(select sum(book_price)as 전체가격 "
							+ "from service_menu "
							+ "where book_code = '"+ck_bookCode.get(i)+"' "
							+ "and emp_code ='"+emp_code+"' "
							+ "and pay_seq ='"+serviceSeq+"'))";

					pstmt.executeUpdate(pointUpdate);
					conn.commit();
					
					}
				}
				
				
				if(ck_happArr.size() != 0) {
					
					Service_menu_insert = "insert into service_menu(basket_seq,emp_code,h_app_code, pay_seq) "
							+ "select basket_seq, emp_code, h_app_code,? "
							+ "from basket_info "
							+ "where basket_seq = ?";
					
					for(int i = 0; i<ck_happArr.size(); i++) {
						pstmt2 = conn.prepareStatement(Service_menu_insert);
						pstmt2.setString(1, serviceSeq);
						
						pstmt2.setString(2, ck_happArr.get(i));
						
						pstmt2.executeUpdate();
						conn.commit();
					}
					priceUpdate = "update service_menu "
							+ "set h_price = "
							+ "(select h_price from h_appliance "
							+ "where service_menu.h_app_code = h_appliance.h_app_code) "
							+ "where service_menu.basket_seq = ? ";
							
					
					for(int i = 0; i<ck_happArr.size(); i++) {
						pstmt2 = conn.prepareStatement(priceUpdate);
						pstmt2.setString(1, ck_happArr.get(i));
						
						pstmt2.executeUpdate();
						conn.commit();
						
						
					}	
					
					for(int i = 0; i<ck_happCode.size(); i++) {
					pointUpdate = "update first_join set f_service_point = "
							+ "(f_service_point -(select sum(h_price)as 전체가격 "
							+ "from service_menu "
							+ "where h_app_code = '"+ck_happCode.get(i)+"' "
							+ "and emp_code ='"+emp_code+"' "
							+ "and pay_seq ='"+serviceSeq+"'))";

					pstmt2.executeUpdate(pointUpdate);
					conn.commit();
					
					}
				}
				
				if(ck_bappArr.size()!=0) {
					Service_menu_insert = "insert into service_menu(basket_seq,emp_code,b_app_code, pay_seq) "
							+ "select basket_seq, emp_code, b_app_code,? "
							+ "from basket_info "
							+ "where basket_seq = ?";
					
					for(int i = 0; i<ck_bappArr.size(); i++) {
						pstmt3 = conn.prepareStatement(Service_menu_insert);
						pstmt3.setString(1, serviceSeq);
						pstmt3.setString(2, ck_bappArr.get(i));
						
						pstmt3.executeUpdate();
						conn.commit();
					}
					
					priceUpdate = "update service_menu "
							+ "set b_price = "
							+ "(select b_price from b_appliance "
							+ "where service_menu.b_app_code = b_appliance.b_app_code) "
							+ "where service_menu.basket_seq = ? ";
							
					
					for(int i = 0; i<ck_bappArr.size(); i++) {
						pstmt3 = conn.prepareStatement(priceUpdate);
						pstmt3.setString(1, ck_bappArr.get(i));
						pstmt3.executeUpdate();
						
						conn.commit();
					}
					
					for(int i = 0; i<ck_bappCode.size(); i++) {
					pointUpdate = "update first_join set f_service_point = "
							+ "(f_service_point -(select sum(b_price)as 전체가격 "
							+ "from service_menu "
							+ "where b_app_code = '"+ck_bappCode.get(i)+"' "
							+ "and emp_code ='"+emp_code+"' "
							+ "and pay_seq ='"+serviceSeq+"'))";

					pstmt.executeUpdate(pointUpdate);
					conn.commit();
					}
				}
				
				if(ck_bookArr.size() != 0) {
					sql =  "update basket_info set book_code = null where basket_seq = ?";
					
					for(int i = 0; i<ck_bookArr.size(); i++) {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, ck_bookArr.get(i));
						pstmt.executeUpdate();
						conn.commit();
						pstmt.close();
						
					}
					payOk = 1;
					
				}
				if(ck_happArr.size() != 0) {
					sql =  "update basket_info set h_app_code = null where basket_seq = ?";
					
					for(int i = 0 ; i<ck_happArr.size(); i++) {
						pstmt2 = conn.prepareStatement(sql);
						pstmt2.setString(1, ck_happArr.get(i));
						pstmt2.executeUpdate();
						conn.commit();
						pstmt2.close();
					}
					payOk = 1;
					
				}
				
				if(ck_bappArr.size() != 0) {
					sql =  "update basket_info set b_app_code = null where basket_seq = ?";
					
					for(int i = 0 ; i<ck_bappArr.size(); i++) {
						pstmt3 = conn.prepareStatement(sql);
						pstmt3.setString(1, ck_bappArr.get(i));
						pstmt3.executeUpdate();
						conn.commit();
						
					}
					
					
					payOk = 1;
				}
				sql = "delete from basket_info "
						+ "where book_code  is null "
						+ "and h_app_code is null "
						+ "and b_app_code is null";
				pstmt3=conn.prepareStatement(sql);
				conn.commit();
				pstmt3.close();
				conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return payOk;
	}
	
	
	public int point_basket(HttpServletRequest req, HttpSession session){		
		int insert = 0;
		int result = 0;
		String emp_id = (String)session.getAttribute("emp_id");
		System.out.println("emp_code" +emp_id);
		
		
	try{
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		
		stmt = conn.createStatement();
		String emp_code = emp_id;
		
		String[] book_code = req.getParameterValues("book_code");
		String[] b_app_code = req.getParameterValues("b_app_code");
		String[] h_app_code = req.getParameterValues("h_app_code");
		
		ArrayList<String> book_codeStr = new ArrayList<>();
		ArrayList<String> h_app_codeStr = new ArrayList<>();
		ArrayList<String> b_app_codeStr = new ArrayList<>();
		
		if(book_code != null) {
			for(String temp:book_code) {
				book_codeStr.add(temp);
			}
		}
		if(h_app_code != null) {
			for(String temp:h_app_code) {
				h_app_codeStr.add(temp);
			}
		}
		if(b_app_code !=null) {
			for(String temp:b_app_code) {
				b_app_codeStr.add(temp);
			}
		}			
		if(book_codeStr.size() == 0) {
			book_codeStr = new ArrayList<String>();
			book_codeStr.add(null);
		}
		if(b_app_codeStr.size()==0) {
			b_app_codeStr = new ArrayList<String>();
			book_codeStr.add(null);
		}
		if(h_app_codeStr.size() == 0) {
			h_app_codeStr = new ArrayList<String>();
			h_app_codeStr.add(null);
		}
		
		if(book_codeStr.size() < b_app_codeStr.size()) {
			for(int i = 0; i<b_app_codeStr.size(); i++) {
				if(book_codeStr.size() == b_app_codeStr.size()) {
					break;
				}else {
					book_codeStr.add(null);
				}
			}
		}
		
		if(book_codeStr.size() < h_app_codeStr.size()) {
			for(int i = 0; i<h_app_codeStr.size(); i++) {
				if(book_codeStr.size() == h_app_codeStr.size()) {
					break;
				}else {
					book_codeStr.add(null);
				}
			}
		}
		
		if(b_app_codeStr.size() < book_codeStr.size()) {
			for(int i = 0; i<book_codeStr.size(); i++) {
				if(book_codeStr.size() == b_app_codeStr.size()) {
					break;
				}else {
					b_app_codeStr.add(null);
				}
			}
		}
		if(b_app_codeStr.size() < h_app_codeStr.size()) {
			for(int i = 0; i<h_app_codeStr.size(); i++) {
				if(book_codeStr.size() == h_app_codeStr.size()) {
					break;
				}else {
					b_app_codeStr.add(null);
				}
			}
		}
		
		if(h_app_codeStr.size() < book_codeStr.size()) {
			for(int i = 0; i<book_codeStr.size(); i++) {
				if(book_codeStr.size() == h_app_codeStr.size()) {
					break;
				}else {
					h_app_codeStr.add(null);
				}
			}
		}
		
		if(h_app_codeStr.size() < b_app_codeStr.size()) {
			for(int i = 0; i<b_app_codeStr.size(); i++) {
				if(b_app_codeStr.size() == h_app_codeStr.size()) {
					break;
				}else {
					h_app_codeStr.add(null);
				}
			}
		}
		
		ArrayList<String> routine = new ArrayList<String>();

		
		if(routine.size() < h_app_codeStr.size()) {
			for(int i = 0 ; i<h_app_codeStr.size(); i++) {
				if(h_app_codeStr.size() == routine.size()) {
					break;
				}else {
					routine.add(null);
				}
			}
		}
		
		String sql = "INSERT INTO BASKET_INFO(BASKET_SEQ, EMP_CODE,BOOK_CODE, B_APP_CODE, H_APP_CODE) "
				+ " VALUES(?,?,?,?,?)";
		for(int i = 0; i <routine.size(); i++ ) {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basket_seq());
			pstmt.setString(2, emp_code);
			pstmt.setString(3, book_codeStr.get(i));
			pstmt.setString(4, b_app_codeStr.get(i));
			pstmt.setString(5, h_app_codeStr.get(i));
			result = pstmt.executeUpdate();
			conn.commit();
		}
		
		System.out.println("장바구니 담기 성공");
		System.out.println(result);
		insert = 1;
		stmt.close();
		conn.close();
			
			
		} catch(SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
			insert = 0;
		}
		return insert;
	
		
	}
	

	//최종 장바구니 추가 book
	public ArrayList<BasketInfo> basket_menu_book(HttpSession session) {
		//장바구니
		BasketInfo basket = null;
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		//ArrayList<book> bookList = new ArrayList<book>();
 
		String emp_code = (String)session.getAttribute("emp_id");
	try{
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		
		stmt = conn.createStatement();
		
		String sql = "select distinct basket.basket_seq,basket.emp_code, basket.book_code,b.book_name ,b.book_amount,b.book_price from basket_info basket ,book b "
				+ "where basket.book_code = b.book_code and basket.emp_code='"+emp_code+"' order by to_number(basket.basket_seq)"  ;

		rs =stmt.executeQuery(sql);
		while(rs.next()) {
			Book b = new Book();
			b.setBook_code(rs.getString("book_code"));
			b.setBook_name(rs.getString("book_name"));
			b.setBook_amount(rs.getInt("book_amount"));
			b.setBook_price(rs.getInt("book_price"));
			
			
			basket = new BasketInfo();
			basket.setBasket_seq(rs.getString("basket_seq"));
			basket.setEmp_code(rs.getString("emp_code"));
			basket.setBook_code(rs.getString("book_code"));
			basket.setBook(b);
			basketList.add(basket);
		}
		conn.commit();
		rs.close();
		stmt.close();
		conn.close();
			
			
		} catch(SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		return basketList;
	}
	//최종 장바구니 추가 happ
	public ArrayList<BasketInfo> basket_menu_happ(HttpSession session) {
		//장바구니
		BasketInfo basket = null;
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		//ArrayList<book> bookList = new ArrayList<book>();
 
		String emp_code = (String)session.getAttribute("emp_id");
	try{
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		
		stmt = conn.createStatement();
		
		String sql = "select distinct basket.basket_seq,basket.emp_code, basket.h_app_code,h.h_app_name ,h.h_amount,h.h_price from basket_info basket ,h_appliance h "
				+ "where basket.h_app_code = h.h_app_code and basket.emp_code='"+emp_code+"' order by to_number(basket.basket_seq)"  ;

		rs =stmt.executeQuery(sql);
		while(rs.next()) {
			H_Appliance h = new H_Appliance();
			h.setH_app_code(rs.getString("h_app_code"));
			h.setH_app_name(rs.getString("h_app_name"));
			h.setH_amount(rs.getInt("h_amount"));
			h.setH_price(rs.getInt("h_price"));
			
			
			basket = new BasketInfo();
			basket.setBasket_seq(rs.getString("basket_seq"));
			basket.setEmp_code(rs.getString("emp_code"));
			basket.setH_app_code(rs.getString("h_app_code"));
			basket.setH_appliance(h);
			basketList.add(basket);
		}
		conn.commit();
		rs.close();
		stmt.close();
		conn.close();
			
			
		} catch(SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		return basketList;
	}
	//최종 장바구니 추가 bapp
	public ArrayList<BasketInfo> basket_menu_bapp(HttpSession session) {
		//장바구니
		BasketInfo basket = null;
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
 
		String emp_code = (String)session.getAttribute("emp_id");
	try{
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		
		stmt = conn.createStatement();
		
		String sql = "select distinct basket.basket_seq,basket.emp_code, basket.b_app_code ,b.b_app_name,b.b_amount, b.b_price from basket_info basket ,b_appliance b "
				+ "where basket.b_app_code = b.b_app_code and basket.emp_code='"+emp_code+"' order by to_number(basket.basket_seq)"  ;

		rs =stmt.executeQuery(sql);
		while(rs.next()) {
			B_Appliance b = new B_Appliance();
			b.setB_app_code(rs.getString("b_app_code"));
			b.setB_app_name(rs.getString("b_app_name"));
			b.setB_amount(rs.getInt("b_amount"));
			b.setB_price(rs.getInt("b_price"));
			
			
			basket = new BasketInfo();
			basket.setBasket_seq(rs.getString("basket_seq"));
			basket.setEmp_code(rs.getString("emp_code"));
			basket.setB_app_code(rs.getString("b_app_code"));
			basket.setB_appliance(b);
			basketList.add(basket);
		}
		conn.commit();
		rs.close();
		stmt.close();
		conn.close();
			
			
		} catch(SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		return basketList;
	}
	
	public String basket_seq() {
		
		ArrayList<String> maxseq = new ArrayList<String>();
		ServiceList svl = new ServiceList();
		maxseq = svl.bSeqmax();
		if(maxseq.get(0) == null) {
			maxseq.add("0");
		}
		int lastIndex = maxseq.size()-1;
//		int lastIndex = maxseq.size();
		
		String num = maxseq.get(lastIndex);
		
		int maxSeqInt = Integer.valueOf(num)+1;
		
		String seq = maxSeqInt+"";
		if(maxSeqInt == 0) {
			maxSeqInt = 1;
		}
		
		return seq;
	}
	public String service_seq() {
		
		ArrayList<String> maxseq = new ArrayList<String>();
		ServiceList svl = new ServiceList();
		maxseq = svl.sSeqmax();
		if(maxseq.get(0) == null) {
			maxseq.add("0");
		}
//		int lastIndex = maxseq.size();
		int lastIndex = maxseq.size()-1;
		
		String num = maxseq.get(lastIndex);
		
		int maxSeqInt = Integer.valueOf(num)+1;
		
		
		if(maxSeqInt == 0) {
			maxSeqInt = 1;
		}
		String seq = maxSeqInt+"";
		return seq;
	}
	//basket_info 테이블 시퀀스
	public ArrayList<String> maxseq(){
		BasketInfo basket = null;
		ArrayList<BasketInfo> basketList = 
				new ArrayList<BasketInfo>();
		ArrayList<String> maxseq = new ArrayList<String>();
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select max(to_number(basket_seq)) from basket_info";
			
			rs =stmt.executeQuery(sql);
			if(rs.next()) {
				basket = new BasketInfo();
				basket.setBasket_seq(rs.getString("max(to_number(basket_seq))"));
				basketList.add(basket);
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			
			for(int i = 0; i<basketList.size(); i++) {
				maxseq.add(basketList.get(i).getBasket_seq());
				System.out.println("basket_seq : "+maxseq);
			}
			
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
			return maxseq;
	}
	//service_menu 테이블 시퀀스
	public ArrayList<String> maxseq_s(){
		ServiceInfo basket = null;
		ArrayList<ServiceInfo> service_info = 
				new ArrayList<ServiceInfo>();
		ArrayList<String> maxseq_s = new ArrayList<String>();
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select max(to_number(pay_seq)) from service_menu";
			
			rs =stmt.executeQuery(sql);
			if(rs.next()) {
				basket = new ServiceInfo();
				basket.setPay_seq(rs.getString("max(to_number(pay_seq))"));
				service_info.add(basket);
			}
			conn.commit();
			rs.close();
			stmt.close();
			conn.close();
			
			for(int i = 0; i<service_info.size(); i++) {
				maxseq_s.add(service_info.get(i).getPay_seq());
				System.out.println("service_seq : "+maxseq_s);
			}
			
			} catch(SQLException e) {
				System.out.println("DB연결 실패");
				e.printStackTrace();
			}
			return maxseq_s;
	}
	
	public int basket_delete(HttpServletRequest req){
		int result = 0;
		
		ArrayList<String> ck_happArr = new ArrayList<String>();
		ArrayList<String> ck_bappArr = new ArrayList<String>();
		ArrayList<String> ck_bookArr = new ArrayList<String>();
		
		String[] ck_bookStr = null;		
		ck_bookStr = req.getParameterValues("bookcheck");	
		
		String[] ck_happStr = null;
		ck_happStr = req.getParameterValues("h_appcheck");
		
		String[] ck_bappStr = null;
		ck_bappStr = req.getParameterValues("b_appcheck");
		
		String serviceSeq = service_seq();
		System.out.println(serviceSeq);
		String basketSeq = basket_seq();
		System.out.println(basketSeq);
		if(ck_happStr != null) {
			for(String temp:ck_happStr) {
				ck_happArr.add(temp);
			}
		}
		
		if(ck_bappStr != null) {
			for(String temp:ck_bappStr) {
				ck_bappArr.add(temp);
			}
		}
		
		if(ck_bookStr != null) {
			for(String temp:ck_bookStr) {
				ck_bookArr.add(temp);
			}
		}

		HttpSession session = req.getSession();
		String emp_code = (String)session.getAttribute("emp_id");
		try {
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");					
				String sql = "";

				
				if(ck_bookArr.size() != 0) {
					sql =  "update basket_info set book_code = null "
							+ "where basket_seq = ? "
							+ "and emp_code = ?";
					
					for(int i = 0; i<ck_bookArr.size(); i++) {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, ck_bookArr.get(i));
						pstmt.setString(2, emp_code);
						pstmt.executeUpdate();
						
					}
					result = 1;
					conn.commit();
					pstmt.close();
				}
				if(ck_happArr.size() != 0) {
					sql =  "update basket_info set h_app_code = null "
							+ "where basket_seq = ? "
							+ "and emp_code = ?";
					
					for(int i = 0 ; i<ck_happArr.size(); i++) {
						pstmt2 = conn.prepareStatement(sql);
						pstmt2.setString(1, ck_happArr.get(i));
						pstmt2.setString(2, emp_code);
						pstmt2.executeUpdate();
						conn.commit();
						
					}
					result = 1;
					pstmt2.close();
				}
				
				if(ck_bappArr.size() != 0) {
					sql =  "update basket_info set b_app_code = null "
							+ "where basket_seq = ? "
							+ "and emp_code = ?";
					
					for(int i = 0 ; i<ck_bappArr.size(); i++) {
						pstmt3 = conn.prepareStatement(sql);
						pstmt3.setString(1, ck_bappArr.get(i));
						pstmt3.setString(2, emp_code);
						pstmt3.executeUpdate();
						conn.commit();
						pstmt3.close();
					}
					
					result = 1;
				}
				
//				sql = "delete from basket_info "
//						+ "where book_code  is null "
//						+ "and h_app_code is null "
//						+ "and b_app_code is null";
//				pstmt3=conn.prepareStatement(sql);
//				pstmt3.executeUpdate();
//				conn.commit();
				
//				pstmt3.close();
				conn.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return result;
	}
	
		
}
