<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<form action="${pageContext.request.contextPath }/servlet/FileUploadServlet" method="post" enctype="multipart/form-data">
    文件名：<input type="file" name="file"/><br/>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
