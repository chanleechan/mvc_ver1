<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function checkValue(){
	if(document.h_appbasket.b_app_amount.value < document.h_appbasket.buyCount.value){
		alert("재고가 부족합니다.");
		return false;
	}
}
</script>
<title>일반가전 품목 페이지</title>
</head>
<body>
<form action = "http://localhost:8070/pugis/service2/basketAdd2" name = "b_appbasket" method = "get" onsubmit = "return checkValue()">
	<table border="1">
		<tr>
			<th>품목</th>
			<th>포인트</th>
			<th>남은 수량</th>
			<th>수량</th>
			<th>담기</th>
		</tr>
		<c:forEach var="searchResultItem" items="${searchResultList}">
			<tr><!-- 첫번째 줄 시작 -->
				<td id = "b_app_name">${searchResultItem.b_app_name}</td>
				<td id = "b_app_price">${searchResultItem.b_price}</td>
				<td id = "b_app_amount">${searchResultItem.b_price}</td>
				<td><input type = "text"  style="width:50px" id = "buyCount"></td>
				<td><input type="checkbox" name = "h_appcheck"></td>
			</tr><!-- 첫번째 줄 끝 -->
		</c:forEach>
	</table> 
	<input type ="submit" value ="저장하기" > 
</form>

</body>
</html>