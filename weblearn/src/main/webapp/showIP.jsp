<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="y" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>显示IP</h1>
<h1>${applicationScope.ipMap }</h1>

<table border="1" align="center" width="60%">

    <tr>
        <th>IP地址</th>
        <th>次数</th>
    </tr>
    <c:forEach items="${applicationScope.ipMap }" var="entry">
    <tr>
        <td>${entry.key}</td><%--这里不知道为啥没显示出来--%>
        <td>${entry.value}</td><%--这里不知道为啥没显示出来--%>
    </tr>
    </c:forEach>
</table>
</body>
</html>
