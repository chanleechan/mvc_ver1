//package backup;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Enumeration;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//
//	
//@Controller
//@RequestMapping(value = "/service")
//
//public class MemberController_back {
//	HttpServletRequest req;
//	HttpServletResponse resp;
//	
//	
//	private static final Logger logger = LoggerFactory.getLogger(MemberController_back.class);
//	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	
//	public String logout(Locale locale)  {
//		logger.info("서비스메인 화면입니다.",locale);
//		
//		String pageNm = "testView/logout";
//		
//		
//		return pageNm;
//	}
//	
//	@RequestMapping(value = "/main3", method = RequestMethod.GET)
//	
//	public String firstPage1(Locale locale)  {
//		logger.info("서비스메인 화면입니다.",locale);
//		
//		String pageNm = "testView/loginForm";
//		
//		
//		return pageNm;
//	}
//	
//	
//	@RequestMapping(value = "/inputform", method = RequestMethod.GET)
//	
//	public String inputForm(Locale locale)  {
//		logger.info("서비스메인 화면입니다.",locale);
//		
//		String pageNm = "testView/inputForm";
//		
//		
//		return pageNm;
//	}
//	
//	@RequestMapping(value = "/confirmId", method = RequestMethod.GET)
//	
//	public String confirmId(Locale locale ,HttpServletRequest req2,HttpSession session) throws IOException  {
//		logger.info("로그인.",locale);
//		
//		int ck;
//		String pageNm = null;
//		
//		String emp_id = req2.getParameter("emp_id");
//		String f_emp_pass = req2.getParameter("f_emp_pass");
//		
//		MemberDao_back ma = new MemberDao_back();
//		try {
//			ck = ma.userCheck(emp_id, f_emp_pass ,session);
//			if(ck == 1) {
//				session = req2.getSession();
//				session.setAttribute("emp_id", emp_id);
//				resp.sendRedirect("http://localhost:8070/pugis/service/main2");
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		pageNm = "testView/confirmId";
//		
//		
//		return pageNm;
//	}
//	
//	@RequestMapping(value = "/inputPro", method = RequestMethod.GET)
//	
//	public String inputPro(Locale locale)  {
//		logger.info("장바구니 화면입니다.",locale);
//		
//		String pageNm = "testView/inputPro";
//		
//		
//		return pageNm;
//	}
//	
//	@RequestMapping(value = "/inputform2", method = RequestMethod.GET)
//	
//	public String inputForm2(Locale locale)  {
//		logger.info("복지등록 화면입니다.",locale);
//		
//		String pageNm = "testView/inputForm2";
//		
//		
//		return pageNm;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/loginPro", method = RequestMethod.GET)
//	
//	public String loginPro(Locale locale ,HttpServletRequest req ,HttpSession session) throws IOException, SQLException  {
//		logger.info("로그인화면입니다.",locale);
//		
//		int ck;
//		String pageNm = null;
//		
//		String emp_id = req.getParameter("emp_id");
//		String f_emp_pass = req.getParameter("f_emp_pass");
//		String session2 = "";
//		MemberDao_back ma = new MemberDao_back();
//		ck = ma.userCheck(emp_id, f_emp_pass, session);
//		
//			if(ck == 1) {
//				session = req.getSession();
//				session.setAttribute("emp_id", emp_id);
//				pageNm = "insa/support/pointMenu/login";
//				Enumeration<String> names = session.getAttributeNames();
//				session2 = names.nextElement().toString();
//				String value = session.getAttribute(session2).toString();
//				session.removeAttribute("h_appcheck");
//				System.out.println(session2 + " : " +value);
////				resp.sendRedirect("http://localhost:8070/pugis/service/main2");	
//			
//			}
//			System.out.println(ck);
//			
//			//pageNm = "testView/main";
//			// TODO Auto-generated catch block
//			
//		
//
//		return pageNm;
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	
//	public String login(Locale locale)  {
//		logger.info("로그인화면입니다..",locale);
//		
//		String pageNm = "insa/support/pointMenu/login";
//		
//		
//		return pageNm;
//	}
//}
