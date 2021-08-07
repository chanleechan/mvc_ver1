
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<% 

	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
	String strdate = simpleDate.format(date);

%>
<head>
<meta charset="UTF-8">
	<link rel ="stylesheet" href = "<c:url value="/resources/css/vacationCommit.css"/>">
<title>휴가 신청</title>
<script type="text/javascript">
function check(){
	alert("신청이 완료되었습니다.");
}
</script>
</head>
<body>
	<div class="outer">
		<br>
			<h3 class = "member">휴가 신청서</h3>
		<br>
		<div class="tableArea" align="center">
			<form class="form" action="http://localhost:8070/pugis/vacation/vInsert" name = "userinput" method="get" onsubmit="return check()">
				<table >
					<tr>
						<td style="background-color: #fcd8d4">신청 날짜</td>
						<td><input type="text" name="vacation_code" value = "<%=strdate%>"></td>	
						<td style="background-color: #fcd8d4">사번</td>	
						<td><input type="text" name="emp_code" value = "<%=session.getAttribute("emp_code")%>"></td>
						<td style="background-color: #fcd8d4">성명</td>
						<td> 
						<input type="text" name="n_emp_name" value ="<%=session.getAttribute("emp_name")%>">
						</td>
					</tr>
					<tr>
						<td style="background-color: #fcd8d4">시작일</td>
						<td><input type="date" name="vacation_startDate"></td>	
						<td style="background-color: #fcd8d4">끝</td>
						<td><input type="date" name="vacation_endDate"></td>
						<td style="background-color: #fcd8d4">상태</td>
						<td><input type="text" value="대기" readonly="readonly"></td>
					</tr>
					<tr>
						<td style="background-color: #fcd8d4">휴가 사유</td>
						<td colspan="6"><textarea rows="10" cols="89" name = "vcontent"></textarea>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="reset" class = "btn">지우기</button>
					<button type="submit" class = "btn">신청</button>
				</div>
				
			</form>
			
		</div>
	</div>
</body>
</html>