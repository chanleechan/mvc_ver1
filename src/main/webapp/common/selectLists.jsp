<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가자 직원 상태 조회</title>
<style>
div	{
	text-align: center;
}
.btn1 {
	font-weight:bold;
	text-decoration:none;
	font-family:Arial;
	box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	o-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	-moz-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	-webkit-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 3px 2px;
	background:#ffffff;
	background:-o-linear-gradient(90deg, #ffffff, #7ea5d9);
	background:-moz-linear-gradient( center top, #ffffff 5%, #7ea5d9 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #7ea5d9) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#7ea5d9');
	background:-webkit-linear-gradient(#ffffff, #7ea5d9);
	background:-ms-linear-gradient(#ffffff, #7ea5d9);
	background:linear-gradient(#ffffff, #7ea5d9);
	text-indent:0px;
	line-height:110px;
	-moz-border-radius:94px;
	-webkit-border-radius:94px;
	border-radius:94px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:18px;
	color:#ffffff;
	width:112px;
	height:112px;
	padding:30px;
	text-shadow:#73a7ba -1px -1px 0px;
	border-color:#ebeab7;
	border-width:7px;
	border-style:solid;
}

.btn1:active {
	box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	o-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	-moz-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	-webkit-box-shadow:inset #5e9ed6 0px 5px 18px 6px,#d6d6d6 1px 0 2px;
	position:relative;
	top:3px
}

.btn1:hover {
	background:#7ea5d9;
	background:-o-linear-gradient(90deg, #7ea5d9, #ffffff);
	background:-moz-linear-gradient( center top, #7ea5d9 5%, #ffffff 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #7ea5d9), color-stop(1, #ffffff) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7ea5d9', endColorstr='#ffffff');
	background:-webkit-linear-gradient(#7ea5d9, #ffffff);
	background:-ms-linear-gradient(#7ea5d9, #ffffff);
	background:linear-gradient(#7ea5d9, #ffffff);
}

</style>
</head>
<body>
	<div id="btn_group">
		<a href='http://localhost:8090/zz/views/vacation/vacationList.jsp' class='btn1'>휴가 현황</a>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='workerList.w' class='btn1'>출/퇴근 현황</a>	
	</div>
</body>
</html>