<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
	<form action="update" method="POST">
		<table border=1>
			<tr>
				<td>사번</td>
				<td><input type="text" name="bno" readonly
					value="${employee.emp_code }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" value="${employee.emp_name }"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="text" name="title" value="${employee.emp_gender }"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><textarea rows="7" cols="50" name="content">${employee.emp_phone }</textarea></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value="저장">
					<input type="reset" value="수정"> <input type="reset"
					value="삭제" onclick="location.href='delete?employee=${employee}'">
					<input type="reset" value="목록보기" onclick="location.href='list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

