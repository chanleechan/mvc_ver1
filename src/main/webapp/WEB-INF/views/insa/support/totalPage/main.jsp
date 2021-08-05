<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.container{
  width: 100%;
  height:100vh;
  background: white
}
.container .header{
  width: 80%;
  height: 80px;
  margin:0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.container .header .h1 a{
  text-decoration: none;
  color:black;
  font-family: "맑은 고딕";
}
.container .nav ul li{
  display: inline-block;
  margin: 0 10px;
}
.container .nav ul li a{
  text-decoration: none;
  color:black;
}
.container .nav ul li a:hover{
  color:1fdfdf;
}

.loginText {
 color: black;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
}

.input{
 font-size: px;
 text-shadow: 0 0 2px #666;
 color: black;
 margin: 0 auto;
 text-transform: capitalize;
 font-family: "맑은 고딕";
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
 margin-left:70px;
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

input[type="submit"] {
 float: left;
 /*  display:block; */
 height: 50px;
 text-shadow: 0 0 5px #666;
 text-transform: capitalize;
 color: #fff;
 border-radius: 5px;
 border: none;
 font-family: "맑은 고딕";
 margin: 0 auto;
 margin-left:30px;
 font-style: italic;
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
 margin-right:30px;
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
</head>
<body>
<div class = "container">
    <div class="header">
      <h1>인사 복지 시스템</h1>
      <div class = "nav">

      </div>
    </div>
<form action="http://localhost:8070/pugis/total/loginPro" method ="post" name="loginform">
  <div id="wrap">
   
   <div class="form">
   <div class = "clear"> </div>
  	 <h1 class="loginText">로그인</h1>
    <div class="form2">
     <div class="form3">
   
      <div class="input"><label for="id">아이디</label><input type="text" name="emp_id" ></div>
      <div class="clear"></div>
      <div class="input"><label for="passwd">비밀번호</label><input type="password" name="f_emp_pass"></div>
     </div>
     <input type="submit" value="로그인">
     <div class="clear"></div>
     <div class="form4">
      <div class="clear"></div>
      <label><input type="button" value="회원등록" onclick="location.href='http://localhost:8070/pugis/total/inputform'"></label> 
      <label><input type="reset" value="다시입력"></label>
     </div>
    </div>
   </div>
  </div>
 </form>
 </div>
</body>
</html> 