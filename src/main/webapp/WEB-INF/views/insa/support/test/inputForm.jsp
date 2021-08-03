<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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
 margin: 80px auto;
 margin-left:130px;
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
 margin-right:50px;
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
	function checkIt(){
		var userinput=document.userinput;
		if(!userinput.emp_id.value){
			alert("아이디를 입력하십시오.");
			userinput.emp_id.focus();
			return false;
		}
		if(!userinput.f_emp_pass.value){
			alert("비밀번호를 입력하십시오.")
			userinput.f_emp_pass.focus();
			return false;
		}
		if(!userinput.emp_code.value){
			alert("사원번호를 입력하십시오.");
			userinput.emp_code.focus();
			return false;
		}
		return true;
	}
	//아이디 중복 판단
	function openConfirmid(userinput){
		if(!userinput.emp_id.value){
			alert("아이디를 입력하십시오.")
			userinput.emp_id.focus();
			return;
		}
		//userinput.emp_id.action = "http://localhost:8070/pugis/test/confirmId";
		url="http://localhost:8070/pugis/test/confirmId?emp_id="+userinput.emp_id.value;
		//url="http://localhost:8070/pugis/test/confirmId";
			
		window.open(url,"confirm_id","toolbar=no,location=no,status=no,menubar=no,scrllbar=no,resizable=no,width=300,height=200");
		}
</script>
</head>
<body>
<table align="center">
<tr><td>



<form method="get" action="http://localhost:8070/pugis/test/joinMember" name="userinput" onSubmit="return checkIt()">
<div id="wrap">
   <h1 class="member">복지등록</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">

<div class ="input">아이디 : &nbsp;&nbsp;&nbsp;<input type="text" name ="emp_id" size="10" maxlength="12">
    <input type="button" name="confirm_id" value="중복확인" onClick="openConfirmid(this.form)"><br/>
    <div class="clear"></div>
비밀번호 : <input type="password" name ="f_emp_pass" size="15" maxlength="12"><br/>
<div class="clear"></div>
		   <div class="clear"></div>
사원번호 : <input type="text" name ="emp_code" size="8" maxlength="8">
<div class="clear"></div>
<div class="clear"></div>
<input type="submit" value="등   록"  >
<input type="reset" value="다시 입력">
</div>
</div>
</div>
</div>
</div>
</form>
</td></tr>
</table>
</body>
</html>