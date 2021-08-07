<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel ="stylesheet" href = "<c:url value="/resources/css/table.css"/>"  rel = "stylesheet">
<title>휴가 목록</title>

</head>
<body>
<h2 class = "member" align="center">전체직원목록</h2>
	<div class="outer" align="center">
		<br>
			<div class="tableArea" align = "center">
				<table border="1" id="listArea" class="table">
					<tr>
						<th style="background-color: #fcd8d4">사번</th>
						<th style="background-color: #fcd8d4">이름</th>
						<th style="background-color: #fcd8d4">성별</th>
						<th style="background-color: #fcd8d4">전화번호</th>
						<th style="background-color: #fcd8d4">부서</th>
						<th style="background-color: #fcd8d4">직급</th>
					</tr>
				<c:if test = "${empty empList}">
					<td colspan="9" style="text-align: center">등록된 직원이없습니다.</td>
				</c:if>			
				<c:forEach var="EmployeeList" items="${empList}" >	
					<tr>
					<td>${EmployeeList.emp_code}</td>
					<td>${EmployeeList.emp_name}</td>
					<td>${EmployeeList.emp_gender}</td>
					<td>${EmployeeList.emp_phone}</td>
					<td>${EmployeeList.dept_code}</td>
					<td>${EmployeeList.rank_id}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
	</div>	
</body>
</html>