<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>添加Cookie</h1>
<%
     Cookie username = new Cookie("username", "name");
     Cookie password = new Cookie("password", "pass");
     username.setMaxAge(-1);
     password.setMaxAge(0);
     response.addCookie(username);
     response.addCookie(password);
%>
</body>
</html>
