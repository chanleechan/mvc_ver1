<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가 목록</title>
<style type="text/css">
.member {
 font-size: 20px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
}
.tableArea{
margin: 0 auto;
}
table {
  width: 765px;
  height: 219px;
  border-top: 1px solid #444444;
  border-collapse: collapse;
}
th, td {
  border-bottom: 1px solid #444444;
  padding: 10px;
  text-align: center;
}
thead tr {
  background-color: #0d47a1;
  color: #ffffff;
}
tbody tr:nth-child(2n) {
  background-color: #bbdefb;
}
tbody tr:nth-child(2n+1) {
  background-color: #e3f2fd;
}
</style>
</head>
<body>
<h2 class = "member" align="center">전체직원목록</h2>
	<div class="outer" align="center">
		<br>
			<div class="tableArea" align = "center">
				<table border="1" id="listArea">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>부서</th>
						<th>직급</th>
					</tr>
				<c:if test = "${empty empList}">
					<td colspan="9">등록된 직원이없습니다.</td>
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