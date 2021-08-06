
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>

<!DOCTYPE html>

<html>
<% 

	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
	String strdate = simpleDate.format(date);

%>
<head>
<meta charset="UTF-8">
<title>휴가 신청</title>
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

th, td {
  font-size:11px;
  border: 1px solid #444444;
  padding:5px;
  background-color : skyblue;
}
td input{
  font-size:11px;
}
textarea{
  resize : none;
}
</style>
<script type="text/javascript">
function check(){
	alert("신청이 완료되었습니다.");
}
</script>
</head>
<body>
	<div class="outer">
		<br>
			<h3 class = "member">휴가 신청서</h3>
		<br>
		<div class="tableArea" align="center">
			<form class="form" action="http://localhost:8070/pugis/vacation/vInsert" name = "userinput" method="get" onsubmit="return check()">
				<table >
					<tr>
						<td>신청 날짜</td>
						<td><input type="text" name="vacation_code" value = "<%=strdate%>"></td>	
						<td>사번</td>	
						<td><input type="text" name="emp_code" value = "<%=session.getAttribute("emp_code")%>"></td>
						<td>성명</td>
						<td> 
						<input type="text" name="n_emp_name" value ="<%=session.getAttribute("emp_name")%>">
						</td>
					</tr>
					<tr>
						<td>시작일</td>
						<td><input type="date" name="vacation_startDate"></td>	
						<td>끝</td>
						<td><input type="date" name="vacation_endDate"></td>
						<td>상태</td>
						<td><input type="text" value="대기" readonly="readonly"></td>
					</tr>
					<tr>
						<td>휴가 사유</td>
						<td colspan="6"><textarea rows="10" cols="89" name = "vcontent"></textarea>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="reset" >취소</button>
					<button type="submit">신청</button>
				</div>
				
			</form>
			
		</div>
	</div>
</body>
</html>