<%--
  Created by IntelliJ IDEA.
  User: 520
  Date: 2020/7/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>主界面</title>
</head>
<body>
<a href="seeList">查看用户注册列表</a>
<a href="login/nihao">点击</a>
</body>
</html>
