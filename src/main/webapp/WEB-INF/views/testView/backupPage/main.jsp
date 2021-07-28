<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("emp_id") == null) { 
%>
<jsp:forward page="loginForm.jsp" />
	<%}else{%>
<jsp:forward page="http://localhost:8070/pugis/service/login" />
<%} %>