<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
th, td {
  border-bottom: 1px solid #444444;
  padding: 10px;
  text-align: center;
  font-size:11px;
}
thead tr {
  background-color: #0d47a1;
  color: #ffffff;
}
tbody tr:nth-child(2n) {
  background-color: #bbdefb;
}
tbody tr:nth-child(2n+1) {
  background-color: #e3f2fd;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function basket(){
	var popWin = window.open('about:blank',"basketList","width=500,height=300");
	var frm = document.userinput;
	frm.action = "http://localhost:8070/pugis/service/basketList";
	frm.target = "basketList";
	frm.method = "get";
	frm.submit();
}
</script>

<title>상품 목록</title>

</head>
<body>
	<h2 class="member" align="center">상품 목록</h2>
	<br>
	<div class = "outer" align="center">
		<form method="get" action="/" id="userinput" name="userinput" >
			<div class="tableArea" align = "center">
				<table border="1" id="listArea">
			   		 <tr align = "center" bgcolor="white">
							<th>품목</th>
							<th>포인트</th>
							<th>남은수량</th>
							<th>담기</th>
					</tr>
			     	<c:forEach var="searchResultItem" items="${happList}"> 
					<tr>
						<td id = "h_app_name" style="color:gray">${searchResultItem.h_app_name}
						<input type="hidden" name = "h_app_name" value = "${searchResultItem.h_app_name}">
						</td>
						<td id = "h_app_price" style="color:gray">${searchResultItem.h_price}
						<input type="hidden" name = "h_app_price" value = "${searchResultItem.h_price}">
						</td>
						<td id = "h_app_amount" style="color:gray">${searchResultItem.h_amount}
						<input type="hidden" name = "h_app_amount" value = "${searchResultItem.h_amount}">
						</td>
						<td><input  type='checkbox' name = "h_appcheck" value = "${searchResultItem.h_app_code}">
						</td>
				    </tr>
					 </c:forEach>
					 <c:forEach var="searchResultItem" items="${bookList}"> 
				    <tr>
						<td  id = "b_app_name" style="color:gray">${searchResultItem.book_name}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.book_price}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.book_amount}</td>
						<td><input type='checkbox' name = "bookcheck" value = "${searchResultItem.book_code}"></td>
				    </tr>
					</c:forEach>
					<c:forEach var="searchResultItem" items="${bappList}"> 
			    	<tr>
						<td  id = "b_app_name" style="color:gray">${searchResultItem.b_app_name}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.b_price}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.b_amount}</td>
						<td><input  type='checkbox' name = "b_appcheck" value = "${searchResultItem.b_app_code}"></td>
				    </tr>
	    			</c:forEach>
			    </table>
			 </div>
		 	<input type="button" value="저   장" id = "selectBtn2" onclick ="basket()">
		 	
		</form>
	
	</div>
</body>
</html>