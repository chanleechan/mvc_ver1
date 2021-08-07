<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel ="stylesheet" href = "<c:url value="/resources/css/table.css"/>"  rel = "stylesheet">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

function basketClose(){
	var params = $("#userinput").serialize();
	$.ajax(
	{
		url : 'http://localhost:8070/pugis/service/saveMenu',
		data : params,
		success : function(data)
					{
						alert("장바구니에 저장되었습니다. 확인해주세요.");
						window.close();
					}
	
	})
}
</script>

<title>장바구니2</title>

</head>
<body>
	<h1 class="member">장바구니</h1>
	<br>
	<div class="outer" align="center">
	<form method="get" action="/" name="userinput" id="userinput">
	<div id="tableArea" align="center">
		<table border="1" id="listArea">
			    <tr bgcolor="white" align ="center">
			    </tr>
				<tr align = "center" bgcolor="white">
					<td>품목</td>
					<td>포인트</td>
					<td>선택</td>
			   </tr>
			<c:forEach var="searchResultItem" items="${n_appList}"> 
		   <tbody id = "h_app_List">
				<tr align = "center" bgcolor="white">
					<td id = "h_app_name">${searchResultItem.h_app_name}
						<input type="hidden" name = "h_app_name" value = "${searchResultItem.h_app_name}">
					</td>
					<td id = "h_app_price">${searchResultItem.h_price}
						<input type="hidden" name = "h_app_price" value = "${searchResultItem.h_price}">
					</td>
					<td>
						<input  type='checkbox' name = "h_app_code" value = "${searchResultItem.h_app_code}">
					</td>
			    </tr>
		   </tbody>
			</c:forEach>
			<c:forEach var="searchResultItem" items="${b_List}"> 
		    <tbody id = "book_List">
			    <tr align = "center" bgcolor="white">
					<td id = "book_name">${searchResultItem.book_name}
					<input type = "hidden" name = "book_name" value = "${searchResultItem.book_name}">
					</td>
					<td id = "book_price">${searchResultItem.book_price}
					<input type = "hidden" name = "book_price" value = "${searchResultItem.book_price}">	
					</td>
					<td>
						<input  type='checkbox' name = "book_code" value = "${searchResultItem.book_code}">
					</td>
			    </tr>
		    </tbody>
			</c:forEach>
				<c:forEach var="searchResultItem" items="${b_appList}"> 
		    <tbody id = "b_app_List">
			    <tr align = "center" bgcolor="white">
					<td id = "b_app_name">${searchResultItem.b_app_name}
						<input type="hidden" name ="b_app_name" value = "${searchResultItem.b_app_name}">
					</td>
					<td id = "b_app_price">${searchResultItem.b_price}
						<input type="hidden" name ="b_price" value = "${searchResultItem.b_price}">
					</td>
					<td>
						<input  type='checkbox' name = "b_app_code" value = "${searchResultItem.b_app_code}">
					</td>
			    </tr>
		    </tbody>
				</c:forEach>
	    </table> 
	    
	<center><input type="button" value="담   기" onclick = "basketClose()">
	<input type="button" value = "뒤로가기" onclick = "location.href='http://localhost:8070/pugis/total/servicePage'">
	</center>
	</div>
	
	</form>
	</div>
	</body>
</html>