<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출퇴근 시스템</title>
<style>
div	{
	text-align: center;
}
.btn1 {
	font-weight:bold;
	text-decoration:none;
	font-family:Arial;
	box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	o-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	-moz-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	-webkit-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	background:#ffffff;
	background:-o-linear-gradient(90deg, #ffffff, #7ea5d9);
	background:-moz-linear-gradient( center top, #ffffff 5%, #7ea5d9 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #7ea5d9) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#7ea5d9');
	background:-webkit-linear-gradient(#ffffff, #7ea5d9);
	background:-ms-linear-gradient(#ffffff, #7ea5d9);
	background:linear-gradient(#ffffff, #7ea5d9);
	text-indent:0px;
	line-height:73px;
	-moz-border-radius:94px;
	-webkit-border-radius:94px;
	border-radius:94px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:10px;
	color:#ffffff;
	width:73px;
	height:73px;
	padding:11px;
	text-shadow:#73a7ba -1px -1px 0px;
	border-color:#ebeab7;
	border-width:7px;
	border-style:solid;
}

.btn1:active {
	box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	o-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	-moz-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	-webkit-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	position:relative;
	top:3px
}

.btn1:hover {
	background:#7ea5d9;
	background:-o-linear-gradient(90deg, #7ea5d9, #ffffff);
	background:-moz-linear-gradient( center top, #7ea5d9 5%, #ffffff 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #7ea5d9), color-stop(1, #ffffff) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7ea5d9', endColorstr='#ffffff');
	background:-webkit-linear-gradient(#7ea5d9, #ffffff);
	background:-ms-linear-gradient(#7ea5d9, #ffffff);
	background:linear-gradient(#7ea5d9, #ffffff);
}

</style>
</head>

<body>
		
	<br>
		<%if(session.getAttribute("manager").equals("dm")) {	%>
	<br>
	<div id="btn_group">
		<a href='http://localhost:8070/pugis/work/goWork' id='hiBtn' >출근하기</a>	
		<a href='http://localhost:8070/pugis/work/offWork' id='byeBtn'>퇴근하기</a>	
		<a href='http://localhost:8070/pugis/vacation/vacationAdd' id='vBtn'>휴가신청</a>	
		<a href='http://localhost:8070/pugis/vacation/selectVacation'>신청자조회</a>
		<a href= 'http://localhost:8070/pugis/vacation/selectVacation'>전체목록조회</a>	
	</div>
	<%} else if((session.getAttribute("manager").equals("n"))) {%>
	<div id="btn_group">
		<a href='http://localhost:8070/pugis/work/goWork' id='hiBtn'>출근하기</a>	
		<a href='http://localhost:8070/pugis/work/offWork' id='byeBtn'>퇴근하기</a>	
		<a href='http://localhost:8070/pugis/vacation/vacationAdd' id='vBtn'>휴가신청</a>
			
		
	</div>
	<%} %>
	<form action ="http://localhost:8070/pugis/test/goMain" method = "get">
	<div>
		<input type="submit" value = "뒤로가기">
		<input type ="hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>">
	</div>
	</form>
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
	
</body>
</html>


