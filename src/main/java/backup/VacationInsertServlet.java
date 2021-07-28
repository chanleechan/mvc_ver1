//package backup;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.kh.pugis.insa.support.service.VacationService;
//import com.kh.pugis.insa.support.domain.Vacation_work;
//
///**
// * Servlet implementation class VacationInsertServlet
// */
//@WebServlet("/vInsert.va")
//public class VacationInsertServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    public VacationInsertServlet() {
//        super();
//    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//
//		Vacation_work vw = new Vacation_work();
//					
//		int result = 0;
//		try {
//			result = new VacationService().insertVacation(vw, request);
//			if(result > 0) {
//				// 성공
//				response.sendRedirect("index.jsp");
//			} else { 
//				// 실패
//				request.setAttribute("msg", "휴가 신청 등록 실패!");
//				request.getRequestDispatcher("views/common/errorPage.jsp");
//			}
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//			
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}//		String date = request.getParameter("date");
////System.out.println("날자 전달 확인 : " + date);
////Date writeDate = null;
////
////if(date !="" && date != null) {
////	// 날짜가 들어 왔을 경우
////	String[] dateArr = date.split("/");
////	int[] intArr = new int[dateArr.length];
////	
////	// String을 int로 변경
////	for(int i = 0; i < dateArr.length; i++) {
////		intArr[i] = Integer.parseInt(dateArr[i]);
////	}
////	
////	writeDate = new Date(new GregorianCalendar(
////			intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
////} else {
////	// 날짜가 들어오지 않는 경우
////	writeDate = new Date(new GregorianCalendar().getTimeInMillis());
////}
//// 휴가 신청 등록을 위한 vo객체 만들기
