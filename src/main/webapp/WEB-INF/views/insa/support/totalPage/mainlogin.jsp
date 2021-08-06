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
	function logout(){
		alert("로그아웃 되엇습니다.");
	}

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
			
			
			var manager = '<%=(String)session.getAttribute("manager")%>';
			$("#vacationSelect").click(function(event){
				if(manager == "dm"){
		    		$('#content').load('http://localhost:8070/pugis/vacation/selectVacation');
				}else{
					alert("권한이 없습니다.");
				}
		    });
			
			$("#vacationSelectAll").click(function(event){
				if(manager == "dm"){
		    		$('#content').load('http://localhost:8070/pugis/vacation/selectVacationAll');
				}else{
					alert("권한이 없습니다.");
				}
			});
			$("#vacationCommit").click(function(event){
				$("#content").load('http://localhost:8070/pugis/vacation/vacationAdd');
			});
			
			$("#memberListAll").click(function(event){
				if(manager == "dm"){
					$("#content").load('http://localhost:8070/pugis/employee/employeeList');
				}else{
					alert("권한이 없습니다.");
				}
			});
			
			$("#myVacation").click(function(event){
					$("#content").load('http://localhost:8070/pugis/vacation/myVacationList');
			});
			
			$("#recuritMember").click(function(event){
				if(manager == "dm"){
					$("#content").load('http://localhost:8070/pugis/employee/waitEmployeeList');
				}else{
					alert("권한이 없습니다.");
				}
			});
			$("#productList").click(function(event){
				$("#content").load('http://localhost:8070/pugis/service/product');
			});
			
			$("#basket").click(function(event){
				$("#content").load('http://localhost:8070/pugis/service/basket');
			});
			
		}); 
	</script>
<head>
	<link rel ="stylesheet" href = "<c:url value="/resources/css/mainPage.css"/>"  rel = "stylesheet">
	<link rel ="stylesheet" href = "<c:url value="/resources/css/headerSidebar.css"/>"  rel = "stylesheet">
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
	      		<input type = "hidden" name = "emp_code" value = "<%=session.getAttribute("emp_code")%>" >
	      	<h4>근태</h4>
	        <ul>
	        	<li><input type="button" id ="vacationCommit" value="휴가신청하기" ></li>
	        	<li><input type="button" id ="myVacation" value = "내 신청목록"></li>
		        <li><input type="button" id ="vacationSelect" value="신청자조회"></li>
				<li><input type="button" id ="vacationSelectAll" value="전체목록조회"></li>
		    </ul>
           <h4>복지서비스</h4>
            <ul> 
                <li><input type="button" id = "productList" value="상품목록"></li>
                <li><input type="button" id = "basket" value="장바구니"></li>
		    </ul>
            <h4>인사</h4>
            <ul> 
                <li><input type="button" id = "memberListAll" value="사원전체보기" ></li>
                <li><input type="button" id = "recuritMember" value="사원배치하기" ></li>
		    </ul>
	        
          </div>
          	<h1>인사 복지 시스템</h1>
	   	 </div>
   	 </header>
   	 <main>
   	 	<div class = "main">
			<div class = "main2">
			    <div class = "memberInfo">
		            <ul>
		              <li>&nbsp; 사번 : <%=session.getAttribute("emp_code")%></li>
		              <li>&nbsp; 이름 : <%=session.getAttribute("emp_name")%></li>
		              <li>&nbsp; 부서 : <%=session.getAttribute("dept_name")%></li>
		              <li>&nbsp; 직급 : <%=session.getAttribute("rank_name")%></li>
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
			    	<form method="post" action="http://localhost:8070/pugis/total/logout" onsubmit="logout()">
						<input type="submit" value="로그아웃">
					</form>
			    </div>
	    	</div>
		    <div class="main3">
	        	<div class = "product" id = "content">
	        	</div>
	        </div>
		   	<div class="main4">
	        	<div class = "notice" id = "vacationAll">
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