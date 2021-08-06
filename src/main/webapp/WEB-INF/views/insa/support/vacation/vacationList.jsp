<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가 목록</title>
<style type="text/css">
.tableArea{
margin: 0 auto;
}
.member {
 font-size: 20px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
}
table {
  width: 765px;
  height: 219px;
  border-top: 1px solid #444444;
  border-collapse: collapse;
}
th, td {
  font-size:11px;
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

<script type="text/javascript">
	function check(){
		alert("수정하였습니다.");
	}
</script>
</head>
<body>
	<div class="outer" align="center">
			<h3 class = "member">신청자 목록</h3>
		<br>
		<form action ="http://localhost:8070/pugis/vacation/vaOk" method ="get" onsubmit="return check()">
			<div class="tableArea" align = "center">
				<table border="1" id="listArea">
				<tr>
					<th>휴가신청코드</th>
					<th>신청일</th>
					<th>사번</th>
					<th>사원명</th>
					<th>시작일</th>
					<th>복귀일</th>
					<th>사유</th>
					<th>상태</th>
					<th>수정</th>
				</tr>
			<c:if test = "${empty vaList}">
					<td colspan="9">수정할 내용이 없습니다.</td>
			</c:if>
			<c:forEach var="List" items="${vaList}" >	
				<tr>
					<td>${List.va_code}</td>
					<td>${List.vacation_applyDay}</td>	
					<td>${List.emp_code }</td>
					<td>${List.n_emp_name }</td>
					<td>${List.vacation_startDate }</td>
					<td>${List.vacation_endDate }</td>
					<td>${List.vcontent }</td>
					<td>${List.status }</td>
					<td>
						<select id = "vaOk" name = "vaStatus">
							<option value = "대기">상태변경</option>
							<option value = "승인">승인</option>
							<option value = "반려">반려</option>
						</select>
					<input type = "hidden" name = "va_code" value ="${List.va_code}" >
					</td>
				</tr>
				</c:forEach>	
			</table>
			<br>
				<input type = "submit" value = "수정하기" >	
			</div>
		</form>
	</div>	
</body>
</html>