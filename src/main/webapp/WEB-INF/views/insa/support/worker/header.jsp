<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.Employee"%>
    
<%
	Employee emp = new Employee();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Service</title>
<style type="text/css">
h1	{
	text-align: center;
}
form {
	text-align: right;
}
</style>
</head>
<body>
	<h1 align="center">Welcome</h1>
	<div>
		<%if(emp.getEmp_name() == null) {%>
		<form action="http://localhost:8070/pugis/vacation/header" method="post">
			<label for="emp_code">사번 : </label><input type="text" name="emp_code" id="emp_code" /> &nbsp;&nbsp;
			<input type="submit" value="로그인">
		</form>
		<%} else { %>
		<div id="empInfo">
			<label><%=emp.getEmp_name() %>님의 방문을 환영합니다.</label>
		</div>
		<%} %>
	</div>
</body>
</html>
<!--  
// request.getContextPath()/common/login %>

-->