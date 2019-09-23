<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>获取Session中的数据</h1>
<%
     final Enumeration<String> names = session.getAttributeNames();
     while (names.hasMoreElements()){
          final String name = names.nextElement();
          System.out.println(name);
          response.getWriter().println(name);
          System.out.println(session.getAttribute(name));
     }
%>
</body>
</html>
