//package backup;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.work.model.service.WorkerService;
//import com.work.model.vo.Worker;
//
///**
// * Servlet implementation class WorkerGoWork
// */
//@WebServlet("/goWork.w")
//public class WorkerGoWorkServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public WorkerGoWorkServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		
//		String today = request.getParameter("today");
//		String dept = request.getParameter("dept");
//		String emp_code = request.getParameter("dept");
//		String o_emp_name = request.getParameter("o_emp_name");
//		String time_now = request.getParameter("time_now");
//		String status = request.getParameter("status");
//		
//		Worker w = new Worker();
//		w.setToday(today);
//		w.setDept(dept);
//		w.setEmp_code(emp_code);
//		w.setO_emp_name(o_emp_name);
//		w.setTime_now(time_now);
//		w.setStatus(status);
//		
//		int result = new WorkerService().insertGoWorker(w);
//		
//		
//		if(result > 0) {
//			response.sendRedirect("allList.w");
//		}else {
//			request.setAttribute("msg", "출근 등록 실패!");
//			request.getRequestDispatcher("views/common/errorPage.jsp")
//			.forward(request, response);
//		}
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
//}
