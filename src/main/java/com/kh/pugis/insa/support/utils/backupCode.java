//package com.kh.pugis.insa.support.utils;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.ui.Model;
//
//import com.kh.pugis.insa.support.domain.b_appliance;
//import com.kh.pugis.insa.support.domain.book;
//import com.kh.pugis.insa.support.domain.h_appliance;
//import com.kh.pugis.insa.support.service.serviceList;
//
//public class backupCode {
//	
//	private HttpServletRequest req;
//	private Model model;
//	
//	public String h_appMenu() {
//		String[] h_app_name = req.getParameterValues("h_appcheck");
//		
//		HttpSession session = req.getSession();
//		ArrayList<h_appliance> h_app_List = null;
//		
//		serviceList service_H_appList = new serviceList();
//		h_app_List = service_H_appList.h_appSearch();
//		ArrayList<h_appliance> n_appList = new ArrayList<h_appliance>();
//		ArrayList<String> arrayList_H = new ArrayList<>();
//		String maxLangth = "max";
//		
//		
//		if(h_app_name != null) {
//			for(String temp:h_app_name) {
//				arrayList_H.add(temp);
//			}
//		}
//		String pageNm = "";
//		
//		if(h_app_List.size() > 0) {
//			System.out.println("일반 가전입니다.");
//			for(int i = 0 ; i < arrayList_H.size(); i ++) {
//				session.setAttribute("h_appcheck", arrayList_H);
//				System.out.println("현재 장바구니 세션 : " + arrayList_H.get(i));
//			}
//			//장바구니 리스트와 비교하는 품목 리스트 길이 비교
//			//길이가 장바구니가 짧으면 추가해줌
//			if(arrayList_H.size() < h_app_List.size()) {
//				for(int i = 0; i < h_app_List.size(); i ++) {
//					if(arrayList_H.size() == h_app_List.size()) {
//						break;
//					}else {
//						arrayList_H.add(maxLangth);
//					}
//				}
//			}
//			
//				System.out.println("arrayList_H 사이즈 : " + arrayList_H.size());
//				System.out.println("h_app_nameList 사이즈 : " + h_app_List.size());
//			
//				
//			//중복 체크하여 n_appList에 넣어줌
//			
//			
//			int idx = 0;
//			for(int i = 0; i < h_app_List.size(); i ++) {
//				for(int j = 0; j <arrayList_H.size(); j ++) {
//					if(h_app_List.get(i).getH_app_name().equals(arrayList_H.get(j))){
//						n_appList.add(idx,h_app_List.get(i));
//						idx++;
//						break;
//					}
//				}
//			}
//			
//			System.out.println("n_appList 사이즈 : "+ n_appList);
//			
//			for(int i = 0; i<n_appList.size(); i ++) {
//				System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + n_appList.get(i).getH_app_name());
//				System.out.println("인덱스 : " +i + " h_app_code : " + n_appList.get(i).getH_app_code());
//				System.out.println("인덱스 : " +i + " h_app_price : " + n_appList.get(i).getH_price());
//				System.out.println("인덱스 : " +i + " h_app_amount : " + n_appList.get(i).getH_amount());
//				System.out.println();
//			}
//			if(n_appList.size() != 0) {
//				model.addAttribute("searchResultList" , n_appList);
//				pageNm = "insa/support/pointMenu/cart2";
//				System.out.println(n_appList.size());
//				System.out.println("장바구니 추가 완료");
//			}else if(n_appList.size() == 0){
//				pageNm = "insa/support/pointMenu/cart2";
//				System.out.println(n_appList.size());
//				System.out.println("h_app장바구니 품목이 없습니다.");
//			}
//		}
//		
//		return pageNm;
//		
//	}
//	
//	public String BookMenu() {
//		String pageNm = "";
//		String[] book_name = req.getParameterValues("bookcheck");
//		HttpSession session = req.getSession();
//		ArrayList<book> book_List = null;
//		
//		String maxLangth = "max";
//		serviceList service_BookList = new serviceList();
//		book_List = service_BookList.BookSearch();
//		
//		ArrayList<book> b_List = new ArrayList<book>();
//		ArrayList<String> arrayList_Book = new ArrayList<>();
//		
//		if(book_name !=null) {
//			for(String temp:book_name) {
//				arrayList_Book.add(temp);
//			}
//		}
//		
//		if(book_List.size() > 0) {
//			System.out.println("도서입니다.");
//				for(int i = 0 ; i < arrayList_Book.size(); i ++) {
//					session.setAttribute("bookcheck", arrayList_Book);
//					System.out.println("현재 장바구니 세션 : " + arrayList_Book.get(i));
//				}
//				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
//				//길이가 장바구니가 짧으면 추가해줌
//				if(arrayList_Book.size() < book_List.size()) {
//					for(int i = 0; i < book_List.size(); i ++) {
//						if(arrayList_Book.size() == book_List.size()) {
//							break;
//						}else {
//							arrayList_Book.add(maxLangth);
//						}
//					}
//				}
//				
//				System.out.println("arrayList_Book 사이즈 : " + arrayList_Book.size());
//				System.out.println("book_List 사이즈 : " + arrayList_Book.size());
//				int idx = 0;
//				for(int i = 0; i < book_List.size(); i ++) {
//					for(int j = 0; j <arrayList_Book.size(); j ++) {
//						if(book_List.get(i).getBook_name().equals(arrayList_Book.get(j))){
//							b_List.add(idx,book_List.get(i));
//							idx++;
//							break;
//						}
//					}
//				}
//				
//				System.out.println("b_list 사이즈 : "+b_List.size());
//				
//				for(int i = 0; i<b_List.size(); i ++) {
//					System.out.println("인덱스 : " +i +" 중복된 Book_name : " + b_List.get(i).getBook_name());
//					System.out.println("인덱스 : " +i + " Book_code : " + b_List.get(i).getBook_code());
//					System.out.println("인덱스 : " +i + " Book_price : " + b_List.get(i).getBook_price());
//					System.out.println("인덱스 : " +i + " Book_amount : " + b_List.get(i).getBook_amount());
//					System.out.println();
//				}
//				if(b_List.size() != 0) {
//					model.addAttribute("searchResultList3" , b_List);
//					pageNm = "insa/support/pointMenu/cart2";
//					System.out.println(b_List.size());
//					System.out.println("장바구니 추가 완료");
//				}else if(b_List.size() == 0){
//					pageNm = "insa/support/pointMenu/cart2";
//					System.out.println(b_List.size());
//					System.out.println("book장바구니 품목이 없습니다.");
//				}
//			}
//		
//		
//		return pageNm;
//	}
//
//	public String b_appMenu() {
//		String pageNm = "";
//		String[] b_app_name = req.getParameterValues("b_appcheck");
//		HttpSession session = req.getSession();
//		ArrayList<b_appliance> b_app_List = null;
//		String maxLangth = "max";
//		
//		serviceList service_b_appList = new serviceList();
//		b_app_List = service_b_appList.b_appSearch();
//		
//		ArrayList<b_appliance> b_appList = new ArrayList<b_appliance>();
//		ArrayList<String> arrayList_B = new ArrayList<>();
//		
//		 if(b_app_name != null) {
//				for(String temp:b_app_name) {
//					arrayList_B.add(temp);
//				}
//			}
//		 
//		 if(b_app_List.size() > 0) {
//				System.out.println("일반 가전입니다.");
//				for(int i = 0 ; i < arrayList_B.size(); i ++) {
//					session.setAttribute("b_appcheck", arrayList_B);
//					System.out.println("현재 장바구니 세션 : " + arrayList_B.get(i));
//				}
//				//장바구니 리스트와 비교하는 품목 리스트 길이 비교
//				//길이가 장바구니가 짧으면 추가해줌
//				if(arrayList_B.size() < b_app_List.size()) {
//					for(int i = 0; i < b_app_List.size(); i ++) {
//						if(arrayList_B.size() == b_app_List.size()) {
//							break;
//						}else {
//							arrayList_B.add(maxLangth);
//						}
//					}
//				}
//				
//					System.out.println("arrayList_B 사이즈 : " + arrayList_B.size());
//					System.out.println("b_app_nameList 사이즈 : " + b_app_List.size());
//				
//					
//				//중복 체크하여 n_appList에 넣어줌
//				
//				
//				int idx = 0;
//				for(int i = 0; i < b_app_List.size(); i ++) {
//					for(int j = 0; j <arrayList_B.size(); j ++) {
//						if(b_app_List.get(i).getB_app_name().equals(arrayList_B.get(j))){
//							b_appList.add(idx,b_app_List.get(i));
//							idx++;
//							break;
//						}
//					}
//				}
//				
//				System.out.println("b_appList 사이즈 : "+ b_appList);
//				
//				for(int i = 0; i<b_appList.size(); i ++) {
//					System.out.println("인덱스 : " +i +" 중복된 h_app_name : " + b_appList.get(i).getB_app_name());
//					System.out.println("인덱스 : " +i + " h_app_code : " + b_appList.get(i).getB_app_code());
//					System.out.println("인덱스 : " +i + " h_app_price : " + b_appList.get(i).getB_price());
//					System.out.println("인덱스 : " +i + " h_app_amount : " + b_appList.get(i).getB_amount());
//					System.out.println();
//				}
//				if(b_appList.size() != 0) {
//					model.addAttribute("searchResultList2" , b_appList);
//					pageNm = "insa/support/pointMenu/cart2";
//					System.out.println(b_appList.size());
//					System.out.println("장바구니 추가 완료");
//				}else if(b_appList.size() == 0){
//					pageNm = "insa/support/pointMenu/cart2";
//					System.out.println(b_appList.size());
//					System.out.println("b_app장바구니 품목이 없습니다.");
//				}
//			}
//		
//		return pageNm;
//		
//		
//	}
//}

//service_dao_test. pay()
//				if(ck_bookArr.size() != 0 && ck_happArr.size() == 0 && ck_bappArr.size() == 0) {
//					
//					String sql = "update basket_info set book_code = null where basket_seq = ?";
//					String insert = "insert into service_menu(basket_seq,emp_code,book_code, pay_seq) "
//							+ "select basket_seq, emp_code, book_code,? "
//							+ "from basket_info "
//							+ "where basket_seq = ?";
//	
//					for(int i = 0 ; i<ck_bookArr.size(); i++) {						
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					for(int i = 0; i<ck_bookArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//				}
//				
//				if(ck_bookArr.size() != 0 && ck_happArr.size() != 0 && ck_bappArr.size() == 0) {
//					
//					String sql = "update basket_info set book_code = null where basket_seq = ?";
//					String insert = "insert into service_menu(basket_seq,emp_code,book_code, pay_seq) "
//							+ "select basket_seq, emp_code, book_code,? "
//							+ "from basket_info "
//							+ "where basket_seq = ?";
//	
//					for(int i = 0 ; i<ck_bookArr.size(); i++) {						
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					
//					for(int i = 0; i<ck_happArr.size(); i++) {
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_happArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					
//					for(int i = 0; i<ck_bookArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					for(int i = 0 ; i<ck_happArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_happArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//				}
//				
//				if(ck_bookArr.size() != 0 && ck_happArr.size() == 0 && ck_bappArr.size() != 0) {
//					
//					String sql = "update basket_info set book_code = null where basket_seq = ?";
//					String insert = "insert into service_menu(basket_seq,emp_code,book_code, pay_seq) "
//							+ "select basket_seq, emp_code, book_code,? "
//							+ "from basket_info "
//							+ "where basket_seq = ?";
//	
//					for(int i = 0 ; i<ck_bookArr.size(); i++) {						
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					
//					for(int i = 0; i<ck_bappArr.size(); i++) {
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_bappArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					
//					for(int i = 0; i<ck_bookArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_bookArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					for(int i = 0 ; i<ck_bappArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_bappArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//				}
//				
//				if(ck_bookArr.size() != 0 && ck_happArr.size() != 0 && ck_bappArr.size() != 0) {
//				}
				
//				if(ck_bookArr.size() == 0 && ck_happArr.size() != 0 && ck_bappArr.size() == 0) {
//					
//					String sql = "update basket_info set h_app_code = null where basket_seq = ?";
//					String insert = "insert into service_menu(basket_seq,emp_code,h_app_code, pay_seq) "
//							+ "select basket_seq, emp_code, h_app_code,? "
//							+ "from basket_info "
//							+ "where basket_seq = ?";
//	
//					for(int i = 0 ; i<ck_happArr.size(); i++) {						
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_happArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					for(int i = 0; i<ck_happArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_happArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//				}
//				
//				if(ck_bookArr.size() == 0 && ck_happArr.size() == 0 && ck_bappArr.size() != 0) {
//					
//					String sql = "update basket_info set b_app_code = null where basket_seq = ?";
//					
//					String insert = "insert into service_menu(basket_seq,emp_code,b_app_code,pay_seq) "
//							+ "select basket_seq, emp_code, b_app_code,? "
//							+ "from basket_info "
//							+ "where basket_seq = ?";
//	
//					for(int i = 0 ; i<ck_bappArr.size(); i++) {						
//						pstmt = conn.prepareStatement(insert);
//						pstmt.setString(1, ck_bappArr.get(i));
//						pstmt.setString(2, service_seq());
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//					for(int i = 0; i<ck_bappArr.size(); i++) {
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, ck_bappArr.get(i));
//						pstmt.executeUpdate();
//						conn.commit();
//					}
//				}


//service_dao_test.point_basket
//--------------------------amount Int배열로 변경------------------//
		//parseInt == 1:1로 비교하는것
//		int[] h_app_amountInt = null;
//		int[] book_amountInt = null;
//		int[] b_app_amountInt = null;
//		
//		ArrayList<Integer> book_amountI = new ArrayList<Integer>();
//		ArrayList<Integer> h_app_amountI = new ArrayList<Integer>();
//		ArrayList<Integer> b_app_amountI = new ArrayList<Integer>();
		
//		String[] book_amountStr = req.getParameterValues("book_amount");
//		if(book_amountStr == null) {
//			book_amountStr = new String[1];
//			for(int i = 0 ; i<book_amountStr.length; i++) {
//				book_amountStr[i] = "0";
//			}
//			book_amountInt = new int[book_amountStr.length];
//			for(int i = 0; i<book_amountStr.length; i++) {
//				book_amountInt[i] = Integer.parseInt(book_amountStr[i]);
//			}
//		}else {
//			book_amountInt = new int[book_amountStr.length];
//			for(int i = 0; i<book_amountStr.length; i++) {
//				book_amountInt[i] = Integer.parseInt(book_amountStr[i]);
//			}
//		}
//		
//		if(book_amountInt !=null) {
//			for(int temp:book_amountInt) {
//				book_amountI.add(temp);
//			}
//		}
		
//		String[] h_app_amountStr = req.getParameterValues("h_app_amount");
//		
//		if(h_app_amountStr == null) {
//			h_app_amountStr =new String[1];
//			for(int i = 0; i<h_app_amountStr.length; i++) {
//				h_app_amountStr[i] = "0";
//			}
//			h_app_amountInt = new int[h_app_amountStr.length];
//			for(int i = 0 ; i<h_app_amountStr.length; i++) {
//				h_app_amountInt[i] = Integer.parseInt(h_app_amountStr[i]);
//			}
//		}else {
//			h_app_amountInt = new int[h_app_amountStr.length];
//			for(int i = 0; i<h_app_amountStr.length; i++) {
//				h_app_amountInt[i] = Integer.parseInt(h_app_amountStr[i]);
//			}
//		}
//		
//		if(h_app_amountInt !=null) {
//			for(int temp:h_app_amountInt) {
//				h_app_amountI.add(temp);
//			}
//		}
		
//		String[] b_app_amountStr = req.getParameterValues("b_app_amount");
//		if(b_app_amountStr == null) {
//			b_app_amountStr = new String[1];
//			for(int i = 0; i<b_app_amountStr.length; i++) {
//				b_app_amountStr[i] = "0";
//			}
//			b_app_amountInt = new int[b_app_amountStr.length];
//			for(int i = 0; i<b_app_amountStr.length; i++) {
//				 b_app_amountInt[i] = Integer.parseInt(b_app_amountStr[i]);
//			}
//		}else {
//			 b_app_amountInt = new int[b_app_amountStr.length];
//			for(int i = 0; i<b_app_amountStr.length; i++) {
//				b_app_amountInt[i] = Integer.parseInt(b_app_amountStr[i]);
//			}
//		}
//		if(b_app_amountInt !=null) {
//			for(int temp:b_app_amountInt) {
//				b_app_amountI.add(temp);
//			}
//		}
//--------------------------------------------------------------------//
//		if(h_app_amountI.size()<routine.size()) {
//			for(int i = 0 ; i<routine.size(); i++) {
//				if(h_app_amountI.size() == routine.size()) {
//					break;
//				}else {
//					h_app_amountI.add(0);
//				}
//			}
//		}

		
//		if(b_app_amountI.size()<routine.size()) {
//			for(int i = 0 ; i<routine.size(); i++) {
//				if(b_app_amountI.size() == routine.size()) {
//					break;
//				}else {
//					b_app_amountI.add(0);
//				}
//			}
//		}
		
//		if(book_amountI.size()<routine.size()) {
//			for(int i = 0 ; i<routine.size(); i++) {
//				if(book_amountI.size() == routine.size()) {
//					break;
//				}else {
//					book_amountI.add(0);
//				}
//			}
//		}
		
//		if(h_app_codeStr.get(1) == null && b_app_codeStr.get(1) == null && book_codeStr.get(1) == null) {
//			routine.remove(1);
//		}
//	public ArrayList<basketInfo> point_basket(HttpSession session) {
//		//장바구니
//		basketInfo basket = null;
//		ArrayList<basketInfo> basketList = 
//				new ArrayList<basketInfo>();
//
//		String emp_code = (String)session.getAttribute("emp_id");
//	try{
//		conn = JDBCTemplate.getConnection();
//		System.out.println("DB연결 성공");
//		
//		stmt = conn.createStatement();
//		
//		String sql = "select distinct basket_seq,emp_code, book_code, book_amount, b_app_code, b_app_amount, h_app_code , h_app_amount from basket_info "
//				+ "where emp_code='"+emp_code+"' order by to_number(basket_seq)" ;
//		
//		rs =stmt.executeQuery(sql);
//		while(rs.next()) {
//			basket = new basketInfo();
//			basket.setBasket_seq(rs.getString("basket_seq"));
//			basket.setEmp_code(rs.getString("emp_code"));
//			basket.setH_app_amount(rs.getInt("h_app_amount"));
//			basket.setBook_code(rs.getString("book_code"));
//			basket.setB_app_code(rs.getString("b_app_code"));
//			basket.setH_app_code(rs.getString("h_app_code"));
//			basket.setBook_amount(rs.getInt("book_amount"));
//			basket.setB_app_amount(rs.getInt("b_app_amount"));
//			basketList.add(basket);
//		}
//		conn.commit();
//		rs.close();
//		stmt.close();
//		conn.close();
//			
//			
//		} catch(SQLException e) {
//			System.out.println("DB연결 실패");
//			e.printStackTrace();
//		}
//		return basketList;
//	}