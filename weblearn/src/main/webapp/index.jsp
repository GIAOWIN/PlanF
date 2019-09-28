<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<form action="/weblearn/servlet/PostServlet" method="post">
    账号:<input type="text" name="username"/>
    密码:<input type="text" name="passworld"/>
    <input type="submit" value="提交"/>
</form>
<a href="<c:url value='/servlet/GetServlet?username=账单'/>">点击去get</a>

${username}
${passworld}
<h2>Hello World!</h2>
</body>
</html>
