<%--
  Created by IntelliJ IDEA.
  User: 520
  Date: 2020/7/23
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<html>
<head>
<%--    <base href="<%=basePath%>">--%>
    <title>注册界面</title>
    <style>
        .red{
            color: red;
        }
    </style>
    <script src="js/jquery-3.4.1.js"></script>
    <script>
        $(function(){
            $("#first").change(function(){
                var uname=$("#first").val();
                $.ajax({
                    type:"post",
                    url:"doajax",
                    data:{"userName":uname},
                    success:function(data){
                        if(data=="true"){
                            $("#biaozhi").html("");
                            $("#biaozhi").removeClass("red")
                        }else if(data=="false"){
                            $("#biaozhi").html("该账户已被使用");
                            $("#biaozhi").addClass("red");
                        }
                    }
                })
            })

            $("#three").blur(function () {
                if($(this).val()!=$("#second").val()){
                    // alert("您两次输入的密码不一致");
                    $("#biaozhi1").html("您两次输入的密码不一致");
                    $("#biaozhi1").addClass("red");
                }else{
                    $("#biaozhi1").html("");
                    $("#biaozhi1").removeClass("red");
                }
            })

            $("#four").blur(function () {
                var tel=$("#four").val();
                var test=/1[35678][0-9]{9}/;
                if(test.exec(tel)){
                    $("#biaozhi2").html("");
                    $("#biaozhi2").removeClass("red");
                }else{
                    $("#biaozhi2").html("您输入的电话号码格式有误");
                    $("#biaozhi2").addClass("red");
                }
            })
        })

    </script>
</head>
<body>
<form action="doreg" method="post" enctype="multipart/form-data">
    <table>
    <tr>
        <th>账户名</th>
        <td><input id="first" type="text" name="pName"/><span id="biaozhi"></span></td>
    </tr>
    <tr>
        <th>密码</th>
        <td><input id="second" type="password" name="pPwd" /></td>
    </tr>
    <tr>
        <th>确认密码</th>
        <td><input id="three" type="password" name="" /><span id="biaozhi1"></span></td>
    </tr>
    <tr>
        <th>手机号码</th>
        <td><input id="four" type="text" name="pTel" /><span id="biaozhi2"></span></td>
    </tr>
    <tr>
        <th>地址</th>
        <td><input type="text" name="pAddress" /></td>
    </tr>
    <tr>
        <th>上传头像</th>
        <td><input type="file" name="file" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="提交" /></td>
    </tr>
    </table>
</form>
</body>
</html>
