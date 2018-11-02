<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>reg.jsp</title>
</head>
<body>
<form action='<c:url value="reg.jsp" />' method="post">
    UserName : <input type="text" name="username"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit"/>
</form>
</body>
</html>