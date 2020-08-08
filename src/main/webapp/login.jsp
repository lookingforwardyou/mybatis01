<%--
  Created by IntelliJ IDEA.
  User: 520
  Date: 2020/7/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录界面</title>
</head>
<body>
<div>
管理员登录：
<form action="login" method="post">
     账户：<input type="text" name="userName" /><br>
     密码：<input type="password"  name="userPwd"  /><br>
    <input type="submit" value="登录" />
</form>
</div>
<div>
    普通员工登录：
    <a href="reg">前往注册</a>
</div>
</body>
</html>
