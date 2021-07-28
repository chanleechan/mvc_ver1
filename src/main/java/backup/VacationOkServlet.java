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
// * Servlet implementation class VacationOkServlet
// */
//@WebServlet("/vOk.va")
//public class VacationOkServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public VacationOkServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String status = request.getParameter("status");
//		
//		Vacation_work vw = new Vacation_work();
//		
//		vw.setStatus("승인");
//		
//		int result = 0;
//		try {
//			result = new VacationService().okVacation(vw);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(result > 0) {
//			response.sendRedirect("vSelectOne.va?status=" + status);
//		} else {
//			request.setAttribute("msg","공지사항 수정 실패!!");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		
//		}
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
