<%--
  Created by IntelliJ IDEA.
  User: wuhxm
  Date: 2022/5/6
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/login/lg" method="post">
        username:<input type="text" name="username" ><br/>
        pwd:<input type="password" name="pwd"><br/>
        ${loginMsg}<br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
