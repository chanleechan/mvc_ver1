//package backup;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.kh.pugis.insa.support.domain.Member;
//import com.kh.pugis.insa.support.domain.b_appliance;
//import com.kh.pugis.insa.support.domain.basketInfo;
//import com.kh.pugis.insa.support.domain.book;
//import com.kh.pugis.insa.support.domain.h_appliance;
//
//public class serviceList {
//	HttpServletRequest req;
//
//	public serviceList() {}
//	
////	public ArrayList<basketInfo> basketSearch() throws ClassNotFoundException{
////		ArrayList<basketInfo> basketList = 
////				new ArrayList<basketInfo>();	
////		basketList = new service_dao().point_basket(req);
////		return basketList;
////	}
//	
//	
//	public ArrayList<basketInfo> basketSearch2() {
//		ArrayList<basketInfo> basketList = 
//				new ArrayList<basketInfo>();	
//		basketList = new service_dao_back().point_basket2();
//		return basketList;
//	}
//	
//	public ArrayList<book> BookSearch(){
//		ArrayList<book> bookList = 
//				new ArrayList<book>();
//		bookList = new service_dao_back().addmenu_book();
//		
//		return bookList;		
//	}
//	
//	public ArrayList<h_appliance> h_appSearch(){
//		ArrayList<h_appliance> appList = 
//				new ArrayList<h_appliance>();
//		appList = new service_dao_back().addmenu_H_appliances();
//		
//		return appList;
//	}
//
//	public ArrayList<b_appliance> b_appSearch() {
//		ArrayList<b_appliance> appList = 
//				new ArrayList<b_appliance>();
//		appList = new service_dao_back().addmenu_b_appliances();
//		
//		return appList;
//	}
//	
//	public ArrayList<Member> insertMember(){
//		ArrayList<Member> memberList = 
//				new ArrayList<Member>();
//		memberList = new MemberDao_back().inserMember();
//		
//		return memberList;
//	}
//	
//	public ArrayList<h_appliance> basket_h_appSearch(){
//		ArrayList<h_appliance> appList = 
//				new ArrayList<h_appliance>();
//		appList = new service_dao_back().add_basket_H_app();
//		
//		return appList;
//	}
//	
//}
