
<%--
  Created by IntelliJ IDEA.
  User: 520
  Date: 2020/7/23
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
        <base href="<%=basePath%>">
    <title>用户注册表界面</title>
    <style>
        table{
            margin: auto;
        }
        #enheng{
            text-align: center;
        }
        div{
            text-align: center;
        }
        #kongzhi{
            margin: auto;
        }
    </style>
    <script src="js/jquery-3.4.1.js"></script>
    <script>
        function valid(_val){
            var flag=confirm("确定审核？")
            if(flag){
                $.ajax({
                    type:"post",
                    url:"docheck",
                    data:{"pid":_val},
                    success:function (data) {
                        if(data=="true"){
                            $("#"+_val).html("已审核");
                        }
                    }
                })
            }

        }
        <%--alert("${sessionScope.message}");--%>
    </script>
</head>
<body>
<%--<%--%>
<%--   Object msg=session.getAttribute("message");--%>
<%--%>--%>
<%--<c:if test="${sessionScope.message!=null}">--%>
<%--    <script type="text/javascript">--%>
<%--        alert("<%=msg %>");--%>
<%--        window.location.href="seeList";--%>
<%--    </script>--%>
<%--</c:if>--%>
<%--<%session.removeAttribute("message");%>--%>
<% Object msg=session.getAttribute("message");
    if(msg!=null&&!"".equals(msg)){
%>
<script type="text/javascript">
    alert("<%=msg%>");
    <%--alert("${sessionScope.message}");--%>
    // window.location.href="seeList";
</script>
<% }
    session.removeAttribute("message");%>

<form id="enheng" action="chaxunpersion" method="post">
    <table>
        <tr>
            <th>账户名：</th>
            <td><input type="text" name="pName" value="${sessionScope.selectdepersion.pName}" />
            </td>
            <th>电话：</th>
            <td><input type="text" name="pTel" value="${sessionScope.selectdepersion.pTel}" />
            </td>
        </tr>
        <tr>
            <th>地址：</th>
            <td><input type="text" name="pAddress" value="${sessionScope.selectdepersion.pAddress}"/>
            </td>
            <th>审核状态:</th>
            <td><select name="pCheck">
                <option value="全部" ${sessionScope.selectdepersion.pCheck.equals("全部")?"selected":"" }>全部</option>
                <option value="待审核" ${sessionScope.selectdepersion.pCheck.equals("待审核")?"selected":"" }>待审核</option>
                <option value="已审核" ${sessionScope.selectdepersion.pCheck.equals("已审核")?"selected":"" }>已审核</option>
            </select>
            </td>
        </tr>
        <tr id="kongzhi">
            <th colspan="2"><input type="submit" value="查询"/></th>
            <th colspan="2"><input type="reset" value="重置"></th>
        </tr>
    </table>
</form>
<table border="1px" cellspacing="0" >
    <tr>
        <th>头像(可更换)</th>
        <th>账户名</th>
        <th>密码(可修改)</th>
        <th>电话(可修改)</th>
        <th>地址(可修改)</th>
        <th>审核状态(点击审核)</th>
        <th>操作</th>
    </tr>
    <c:forEach var="p" items="${sessionScope.PersionList}">
        <form action="updatepersion?pid=${p.pId}" method="post" enctype="multipart/form-data">
    <tr>
        <td><input type="file" name="file" /><img src="img/${p.pPhoto}" width="40px" height="40px"/></td>
        <td><input type="text" name="pName" value="${p.pName}" readonly/></td>
        <td><input type="text" name="pPwd"  value="${p.pPwd}"/></td>
        <td><input type="text" name="pTel"  value="${p.pTel}"/></td>
        <td><input type="text" name="pAddress"  value="${p.pAddress}"/></td>
        <td><span id="${p.pId}" onclick="valid($(this).attr('id'))">${p.pCheck}</span></td>
        <td><input type="submit"   value="修改"/></td>
    </tr>
        </form>
    </c:forEach>
</table>
<div>
<c:if test="${sessionScope.selectdepersion==null}">
    <c:if test="${sessionScope.pageNow==1}">
        <form action="tiaozhuan" method="post">
            跳转到第<input type="text" name="page"/>页
            <input type="submit" value="跳转"/>
        </form>
        <a href="xiayiye?page=${sessionScope.pageNow}">下一页</a>
        <a href="weiye">尾页</a>
    </c:if>

    <c:if test="${sessionScope.pageNow==sessionScope.pageLarge}">
        <a href="shouye">首页</a>
        <a href="shangyiye?page=${sessionScope.pageNow}">上一页</a>
        <form action="tiaozhuan" method="post">
            跳转到第<input type="text" name="page"/>页
            <input type="submit" value="跳转"/>
        </form>
    </c:if>
    <c:if test="${sessionScope.pageNow>1&&sessionScope.pageNow<sessionScope.pageLarge}">
        <a href="shouye">首页</a>
        <a href="shangyiye?page=${sessionScope.pageNow}">上一页</a>
        <form action="tiaozhuan" method="post">
            跳转到第<input type="text" name="page"/>页
            <input type="submit" value="跳转"/>
        </form>
        <a href="xiayiye?page=${sessionScope.pageNow}">下一页</a>
        <a href="weiye">尾页</a>
    </c:if>
</c:if>

<c:if test="${sessionScope.selectdepersion!=null}">
    <c:if test="${sessionScope.pageLarge1==1}">

    </c:if>

    <c:if test="${sessionScope.pageLarge1>1}">
        <c:if test="${sessionScope.pageNow==1}">
            <form action="tiaozhuan" method="post">
                跳转到第<input type="text" name="page"/>页
                <input type="submit" value="跳转"/>
            </form>
            <a href="xiayiye?page=${sessionScope.pageNow}">下一页</a>
            <a href="weiye">尾页</a>
        </c:if>

        <c:if test="${sessionScope.pageNow==sessionScope.pageLarge1}">
            <a href="shouye">首页</a>
            <a href="shangyiye?page=${sessionScope.pageNow}">上一页</a>
            <form action="tiaozhuan" method="post">
                跳转到第<input type="text" name="page"/>页
                <input type="submit" value="跳转"/>
            </form>
        </c:if>
        <c:if test="${sessionScope.pageNow>1&&sessionScope.pageNow<sessionScope.pageLarge1}">
            <a href="shouye">首页</a>
            <a href="shangyiye?page=${sessionScope.pageNow}">上一页</a>
            <form action="tiaozhuan" method="post">
                跳转到第<input type="text" name="page"/>页
                <input type="submit" value="跳转"/>
            </form>
            <a href="xiayiye?page=${sessionScope.pageNow}">下一页</a>
            <a href="weiye">尾页</a>
        </c:if>
    </c:if>

</c:if>
</div>
</body>
</html>
