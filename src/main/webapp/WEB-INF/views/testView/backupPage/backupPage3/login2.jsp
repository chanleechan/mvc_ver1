<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("memId") == null){
		response.sendRedirect("main.jsp");
	}else{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
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
 font-size: 15px;
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
 font-size: 15px;
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
<title>메인페이지</title>
</head>
<body>

<div id="wrap">
   <h1 class="member">복지포인트사용 페이지</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">
		<%=session.getAttribute("emp_id") %> 님이 접속하였습니다.
		<form method="post" action="logout.jsp">
		<input type="submit" value="로그아웃">
		</form>
		<div class = "clear"></div>
		<label><input type="button" value="업무기구" onclick="location.href='work.jsp'"></label>
		<label><input type="button" value="도 서" onclick="location.href='book.jsp'"></label>
		<label><input type="button" value="일반가전" onclick="location.href='appliances.jsp'"></label>
		<label><input type="button" value="장바구니" onclick="location.href='cart.jsp'"></label>
		  

     </div>
     </div>
     </div>
     </div>
	
</body>
</html>
<%}%>