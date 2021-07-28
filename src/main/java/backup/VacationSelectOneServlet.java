//package backup;
//
//import java.io.IOException;
//import java.sql.SQLException;
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
// * Servlet implementation class VacationSelectOneServlet
// */
//@WebServlet("/vSelectOne.va")
//public class VacationSelectOneServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public VacationSelectOneServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String vacation_code = request.getParameter("vacation_code");
//		
//		Vacation_work vw = null;
//		try {
//			vw = new VacationService().selectOne(vacation_code);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String page = "";
//		
//		if(vw != null) {
//			page = "views/vacation/vacationDetail.jsp";
//			request.setAttribute("vacation_work", vw);
//		}else {
//			page = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "휴가 신청서 상세 보기 실패!");
//		}
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
