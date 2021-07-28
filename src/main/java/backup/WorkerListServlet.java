package backup;
//package com.work.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
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
// * Servlet implementation class WorkerListServlet
// */
//@WebServlet("/workerList.w")
//public class WorkerListServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public WorkerListServlet() {
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
//		ArrayList<Worker> list = null;
//		RequestDispatcher dispatcher = null;
//		
//		WorkerService ws = new WorkerService();
//		
//		try {
//			list = ws.workerList();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(list.size() == 0) {
//			request.setAttribute("msg", "일치하는 데이터가 없음");
//			dispatcher = request.getRequestDispatcher("/views/common/errorPage.jsp");
//
//			
//		} else {
//			request.setAttribute("workerList", list);
//			dispatcher = request.getRequestDispatcher("/views/worker/workerList.jsp");
//		}
//		dispatcher.forward(request, response);
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
