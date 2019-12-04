<%@ page import="com.yuan.domain.Person" %>
<%@ page import="com.yuan.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>添加user</h1>
<%
    final User user = new User();
    user.setId(01);
    user.setName("Yuan");
    session.setAttribute("session_user", user);
%>
</body>
</html>
