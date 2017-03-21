<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/24 0024
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <style type="text/css" rel="stylesheet">
        body{
            color:rgb(213, 214, 226);
            font-family: 微软雅黑,serif;
            background: rgb(73, 74, 95);
            margin:50px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal{
            background: #fff;
            padding-bottom: 20px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        .tp_denglu{
            border-bottom:1px solid #efefef;
            width:80%;
            text-align: center;
            margin:0 auto;
            margin-bottom:20px;
        }
    </style>
</head>
<body>
<c:if test="${not empty requestScope.errorInfo}">
    <script>
        alert('${requestScope.errorInfo}');
    </script>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-horizontal">
                <div class="row">
                    <div class="tp_denglu">
                        <h3>快速登录</h3>
                    </div>
                </div>
                <form class="form-horizontal" action="${pageContext.request.contextPath}/blogger/login.do" method="post" id="formPost">
                    <div class="form-group">
                        <input placeholder="用户名或电子邮件" id="username" type="text" name="username" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-default" id="login">登陆</button>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
</body>
    <script  type="text/javascript">
        $('#login').click(function(){
            var username = $('#username').val();
            var password = $('#password').val();
            if(username == "" || password == ""){
                alert("用户名密码不能为空");
                return false;
            }
            else{
                $('#formPost').submit();
                return true;
            }
        });
    </script>
</html>