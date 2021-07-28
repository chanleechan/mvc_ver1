<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello JSP</title>
</head>
<body>
<table border="1">
<tr>
<th>사번</th>
<th>사원명</th>
<th>주민번호</th>
<th>이메일</th>
</tr>
<c:forEach var="searchResultItem" items="${searchResultList}">
<tr><!-- 첫번째 줄 시작 -->
<td>${searchResultItem.emp_id}</td>
<td>${searchResultItem.emp_name}</td>
<td>${searchResultItem.emp_no}</td>
<td>${searchResultItem.email}</td>
</tr><!-- 첫번째 줄 끝 -->
</c:forEach>

</table>  
</body>
</html>