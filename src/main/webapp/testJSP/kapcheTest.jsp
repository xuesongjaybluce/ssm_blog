<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/8 0008
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="height:400px;margin:100px;">
        <label>验证码：</label>
        <input id="imageContent" name="imageCount" type="text" placeholder="验证码" maxlength="4" style="widht:71px;">
        <img src="${pageContext.request.contextPath}/captcha/getCaptchaImage.do" id="imgSrc">
        <input id="submit" type="submit" onclick="checkCaptche()">
    </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script>
    function checkCaptche(){
        var code = $("#imageContent").val();
        if(code.length != 0){
            $.post("${pageContext.request.contextPath}/captcha/captchaCheck.do",{code:code},function(result){
                if(result.success){
                    alert('验证成功');
                }else{
                    alert('错误');
                }
            },"json")
        }
    }
</script>
</html>
