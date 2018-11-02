<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="struts" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>SUCCESS</title>
		<struts:head/><%--声明使用Ajax主题--%>
	</head>
  	<body>
	成功接收struts响应，跳转到success.jsp
  	传递的参数为：
	<struts:property value="account"/>
	<struts:property value="password"/>
  </body>
</html>
