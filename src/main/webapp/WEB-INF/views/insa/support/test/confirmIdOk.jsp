<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.kh.pugis.insa.support.dao.MemberDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ID 중복확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<!--  -->
<%
	request.setCharacterEncoding("utf-8");
 
    String emp_id = request.getParameter("emp_id");

%>
<body>

<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center">
      <p>입력하신 <%=emp_id%> 는 사용하실 수 있는 ID입니다. </p>
      <input type="button" value="닫기" onclick="setid()">
    </td>
  </tr>
</table>

</body>

<script type="text/javascript">

  function setid()
    { 
        opener.document.userinput.emp_id.value= "<%=emp_id%>";
        self.close();
        }

</script>
</html>
