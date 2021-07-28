<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function book(){
	location.href = "http://localhost:8070/pugis/service/bookList";
	
}

function h_appliance(){
	location.href = "http://localhost:8070/pugis/service/happList";
}

function b_appliance(){
	location.href = "http://localhost:8070/pugis/service/bappList";
}

</script>

<title>복지 포인트 사용 페이지</title>
</head>
<header>
	<h1>복지 포인트 사용 페이지</h1>
</header>
<body>
	<input type = "button" value = "업무기구" onclick = "b_appliance()">
	<input type = "button" value = "도서" onclick = "book()">
	<input type = "button" value = "일반 가전" onclick = "h_appliance()">
	<input type = "button" value = "장바구니">




</body>
</html>