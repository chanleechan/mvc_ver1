<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>test page</title>
</head>
<body>
<table border="1">
<tr>
<th>장바구니번호</th>
<th>사번</th>
<th>사원명</th>
<th>수량</th>
<th>도서코드</th>
<th>업무기구코드</th>
<th>가전코드</th>
</tr>
<c:forEach var="searchResultItem" items="${searchResultList}">
<tr><!-- 첫번째 줄 시작 -->
<td>${searchResultItem.basket_seq}</td>
<td>${searchResultItem.emp_code}</td>
<td>${searchResultItem.emp_name}</td>
<td>${searchResultItem.h_app_amount}</td>
<td>${searchResultItem.book_code}</td>
<td>${searchResultItem.b_app_code}</td>
<td>${searchResultItem.h_app_code}</td>
</tr><!-- 첫번째 줄 끝 -->
</c:forEach>

</table>  
</body>
</html>