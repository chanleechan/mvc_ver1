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
// * Servlet implementation class SearchKeywordServlet
// */
//@WebServlet("/searchKeyword.e")
//public class SearchKeywordServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SearchKeywordServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String type = request.getParameter("type");
//		String keyword = request.getParameter("keyword");
//		
//		WorkerService ws = new WorkerService();
//		ArrayList<Worker> list = null;
//		try {
//			list = ws.searchKeyword(type, keyword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		RequestDispatcher rs = request.getRequestDispatcher("/web/views/work/workerList.jsp");
//		request.setAttribute("workerList", list);
//		rs.forward(request, response);	
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
//}
