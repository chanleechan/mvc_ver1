<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 리스트</title>
</head>
<body>
	<!-- name 혹은 code가 admin인 사람만 조회 가능하게 -->
	<h1 align="center">직원 출퇴근 현황 조회</h1>
	<br>
	<div class="tableArea">
		<table  border="1"  id="listArea">
			<tr>
				<th>일자</th>
				<th>부서</th>
				<th>사원코드</th>
				<th>사원 명</th>
				<th>시간</th>
				<th>상태</th>
			</tr>
			<c:forEach var="workerList" items="${workerList}">
			<tr>
				<td>${workerList.today }</td>
				<td>${workerList.dept }</td>
				<td>${workerList.emp_code }</td>
				<td>${workerList.o_emp_name }</td>
				<td>${workerList.time_now }</td>
				<td>${workerList.status }</td>
			</tr>
			</c:forEach>
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
</body>
</html>