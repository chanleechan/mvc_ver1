<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.kh.pugis.insa.support.dao.MemberDao" %>
     
<%
    request.setCharacterEncoding("utf-8");
 
    String emp_id =request.getParameter("emp_id");
    String f_emp_pass =request.getParameter("passwd");
     
  //  MemberDao manager =new MemberDao();
  //  int check = manager.userCheck(emp_id, f_emp_pass);
  	  MemberDao manager = new MemberDao();
  	  int ck = manager.userCheck(emp_id,f_emp_pass,session);
     
    //userCheck에서 x를 return 받아서 로긴체크
    //history.go(-1); : 전페이지로 (입력창)
    if(ck==1){
        //로그인 성공
        session.setAttribute("emp_id",emp_id);
        response.sendRedirect("main.jsp");
         
    }else if(ck==0){   
%> 
    <script>
        alert("비밀번호가 맞지 않습니다.");
        history.go(-1);       
    </script>
<%}else{ %>
    <script>
        alert("아이디가 맞지 않습니다.");
        history.go(-1);       
    </script>
<%} %>



