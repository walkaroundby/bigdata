<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="struts" uri="/struts-tags" %>
<html>
<head>
    <title>登录页面</title>
    <struts:head theme="simple"/><%--设置为simple主题--%>
</head>
<body>
    <struts:form action="login">
        <struts:label value="登录系统"></struts:label><%--文字标签--%>
        <struts:textfield name="account" label="账号"/><%--文本输入框--%>
        <struts:password name="password" label="密码"/><%--密码输入--%>
        <struts:submit value="登录"></struts:submit><%--提交按钮--%>
    </struts:form>
</body>
</html>
