<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/3 0003
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="data-list">
    <div class="title">
        <i class="fa fa-camera-retro"></i>
        <strong>博主信息</strong>
    </div>
    <div class="img">
        <img alt="140x140" src="${pageContext.request.contextPath}/static/images/timg.jpg" class="img-circle"/>
    </div>
    <div class="data_name">
        <p>
            昵称：${blogger.nickname}
        </p>
        <p>
            ${blogger.sign}
        </p>
    </div>
</div>