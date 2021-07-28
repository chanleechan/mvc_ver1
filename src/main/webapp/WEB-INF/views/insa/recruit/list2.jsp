<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">


</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>User List</title>
<link rel="sytlesheet" type="text/css" href="resources//css/bootstrap.min.css">
</head>


<body>
<h2>직원 List</h2> 
<input type="text" name="input" align="right" />
<input type="button" align="right" value = "검색"/>
<br />
<form name = "ok" action = "list2"  method = "get" >
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>사번</th>
				<th>성명</th>
				<th>성별</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<!-- 첫번째 줄 시작 -->
					<td>${employee.emp_code}</td>
					<td>${employee.emp_name}</td>
					<td>${employee.emp_gender}</td>
					<td>${employee.emp_phone}</td>
					<td><input type ="radio" name = "emp_code" value = "${employee.emp_code}">
					<input type ="hidden" value = "${employee.emp_code}">
					</td>
					<td>
					<select name = "dept">
						<option value = "choice">부서선택</option>
						<option value = "dept01">부서1</option>
						<option value = "dept02">부서2</option>
						<option value = "dept03">부서3</option>
					</select>
					</td>
				</tr>
				<!-- 첫번째 줄 끝 -->
			</c:forEach>
		</tbody>
	</table>
	<input type =submit name = "checkEmp_code">
</form>
</body>
</html>