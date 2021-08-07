<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" href = "<c:url value="/resources/css/loginPage.css"/>"  rel = "stylesheet">
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
     <input type="submit" class = "btnSubmit" value="로그인">
     <div class="clear"></div>
     <div class="form4">
      <div class="clear"></div>
      <label><input type="button" class = "btn" value="회원등록" onclick="location.href='http://localhost:8070/pugis/total/inputform'"></label> 
      <label><input type="reset" class="btn" value="다시입력"></label>
     </div>
    </div>
   </div>
  </div>
 </form>
 </div>
</body>
</html> 