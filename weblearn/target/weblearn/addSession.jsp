<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>向Session中保存数据</h1>
<%
      session.setAttribute("username","user");
      session.setAttribute("password","pass");
%>
</body>
</html>
