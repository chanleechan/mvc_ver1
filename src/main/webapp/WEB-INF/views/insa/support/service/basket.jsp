<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
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
	userinput.action="http://localhost:8070/pugis/service/deleteMenu"
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니2</title>

</head>
<body>
<h2 class="member">장바구니</h2>
<br>
<div class = "outer" align="center">
<form method="get" action="http://localhost:8070/pugis/service/pay" id = "userinput" name="userinput" >
	<div class="tableArea" align ="center">   
		<table border="1" id="listArea" >
	    			<tbody id = "category">
	     				<tr align = "center" bgcolor="white">
	     					<td>주문번호</td>
							<td>품목</td>
							<td>남은수량</td>
							<td>가격</td>
							<td>결제</td>
					    </tr>
					</tbody>
					<c:if test = "${empty happList && empty basketList && empty bappList}">
						<td colspan="5">장바구니가 비었습니다.</td>
					</c:if>
			<c:forEach var="searchResultItem" items="${happList}"> 
					    <tbody id = "h_app_List">
							<tr align = "center" bgcolor="white">
								<td id = "basket_seq" >${searchResultItem.basket_seq}</td>
								<td id = h_app_codeid >${searchResultItem.h_appliance.h_app_name}
									<input type="hidden" name = "h_app_code" value = "${searchResultItem.h_app_code}">
								</td>
									<td id = "h_app_amountid" >${searchResultItem.h_appliance.h_amount}
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
						    	<td id = "basket_seq" >${searchResultItem.basket_seq}</td>
								<td id = "book_codeid" >${searchResultItem.book.book_name}
								<input type = "hidden" name = "book_code" value = "${searchResultItem.book_code}">
								</td>
								<td id = "book_amountid" >${searchResultItem.book.book_amount}
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
						    	<td id = "basket_seq" >${searchResultItem.basket_seq}</td>
								<td id = "b_app_codeid" >${searchResultItem.b_appliance.b_app_name}
									<input type="hidden" name ="b_app_code" value = "${searchResultItem.b_app_code}">
								</td>
								<td id = "b_app_amountid" >${searchResultItem.b_appliance.b_amount}
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
<input class = "moneycheck" type ="button" value = "금액 확인" onclick = "paycheck()">
<input type="submit" value="결   제" onclick="return checkIt()">
<input type ="submit"  value = "삭제" onclick = "deleteMenu()">
</center>
</div>
</form>
</div>
</body>
</html>