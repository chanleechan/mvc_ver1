<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.pugis.insa.support.domain.*"%>
<%
	Worker w = (Worker)session.getAttribute("worker");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 출퇴근 내용</title>
</head>
<body>
	<h1>직원 출퇴근 상태 변경</h1>
	<br>
	<div class="tableArea">
		<table  id="listArea">
			<tr>
				<th>	</th>
				<th>일자</th>
				<th>부서</th>
				<th>사원코드</th>
				<th>사원 명</th>
				<th>시간</th>
				<th>상태</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="check" onClick="statusCheck(this.form)"></td>
				<td><%=w.getToday() %></td>
				<td><%=w.getDept() %></td>
				<td><%=w.getEmp_code() %></td>
				<td><%=w.getO_emp_name() %></td>
				<td><%=w.getTime_now() %></td>
				<td><%=w.getStatus() %></td>
			</tr>
		</table>
	</div>
	<div class="searchArea" align="center">
		<form action="/searchKeyword.e">
			<select id="type" name="searchType">
				<option value="">---</option>
				<option value="empCode">사원코드</option>
				<option value="empName">사원명</option>
				<option value="dept">부서</option>
			</select>
			<input type="search" id="keyword" placeholder="사원번호 입력">
		<!-- <button type="button" onclick="search();">조회</button> -->
			<button type="submit" >조회</button>
		</form>
	</div>
	<div class="changeStatus" align="center">
			<button type="button" onclick="workerStatusUpdate.jsp" disabled="disabled">수정</button>
	</div>
	<script>

		function statusCheck(frm)
		{
		   if (frm.checkButton.disabled==true)
		    frm.checkButton.disabled=false
		   else
		    frm.checkButton.disabled=true
		}
</script>
</body>
</html>