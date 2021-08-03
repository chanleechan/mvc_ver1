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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(document).ready(function(){
		if(('h_app_code').val() == null && ('b_app_code').val() == null && ('book_code').val() == null){
			$('h_app_List').empty();
			$('b_app_List').empty();
			$('book_List').empty();
			alert("장바구니가 비어있습니다.");
		}
	
	});
});
function paycheck(){
	var payStr = 0;
	var pay = parseInt(payStr);
	var mypoint = <%=session.getAttribute("f_service_point") %>;
	for(i = 0; i < document.getElementsByName('h_appcheck').length; i++){
		if(document.getElementsByName('h_appcheck')[i].checked == true){
			pay = pay + parseInt(document.getElementsByName('h_app_priceH')[i].value);

		}
	}
	document.getElementById('choice_pay').innerText = pay;
	
	for(i = 0; i < document.getElementsByName('b_appcheck').length; i++){
		if(document.getElementsByName('b_appcheck')[i].checked == true){
			pay = pay + parseInt(document.getElementsByName('b_app_priceH')[i].value);
		}
	}
	document.getElementById('choice_pay').innerText = pay;
	
	for(i = 0; i < document.getElementsByName('bookcheck').length; i++){
		if(document.getElementsByName('bookcheck')[i].checked == true){
			pay = pay + parseInt(document.getElementsByName('book_priceH')[i].value);
		}
	}
	var innert = 0;
	document.getElementById('choice_pay').innerText = pay;
	document.getElementById('total_pay').innerText = mypoint - pay;
}

function checkIt(){
	var payStr = 0;
	var pay = parseInt(payStr);
	var mypoint = <%=session.getAttribute("f_service_point") %>;
	var subpoint= (pay - mypoint) ; 
	pay = document.getElementById('choice_pay').innerText;
	
	
	
	if(pay == 0){
		alert("금액 확인 먼저 해주세요.");
		return false;
	}
	if(pay > mypoint){
		alert("보유하신 포인트가 부족합니다. 상품을 확인해 주세요.");
		return false;
	}
	if(pay<mypoint){
		alert("정상적으로 결제되었습니다.");
		return true;
	}
}

function deleteMenu(){
	alert("장바구니에서 삭제하였습니다.");
	userinput.action="http://localhost:8070/pugis/test/deleteMenu"
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니2</title>

</head>
<body>
<table align="center">
<tr><td>



<form method="get" action="http://localhost:8070/pugis/service/pay" id = "userinput" name="userinput" >
<div id="wrap">
   <h1 class="member">장바구니</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">
	<table border="1" bordercolor="white" width ="470" height="200" align = "center" >
    <tr bgcolor="white" align ="center">
    <td style="color:gray" align="right"><%=session.getAttribute("emp_id") %> </td>
	<td colspan = "2"  style="color:gray">님이 선택한 장바구니 목록입니다.</td>
	<td style="color:gray" >보유 포인트 : <%=session.getAttribute("f_service_point") %></td>
    </tr>	
    			<tbody id = "category">
     				<tr align = "center" bgcolor="white">
     					<td  style="color:gray">주문번호</td>
						<td  style="color:gray">품목</td>
						<td  style="color:gray">남은수량</td>
						<td  style="color:gray">가격</td>
						<td  style="color:gray">결제</td>
				    </tr>
				</tbody>
		<c:forEach var="searchResultItem" items="${happList}"> 
				    <tbody id = "h_app_List">
						<tr align = "center" bgcolor="white">
							<td id = "basket_seq" style="color:gray">${searchResultItem.basket_seq}</td>
							<td id = h_app_codeid style="color:gray">${searchResultItem.h_appliance.h_app_name}
								<input type="hidden" name = "h_app_code" value = "${searchResultItem.h_app_code}">
							</td>
								<td id = "h_app_amountid" style="color:gray">${searchResultItem.h_appliance.h_amount}
								<input type="hidden" name = "h_app_amount" value = "${searchResultItem.h_appliance.h_amount}">
							</td>
							<td id = "h_app_price" >${searchResultItem.h_appliance.h_price}
							<input type = "hidden" name = "h_app_priceH" value = "${searchResultItem.h_appliance.h_price}">
							</td>
							<td>
								<input  type='checkbox' id = "h_appcheck" name = "h_appcheck" value = "${searchResultItem.basket_seq}">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
		<c:forEach var="searchResultItem" items="${basketList}"> 
				    <tbody id = "book_List">
					    <tr align = "center" bgcolor="white">
					    	<td id = "basket_seq" style="color:gray">${searchResultItem.basket_seq}</td>
							<td id = "book_codeid" style="color:gray">${searchResultItem.book.book_name}
							<input type = "hidden" name = "book_code" value = "${searchResultItem.book_code}">
							</td>
							<td id = "book_amountid" style="color:gray">${searchResultItem.book.book_amount}
							<input type = "hidden" name = "book_amount" value = "${searchResultItem.book.book_amount}">	
							</td>
							<td id = "book_price">${searchResultItem.book.book_price}
							<input type="hidden" name="book_priceH" value = "${searchResultItem.book.book_price}">
							</td>
							<td>
								<input  type='checkbox' name = "bookcheck" value = "${searchResultItem.basket_seq}">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
		<c:forEach var="searchResultItem" items="${bappList}"> 
				    <tbody id = "b_app_List">
					    <tr align = "center" bgcolor="white">
					    	<td id = "basket_seq" style="color:gray">${searchResultItem.basket_seq}</td>
							<td id = "b_app_codeid" style="color:gray">${searchResultItem.b_appliance.b_app_name}
								<input type="hidden" name ="b_app_code" value = "${searchResultItem.b_app_code}">
							</td>
							<td id = "b_app_amountid" style="color:gray">${searchResultItem.b_appliance.b_amount}
								<input type="hidden" name ="b_price" value = "${searchResultItem.b_appliance.b_amount}">
							</td>
							<td id = "b_app_price">${searchResultItem.b_appliance.b_price}
							<input type = "hidden" name = "b_app_priceH" value = "${searchResultItem.b_appliance.b_price}">
							</td>
							<td>
								<input  type='checkbox' name = "b_appcheck" value = "${searchResultItem.basket_seq}">
							</td>
					    </tr>
				    </tbody>
		</c:forEach>
    </table>

<div style="color:gray">보유하신 포인트 : <%=session.getAttribute("f_service_point")%></div>
<div style="color:gray">선택하신 포인트 </div>
<div  style="color:gray" id = "choice_pay">0</div>
<div style="color:gray">남은 포인트</div>
<div style="color:gray" id = "total_pay"><%=session.getAttribute("f_service_point")%></div>

<center>
<input type ="button" value = "금액 확인" onclick = "paycheck()">
<input type="submit" value="결   제" onclick="return checkIt()">
<input type ="submit"  value = "삭제" onclick = "deleteMenu()">
<input type="button" value = "뒤로가기" onclick = "location.href='http://localhost:8070/pugis/total/servicePage'">
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