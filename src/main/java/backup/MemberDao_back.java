//package backup;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import com.kh.pugis.insa.support.domain.Member;
//import com.kh.pugis.insa.support.utils.JDBCTemplate;
//
//public class MemberDao_back {
//	Connection conn;
//	Statement stmt;
//	ResultSet rs;
//	PreparedStatement pstmt;
//	HttpServletRequest req;
//	
//	public MemberDao_back() {
//		
//	}
//	
//	public int userCheck(String emp_id, String f_emp_pass, HttpSession session) throws SQLException {
//		int ck = 0;
//		Member member = null;
//		
//		conn = JDBCTemplate.getConnection();
//		System.out.println("DB연결 성공");
//		int f_service_point = 0;
//		String sql = "select * from first_join where emp_id = ?";
//		
//		
//
//		
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, emp_id);
//		
//		rs = pstmt.executeQuery();
//		
//		if(rs.next()) {
//			if(f_emp_pass.equals(rs.getString("f_emp_pass"))) {
//			member = new Member();
//			member.setF_service_point(rs.getInt("f_service_point"));
//			f_service_point = member.getF_service_point();
//			session.setAttribute("f_service_point", f_service_point);
//			System.out.println(session.getAttribute("f_service_point"));
//			System.out.println(member.getF_service_point());
//			 ck = 1;
//			}else {
//				ck = 0;
//			}
//		}else {
//			ck = -1;
//		}
//		
//		return ck;
//	}
//	
//	public ArrayList<Member> inserMember() {
//		
//		Member addMemberList = null;
//		ArrayList<Member> memberList = 
//				new ArrayList<Member>();
//		
//		try {
//			conn = JDBCTemplate.getConnection();
//			System.out.println("DB연결 성공");
//			
//			stmt = conn.createStatement();
//			
//			String emp_code = req.getParameter("emp_code");
//			String emp_id = req.getParameter("emp_id");
//			String f_emp_pass = req.getParameter("f_emp_pass");
//			int f_service_point = Integer.parseInt(req.getParameter("f_service_point"));
//			
//			String sql ="INSERT INTO FIRST_JOIN(EMP_CODE, F_EMP_PASS, F_SERVICE_POINT, EMP_ID)"
//					+ " VALUES(?,?,?,?)";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, emp_code);
//			pstmt.setString(2,f_emp_pass);
//			pstmt.setInt(3, f_service_point);
//			pstmt.setString(4, emp_id);
//			
//			conn.commit();
//			
//			sql = "select emp_code, f_emp_pass, f_service_point, emp_id from first_join ";
//			
//			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				addMemberList = new Member();
//				addMemberList.setEmp_code(rs.getString("emp_code"));
//				addMemberList.setF_emp_pass(rs.getString("f_emp_pass"));
//				addMemberList.setF_service_point(rs.getInt("f_service_point"));
//				addMemberList.setEmp_id(rs.getString("emp_id"));
//				memberList.add(addMemberList);
//			}
//			conn.commit();
//			rs.close();
//			stmt.close();
//			conn.close();
//			
//			System.out.println("복지 등록 완료");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return memberList;
//		
//	}
//	
//	public int confirmId(String emp_id) throws SQLException {
//		int check = 0;
//		
//		conn = JDBCTemplate.getConnection();
//		System.out.println("DB연결 성공");
//		String sql = "select emp_id from first_join where emp_id = ?";
//		emp_id = req.getParameter(emp_id);
//		
//		
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, emp_id);
//		
//		if(rs.next()) {
//			if(emp_id.equals(rs.getString("emp_id"))) {
//				check = 1;
//			}
//		}
//		
//		return check;
//		
//	}
//	
////	public int loginPro() {
////		int ck = 0;
////		
////		String emp_id = req.getParameter("emp_id");
////		String f_emp_pass = req.getParameter("f_emp_pass");
////		
////		MemberDao ma = new MemberDao();
////		try {
////			ck = ma.userCheck(emp_id, f_emp_pass);
////			if(ck == 1) {
////				
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return ck ;
////	}
//}
