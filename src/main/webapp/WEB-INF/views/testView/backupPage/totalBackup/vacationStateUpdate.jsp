<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.pugis.insa.support.domain.Vacation_work"%>
<%
	Vacation_work vw = (Vacation_work)request.getAttribute("vacation_work");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가자 상태 변경</title>
<style type="text/css">
button {
	font-weight:bold;
	text-decoration:none;
	font-family:Arial;
	box-shadow:inset #ffffff 0px 5px 8px -1px;
	o-box-shadow:inset #ffffff 0px 5px 8px -1px;
	-moz-box-shadow:inset #ffffff 0px 5px 8px -1px;
	-webkit-box-shadow:inset #ffffff 0px 5px 8px -1px;
	background:#e4f1ff;
	background:-o-linear-gradient(90deg, #e4f1ff, #ffffff);
	background:-moz-linear-gradient( center top, #e4f1ff 5%, #ffffff 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e4f1ff), color-stop(1, #ffffff) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e4f1ff', endColorstr='#ffffff');
	background:-webkit-linear-gradient(#e4f1ff, #ffffff);
	background:-ms-linear-gradient(#e4f1ff, #ffffff);
	background:linear-gradient(#e4f1ff, #ffffff);
	text-indent:0px;
	line-height:10px;
	-moz-border-radius:14px;
	-webkit-border-radius:14px;
	border-radius:14px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:17px;
	color:#9ab5cd;
	width:84px;
	height:10px;
	padding:13px;
	border-color:#e3f1fd;
	border-width:1px;
	border-style:solid;
}

button:active {
	position:relative;
	top:5px
}

button:hover {
	background:#ffffff;
	background:-o-linear-gradient(90deg, #ffffff, #e4f1ff);
	background:-moz-linear-gradient( center top, #ffffff 5%, #e4f1ff 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #e4f1ff) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#e4f1ff');
	background:-webkit-linear-gradient(#ffffff, #e4f1ff);
	background:-ms-linear-gradient(#ffffff, #e4f1ff);
	background:linear-gradient(#ffffff, #e4f1ff);
}
 table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<body>
	<div class="outer">
		<br>
		<h2 align="center">공지 사항 수정</h2>
		<div class="tableArea">
			<form id="updateForm" action="vUpdate.va" method="post">
				<table>
					<tr>
						<td>신청 날짜</td>
						<td>
							<input type="text" name="date" value="<%= vw.getVacation_applyDay()%>" readonly>
						</td>
						<td>사번</td>
						<td>
							<input type="text" value="<%= vw.getEmp_code() %>" name="empCode" readonly>
						</td>
						<td>성명</td>
						<td>
							<input type="text" value="<%= vw.getN_emp_name() %>" name="writer" readonly>
						</td>
					</tr>
					<tr>
						<td>시작일</td>
						<td>
							<input type="date" value="<%= vw.getVacation_startDate() %>" name="startDate" readonly>
						</td>
						<td>끝일</td>
						<td><input type="date" name="date" value="<%=vw.getVacation_endDate() %>" readonly></td>
						<td>상태</td>
						<td colspan="6"><p>대기</p></td>
					</tr>
					<tr>
						<td>휴가 사유 </td>
					</tr>
					<tr>
						<td colspan="6">
							<textarea name="content" cols="10" rows="50" style="resize:none; text-align: center;" readonly="readonly"><%= vw.getVcontent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button onclick="complete();">작성</button>
					<button onclick="goHome();">취소</button>
				</div>
			</form>
			
		</div>
	</div>
	<script type="text/javascript">
		function complete() {
			$("updateForm").submit();
		}
		
		function goHome() {
			location.href = "http://localhost:8090/zz/index.jsp";
		}
	</script>
</body>
</html>