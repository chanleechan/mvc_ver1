<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel ="stylesheet" href = "<c:url value="/resources/css/table.css"/>"  rel = "stylesheet">
<title>휴가 목록</title>

<script type="text/javascript">
function check(){
	alert("배치를 완료하였습니다.");
}

</script>

</head>
<body>
<h2 class = "member" align="center">대기발령 직원목록</h2>
	<div class="outer" align="center">
		<br>
		<form action ="http://localhost:8070/pugis/employee/deptUpdate" name = "employeeList"method ="get" onsubmit="retrun check()">
			<div class="tableArea" align = "center">
				<table border="1" id="listArea">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>부서</th>
						<th>직급</th>
						<th>배치</th>
					</tr>
				<c:if test = "${empty waitList}">
					<td colspan="9">등록된 직원이없습니다.</td>
				</c:if>			
				<c:forEach var="waitEmployee" items="${waitList}" >	
					<tr>
						<td>${waitEmployee.n_Emp_code}</td>
						<td>${waitEmployee.n_Emp_name}</td>
						<td>${waitEmployee.n_Emp_gender}</td>
						<td>${waitEmployee.n_Emp_phone}</td>
						<td>${waitEmployee.dept_name}</td>
						<td>${waitEmployee.rank_id}</td>
						<td>
							<select name = "dept_code">
								<option value="d8">대기발령</option>
								<option value="d1">인사</option>
								<option value="d2">마케팅</option>
							</select>
							<input type="hidden" name = "n_Emp_code" value = "${waitEmployee.n_Emp_code}">
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
				<input type = "submit" value = "배치하기" >
			</div>
		</form>
	</div>	
</body>
</html>