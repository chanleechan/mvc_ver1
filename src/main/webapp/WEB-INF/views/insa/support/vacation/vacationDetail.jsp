<%-- <%@page import="com.vacation.model.vo.Vacation_work"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.pugis.insa.support.domain.*"%>
<%--
	Vacation_work vw = (Vacation_work)request.getAttribute("vacation_work");
--%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가 신청서 내용</title>
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
		<h2 align="center">휴가 신청서 내용</h2>
		<div class="tableArea" style="text-align: center;">
				<table border="1" style="text-align: center;">
					<tr>
						<td>신청 날짜</td>
						<td><fmt:formatDate value="${vacation.vacation_code }"/></td>
						<td>사번</td>
						<td>${vacationList.emp_code}</td>
						<td>성명</td>
						<td>${vacationList.n_emp_name}</td>
					</tr>
					<tr>
						<td>시작 일</td>
						<td>
							${vacationList.vacation_startDate}
						</td>
						<td>끝일</td>
						<td>${vacationList.vacation_endDate}</td>
						<td>상태</td>
						<td>${vacationList.status}</td>
					</tr>
					<tr>
						<td>휴가 사유</td>
					</tr>
					<tr>
						<td colspan="4"><br>
							<span>${vacationList.vcontent}</span>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					
					<button onclick="goHome()">메뉴로 돌아가기</button>
					<button onclick="location.href='vOk.va'">승인</button>
					<button onclick="location.href='vNo.va'">반려</button>
					

			<%--	<!--  	<% if( vw != null && vw.getEmp_code().equals("admin")) { %>
						<button onclick="location.href='nUpView.no?nno=<%=n.getNno()%>'">수정하기</button>
					<% } %>--> --%>
				</div>
		</div>
	</div>
	<script type="text/javascript">
		function goHome() {
			location.href="http://localhost:8090/zz/index.jsp";
		}
	</script>
</body>
</html>