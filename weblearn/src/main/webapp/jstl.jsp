<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
<body>
<h1>JSTL</h1>
<c:out value="" default="" escapeXml=""/>
<c:set  value="" var="" scope="page"/>
<c:remove var="" scope="page"/>
<c:url value="/" var="" scope="session">
     <c:param name="" value=""/>
</c:url>
<c:if test="">

</c:if>


<c:forEach items="${strs }" var="str">
${str }<br/>
</c:forEach>



<fmt:formatDate value="" pattern="">

<%--value：指定一个Date类型的变量--%>

<%--pattern：用来指定输出的模板！例如：yyyy-MM-dd HH:mm:ss--%>

<fmt:formatNumber value="${num1}" pattern="0.00">

<%--保留小数点后2位，它会四舍五入！如果不足2位，以0补位！--%>

<fmt:formatNumber value="${num1}" pattern="#.##">

<%--保留小数点后2位，它会四舍五入！如果不足2位，不补位！--%>















</body>
</html>
