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
 height: 300px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}

.form2 {
 width: 500px;
 min-width: 320px;
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
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(document).ready(function(){
		if(('h_app_name').val() == null){
			$('h_app_List').empty();
		}else if(('b_app_name').val() == null){
			$('b_app_List').empty();
		}else if(('book_name').val() == null){
			$('book_List').empty();
		}
	});
});
<% %>

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니2</title>

</head>
<body>
<table align="center">
<tr><td>



<form method="post" action="inputPro.jsp" name="userinput" onSubmit="return checkIt()">
<div id="wrap">
   <h1 class="member">장바구니</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">
	<table border="1" bordercolor="white" width ="470" height="200" align = "center" >
    <tr bgcolor="white" align ="center">
    <td style="color:gray"><%=session.getAttribute("emp_id") %></td>
	<td colspan = "3"  style="color:gray">장바구니</td>
	
    </tr>
		<c:forEach var="searchResultItem" items="${sessionScope}"> 
				    <tr align = "center" bgcolor="white">
						<td  style="color:gray">품목</td>
						<td  style="color:gray">포인트</td>
						<td  style="color:gray">수량</td>
						<td  style="color:gray">결제</td>
				    </tr>
				    <tbody id = "h_app_List">
						<tr align = "center" bgcolor="white">
							<td id = "h_app_name" style="color:gray">${sessionScope.hname}
								<input type="hidden" name = "h_app_name" value = "${sessionScope.hname}">
							</td>
							<td id = "h_app_price" style="color:gray">${sessionScope.h_price}
								<input type="hidden" name = "h_app_price" value = "${sessionScope.hprice}">
							</td>
							<td>
								<input type = "text"  style="width:50px" id = "buyCount" value = "${sessionScope.hcode}">
							</td>
							<td>
								<input  type='checkbox' name = "payMenu" value = "">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
		<c:forEach var="searchResultItem2" items="${sessionScope}"> 
				    <tbody id = "b_app_List">
					    <tr align = "center" bgcolor="white">
							<td id = "b_app_name" style="color:gray">${sessionScope.b_app_name}
								
							</td>
							<td id = "b_app_price" style="color:gray">${sessionScope.b_price}
								
							</td>
							<td>
								<input type = "text"  style="width:50px" id = "buyCount" class = "buyCount">
							</td>
							<td>
								<input  type='checkbox' name = "payMenu" value = "">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
				<c:forEach var="searchResultItem3" items="${sessionScope}"> 
				    <tbody id = "book_List">
					    <tr align = "center" bgcolor="white">
							<td id = "book_name" style="color:gray">${sessionScope.book_name}
								
							</td>
							<td id = "book_price" style="color:gray">${sessionScope.book_price}
								
							</td>
							<td>
								<input type = "text"  style="width:50px" id = "buyCount" class = "buyCount">
							</td>
							<td>
								<input  type='checkbox' name = "payMenu" value = "">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
    </table> 
    
<center><input type="submit" value="저   장">
<input type="button" value="결   제">
<input type="button" value = "뒤로가기" onclick = "location.href='http://localhost:8070/pugis/service/login'">
</center>
</div>
</div>
</div>
</div>
</form>
</td></tr>
</table>
</body>
</html>