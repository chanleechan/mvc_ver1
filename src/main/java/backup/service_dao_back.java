package backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.pugis.insa.support.domain.book;
import com.kh.pugis.insa.support.domain.h_appliance;
import com.kh.pugis.insa.support.domain.serviceInfo;
import com.kh.pugis.insa.support.utils.JDBCTemplate;
import com.kh.pugis.insa.support.domain.b_appliance;
import com.kh.pugis.insa.support.domain.basketInfo;

public class service_dao_back {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	

	public ArrayList<book> addmenu_book() {
		//복지메뉴추가(도서)
		
		book addBookList = null;
		ArrayList<book> bookList = 
				new ArrayList<book>();
		
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select book_code,book_name, book_price, book_amount from BOOK";
			
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				addBookList = new book();
				
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
	
	public ArrayList<h_appliance> addmenu_H_appliances() {
		//복지메뉴추가(일반가전)
		
		h_appliance appList = null;		
		ArrayList<h_appliance> addHList = 
				new ArrayList<h_appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select h_app_code,h_app_name, h_price, h_amount from h_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new h_appliance();
						
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
	
	public ArrayList<h_appliance> add_basket_H_app(){
		h_appliance appList = null;		
		ArrayList<h_appliance> addHList = 
				new ArrayList<h_appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select h_app_name from h_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new h_appliance();
						
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

	public ArrayList<b_appliance> addmenu_b_appliances() {
		//복지메뉴추가(업무가전)
		
		b_appliance appList = null;		
		ArrayList<b_appliance> addBList = 
				new ArrayList<b_appliance>();
				
		try{
			conn = JDBCTemplate.getConnection();
			System.out.println("DB연결 성공");
					
			stmt = conn.createStatement();
					
			String sql = "select b_app_code,b_app_name, b_price, b_amount from b_appliance";
					
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				appList = new b_appliance();
						
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
	
	public ArrayList<serviceInfo> point_pay() {
		//복지 메뉴 사용
		
		ArrayList<serviceInfo> service_List = new ArrayList<serviceInfo>();
		
		return service_List;
	}
	


	
	public ArrayList<basketInfo> point_basket2() {
		//장바구니
		basketInfo basket = null;
		ArrayList<basketInfo> basketList = 
				new ArrayList<basketInfo>();
				
		
	try{
		conn = JDBCTemplate.getConnection();
		System.out.println("DB연결 성공");
		
		stmt = conn.createStatement();
		
		String sql = "select basket_seq,emp_code, book_code, book_amount, b_app_code, b_app_amount, h_app_code , h_app_amount from basket_info";
		
		rs =stmt.executeQuery(sql);
		while(rs.next()) {
			basket = new basketInfo();
			basket.setBasket_seq(rs.getString("basket_seq"));
			basket.setEmp_code(rs.getString("emp_code"));
			basket.setH_app_amount(rs.getInt("h_app_amount"));
			basket.setBook_code(rs.getString("book_code"));
			basket.setB_app_code(rs.getString("b_app_code"));
			basket.setH_app_code(rs.getString("h_app_code"));
			basket.setBook_amount(rs.getInt("book_amount"));
			basket.setB_app_amount(rs.getInt("b_app_amount"));
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
	public ArrayList<serviceInfo> basket_delete(){
		
		ArrayList<serviceInfo> deleteList = new ArrayList<serviceInfo>();
		
		return deleteList;
	}
		
}
