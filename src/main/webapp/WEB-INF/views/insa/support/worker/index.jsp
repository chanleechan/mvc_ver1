<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출퇴근 시스템</title>
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
.clear {
 clear: both;
 margin-top:80px;
}


</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" >
	// 출근 버튼 클릭 시 
	
	
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
</head>

<body>
<div id="wrap">
	<h1 class = "member">근태 페이지</h1>
	<div class = "form">
		<div class = "form2">
			<div class="form3">
				<form method="get" action="http://localhost:8070/pugis/test/logout">
					<input type="submit" value="로그아웃">
				</form>
				<br>
				<br>

		<%if(session.getAttribute("manager").equals("dm")) {	%>
				
				<form action = "http://localhost:8070/pugis/test/goMain" method = "get">
					
					<label><input type="button" onclick="location.href ='http://localhost:8070/pugis/work/goWork';"  id='hiBtn' value = "출근하기">	</label>
					<label><input type = "button" onclick = "location.href='http://localhost:8070/pugis/work/offWork'" id='byeBtn' value = "퇴근하기">	</label>
					<label><input type = "button" onclick = "location.href='http://localhost:8070/pugis/vacation/vacationAdd'" id='vBtn' value = "휴가신청">	</label>
					<label><input type = "button" onclick = "location.href='http://localhost:8070/pugis/vacation/selectVacation'" value = "신청자조회"></label>
					<label><input type = "button" onclick = "location.href= 'http://localhost:8070/pugis/vacation/selectVacationAll'" value = "전체목록조회"></label>
					<input type="submit" value = "뒤로가기">
					<input type ="hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>"> 
				</form>
	
	<%} else if((session.getAttribute("manager").equals("n"))) {%>
	
				<div id="btn_group">
				<form action ="http://localhost:8070/pugis/test/goMain" method = "get">
					<input type="button" onclick="location.href ='http://localhost:8070/pugis/work/goWork';"  id='hiBtn' value = "출근하기">	
					<input type = "button" onclick = "location.href='http://localhost:8070/pugis/work/offWork'" id='byeBtn' value = "퇴근하기">	
					<input type = "button" onclick = "location.href='http://localhost:8070/pugis/vacation/vacationAdd'" id='vBtn' value = "휴가신청">
					<input type="submit" value = "뒤로가기">
					<input type ="hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>">	
				</form>	
				</div>
	
	<%} %>
			</div>
		</div>
	</div>	
</div>
	
</body>
</html>


