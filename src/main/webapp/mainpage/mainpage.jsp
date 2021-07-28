<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("memId") == null) { 
%>
<jsp:forward page="mainloginForm.jsp" />
	<%}else{%>
<jsp:forward page="mainlogin.jsp" />
<%} %>