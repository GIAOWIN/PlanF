<%@ page import="com.com.yuan.domain.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>添加person</h1>
<%
    final Person person = new Person();
    person.setId(01);
    person.setName("Yuan");
    session.setAttribute("session_name", person);
%>
</body>
</html>
