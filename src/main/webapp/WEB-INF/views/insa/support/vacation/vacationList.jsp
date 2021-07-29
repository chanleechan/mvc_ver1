<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가 목록</title>
<style type="text/css">
  table {
    width: 100%;
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

<script type="text/javascript">
	function check(){
		
		var check = document.getElementById("vaOk");
		check = check.options[check.selectedIndex].value;	
			if( ckeck == "상태변경"){
				alert("상태를 확인해주세요.");
				return false;
			}else{
				return true;
			}
	
	}
	
	function goHome() {
			location.href="http://localhost:8070/pugis/vacation/header";
	}
</script>
</head>
<body>
	<div class="outer" align="center">
		<br>
		<h2 align="center">휴가 대기자 목록</h2>
		<form action ="http://localhost:8070/pugis/vacation/vaOk" method ="get">
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
							<option value = "상태변경">상태변경</option>
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
		<button onclick="goHome()">메뉴로 돌아가기</button>
	</div>	
</body>
</html>