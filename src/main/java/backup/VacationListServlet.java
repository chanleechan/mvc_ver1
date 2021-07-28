//package backup;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.vacation.model.service.VacationService;
//import com.vacation.model.vo.Vacation_work;
//
///**
// * Servlet implementation class VacationListServlet
// */
//@WebServlet("/selectList.va")
//public class VacationListServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public VacationListServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		ArrayList<Vacation_work> list = null;
////		RequestDispatcher dispatcher = null;
//		
//		VacationService vs = new VacationService();
//		
//		try {
//			list = vs.selectList();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
////		try {
////			list = vs.selectList();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		if(list.size() == 0) {
////			request.setAttribute("msg", "일치하는 데이터가 없음");
////			dispatcher = request.getRequestDispatcher("/views/common/errorPage.jsp");
////
////			
////		} else {
////			request.setAttribute("vacationList", list);
////			dispatcher = request.getRequestDispatcher("/views/vacation/vacationList.jsp");
////		}
////		dispatcher.forward(request, response);
//		
////		try {
////			list = new VacationService().selectList();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} 
////		
//		String page = "";
//		if(list != null) {
//			page = "views/vacation/vacationList.jsp";
//			request.setAttribute("list", list);
//			
//		} else {
//			page = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "공지사항 목록 불러오기 에러!");
//		}
////		selectList.va /views/vacation/vacationList.jsp
//		
//		request.getRequestDispatcher(page).forward(request, response);
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
//}
