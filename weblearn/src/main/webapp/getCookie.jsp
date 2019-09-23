<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>获取Cookie</h1>
<%
     Cookie[] cookies = request.getCookies();
     for (Cookie cookie : cookies) {
          response.getWriter().println("</br>");
          response.getWriter().println(cookie.getName()+"============================="+cookie.getValue());
          System.out.println(cookie.getName()+"============================="+cookie.getValue());
     }
%>
</body>
</html>
