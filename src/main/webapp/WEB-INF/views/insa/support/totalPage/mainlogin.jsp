<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	if(session.getAttribute("emp_id") == null){
		response.sendRedirect("http://localhost:8070/pugis/test/main");
	}else{
%>
<!DOCTYPE html>
<html>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" >

		$(document).ready(function() {
			$("#hiBtn").click(function(event){
				var emp_name ="<%=session.getAttribute("emp_name")%>";
				var d = new Date();
				var currentDate = d.getFullYear() + "년 " + ( d.getMonth() + 1 ) +
				"월 " + d.getDate() + "일";
				var currentTime = d.getHours() + "시 " + 
				d.getMinutes() + "분 " + d.getSeconds() + "초"; 
				
				var result = document.getElementById("time-result"); 
				alert(emp_name + " 님 " + currentDate + " " + currentTime + "에 출근 완료되었습니다.");
				$('#working').text("출근완료");
			});
		});
		
		$(document).ready(function() {
			$("#byeBtn").click(function(event){
				var emp_name ="<%=session.getAttribute("emp_name")%>";
				var d = new Date();
				var currentDate = d.getFullYear() + "년 " + ( d.getMonth() + 1 ) +
				"월 " + d.getDate() + "일";
				var currentTime = d.getHours() + "시 " + 
				d.getMinutes() + "분 " + d.getSeconds() + "초"; 
				
				var result = document.getElementById("time-result"); 
				alert( emp_name +  " 님"  + currentDate + " " + currentTime + "에 퇴근 완료되었습니다.");
			});
		});	
	</script>
<head>
	<link rel ="stylesheet" href = "<c:url value="/resources/css/mainPage.css"/>"  rel = "stylesheet">
<title>메인페이지</title>
</head>
<body>
	<header>
	    <div class="header">
    		<input type = "checkbox" id = "menuicon">
	        <label for="menuicon">
	           <span></span>
	           <span></span>
	           <span></span>
	        </label>
          <div class = "sidebar">
          	<form action = "http://localhost:8070/pugis/vacation/header" method="get">
	      		<input type = "hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>" >
	          	<ul>
		          <li><input type="submit" value="출퇴근"></li>
		          <li><input type="button" value="배치" onclick="location.href='http://localhost:8070/pugis/employee/recruitMain'"></li>
		          <li><input type="button" value="복지" onclick="location.href='http://localhost:8070/pugis/total/servicePage'"></li>
		          <li><input type="button" value="로그아웃" onclick = "location.href = 'http://localhost:8070/pugis/total/logout'"></li>
		        </ul>
	         	&nbsp;&nbsp;&nbsp;<%=session.getAttribute("emp_code")%> 님 안녕하세요.
	        </form>
          </div>
          	<h1>인사 복지 시스템</h1>
	   	 </div>
   	 </header>
   	 <main>
   	 	<div class = "main">
			<div class = "mainClear" ></div>
			<div class = "main2">
			    <div class = "memberInfo">
		            <ul>
		              <li>사번 : <%=session.getAttribute("emp_code")%></li>
		              <li>이름 : <%=session.getAttribute("emp_name")%></li>
		              <li>부서 : <%=session.getAttribute("dept_name")%></li>
		              <li>직급 : <%=session.getAttribute("rank_name")%></li>
		            </ul>
			    </div> 
			     <div class = "goWork">
			     	<form>
			          출근시간 : 00:00 <input type = "button" value="출근하기" onclick="location.href ='http://localhost:8070/pugis/work/goWork'"  id='hiBtn'>
			          <br><br> 
			          퇴근시간 : 00:00 <input type = "button" value="퇴근하기" onclick = "location.href='http://localhost:8070/pugis/work/offWork'" id='byeBtn'>
			          <input type ="hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>"> 
			        </form>
			    </div>
			    <div class = "workStatus">
			    
			    </div>
	    	</div>
		    <div class="main3">
	        	<div class = "product">
	        	</div>
	        </div>
		   	<div class="main4">
	        	<div class = "notice">
	        	</div>
		    </div> 
		</div>
   	 </main>
	<footer>
   	 <div class = "footer">
   	 </div>
	</footer>
</body>
</html>
<%}%>