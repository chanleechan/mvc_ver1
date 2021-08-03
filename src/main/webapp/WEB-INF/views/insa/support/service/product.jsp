<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
.member {
 font-size: 50px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
}
.input{
 font-size: px;
 text-shadow: 0 0 2px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
}


body {
 font-family: "맑은 고딕";
 font-size: 12px;
}

.form {
 width: 498px;
 height: 600px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}

.form2 {
 width: 500px;
 min-width: 602px;
 height: 200px;
 margin: 20px auto;
 margin-left:10px;
}

.form3 {
float: left;
 /*   background:#f00;  */
}

#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
.clear {
 clear: both;
 margin-top:100px;
}

.form3 label {
 width: 100px;
 height: 20px;
 /*  display: block; */
 float: left;
}

.form4 {
 padding: 0px 0px 0px 70px;
}

#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
.clear {
 clear: both;
 margin-top:10px;
}

#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
.clear {
 clear: both;
 margin-top:10px;
}

input[type="submit"] {
 font-size: 15px;
 text-shadow: 0 0 5px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:30px;
 margin-left:10px;
}
input[type="button"] {
 font-size: 15px;
 text-shadow: 0 0 5px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:30px;
 margin-left:10px;
}

input[type="reset"] {
font-size: 15px;
 text-shadow: 0 0 5px #666;
 color: #fff;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
 margin-top:30px;
 margin-right:30px;
}
</style>
<script type="text/javascript">
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 목록</title>

</head>
<body>
<table align="center">
	<tr><td>
		<form method="post" action="http://localhost:8070/pugis/service/basketList" name="userinput" >
		<div id="wrap">
		   <h1 class="member">상품 목록</h1>
		   <div class="form">
		    <div class="form2">
		     <div class="form3">
			<table border="1" bordercolor="white" width ="470" height="200" align = "center" >
		   		 <tr bgcolor="white" align ="center">
					<td colspan = "3"  style="color:gray">일반가전 리스트</td>
		   		 </tr>
		   		 <tr align = "center" bgcolor="white">
						<td  style="color:gray">품목</td>
						<td  style="color:gray">포인트</td>
						<td  style="color:gray">남은수량</td>
						<td  style="color:gray">담기</td>
				</tr>
		     	<c:forEach var="searchResultItem" items="${happList}"> 
					<tr align = "center" bgcolor="white">
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
					    <tr align = "center" bgcolor="white">
						<td  id = "b_app_name" style="color:gray">${searchResultItem.book_name}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.book_price}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.book_amount}</td>
						<td><input type='checkbox' name = "bookcheck" value = "${searchResultItem.book_code}"></td>
				    </tr>
				</c:forEach>
				<c:forEach var="searchResultItem" items="${bappList}"> 
					    <tr align = "center" bgcolor="white">
						<td  id = "b_app_name" style="color:gray">${searchResultItem.b_app_name}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.b_price}</td>
						<td  id = "b_app_price" style="color:gray">${searchResultItem.b_amount}</td>
						<td><input  type='checkbox' name = "b_appcheck" value = "${searchResultItem.b_app_code}"></td>
				    </tr>
    			</c:forEach>
		    </table>
		<center><input type="submit" value="저   장" id = "selectBtn2"><input type="button" value = "뒤로가기" id = "selectBtn" onclick="location.href='http://localhost:8070/pugis/total/servicePage'"></center>
						</div>
					</div>
				</div>
			</div>
		</form>
	</td></tr>
</table> 
</body>
</html>