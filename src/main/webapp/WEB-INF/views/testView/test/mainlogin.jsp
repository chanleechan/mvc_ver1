<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("emp_id") == null){
		response.sendRedirect("http://localhost:8070/pugis/test/main");
	}else{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.member {
 font-size: 50px;
 text-shadow: 0 0 20px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
}

body {
 font-family: "맑은 고딕";
 font-size: 12px;
}

.form {
 width: 498px;
 height: 300px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}

.form2 {
 width: 500px;
 min-width: 320px;
 height: 200px;
 margin: 20px auto;
 margin-left:60px;
}

.form3 {
 float: left;
 /*   background:#f00;  */
}

#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
.clear {
 clear: both;
 margin-top:80px;
}
.clear1 {
 clear: both;
 margin-left:60px;
}
input[type="button"] {
 font-size: 17px;
 text-shadow: 0 0 5px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:30px;
 margin-right:30px;
 
}
input[type="submit"] {
 font-size: 17px;
 text-shadow: 0 0 5px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:10px;
 margin-right:30px;
}
</style>
<head>
<title>메인페이지</title>
</head>
<body>

<div id="wrap">
   <h1 class="member">통합 메인페이지</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">
		<form method="get" action="http://localhost:8070/pugis/test/logout">
		
		<input type="submit" value="로그아웃">
		</form>
			<div class = "clear"></div>
			<form method="get" action ="http://localhost:8070/pugis/vacation/header">
			<label><input type="submit" value="출퇴근"></label>
			<input type = "hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>" >
			<label><input type="button" value="배 치" onclick="location.href='http://localhost:8070/pugis/employee/recruitMain'"></label>
			<label><input type="button" value="복 지" onclick="location.href='http://localhost:8070/pugis/test/servicePage'"></label>
		</form>
    </div>
   </div>
  </div>
</div>
	
</body>
</html>
<%}%>