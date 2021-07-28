<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<style>
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
</head>
<form action="http://localhost:8070/pugis/service/loginPro" method ="get" name="loginform">
  <div id="wrap">
   <h1 class="member">로그인</h1>
   <div class="form">
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
      <label><input type="button" value="복지등록" onclick="location.href='http://localhost:8070/pugis/service/inputform'"></label> 
      <label><input type="reset" value="다시입력"></label>
     </div>
    </div>
   </div>
  </div>
 </form>
</body>
</html> 