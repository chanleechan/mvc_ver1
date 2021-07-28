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
<!--  -->
<script type="text/javascript">

$(document).ready(function(){ 
	$("#selectBtn").click(function(){

		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name = appcheck]:checked");
		
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			rowData.push(tr.text());
			
			var h_app_name = td.eq(0).text();
			var h_app_price = td.eq(1).text();
			var h_app_amount = td.eq(2).text();
			
			
		<!--	var amount = td.eq(3).text();-->
		<!--	var amount = td:eq(4).input[type="text"].val();--> 
			
			tdArr.push(h_app_name);
			tdArr.push(h_app_price);
			tdArr.push(h_app_amount); 
		<%String h_app_name = "";%>
		<!--	tdArr.push(amount);-->
		});
		$("#ex3_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
		$("#ex3_Result2").html(tdArr);	
	});
});	

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반가전 리스트</title>

</head>
<body>
<table align="center">
	<tr><td>
		<form method="get" action="http://localhost:8070/pugis/service/basketList" name="userinput" onSubmit="return checkIt()">
		<div id="wrap">
		   <h1 class="member">일반가전 리스트</h1>
		   <div class="form">
		    <div class="form2">
		     <div class="form3">
			<table border="1" bordercolor="white" width ="470" height="200" align = "center" >
		   		 <tr bgcolor="white" align ="center">
					<td colspan = "3"  style="color:gray">일반가전 리스트</td>
		   		 </tr>
		     	<c:forEach var="searchResultItem" items="${searchResultList}"> 
				    <tr align = "center" bgcolor="white">
						<td  style="color:gray">품목</td>
						<td  style="color:gray">포인트</td>
						<td  style="color:gray">남은수량</td>
						<td  style="color:gray">수량</td>
						<td  style="color:gray">담기</td>
				    </tr>
				    
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
						<td><input type = "text"  style="width:50px" id = "buyCount" class = "buyCount"></td>
						<td><input  type='checkbox' name = "h_appcheck" value = "${searchResultItem.h_app_name}">
						<!--  	<input type ="hidden" name ="h_app_name" value = "${searchResultItem.h_app_name}" />-->
						</td>
				    </tr>
				</c:forEach>
		    </table>
		<center><input type="submit" value="저   장" id = "selectBtn2"></center>
						</div>
					</div>
				</div>
			</div>
		</form>
	</td></tr>
</table> 
<div class="col-lg-12" id="ex3_Result1" ></div> 
		<div class="col-lg-12" id="ex3_Result2" ></div> 
</body>
</html>