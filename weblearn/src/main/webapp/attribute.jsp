<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>监听器测试</h1>
<%
    request.setAttribute("request_name", "request_value");
    session.setAttribute("session_name", "session_value");
    application.setAttribute("application_name", "application_value");
%>
</body>
</html>
