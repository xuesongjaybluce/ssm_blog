<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/3 0003
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="data-list">
    <div class="title">
        <i class="fa fa-th-large"></i>
        <strong>文章分类</strong>
    </div>
    <ul>
        <c:forEach items="${BlogTypeList}" var="blogType">
            <li><a href="#">${blogType.typeName}</a></li>
        </c:forEach>
    </ul>
</div>
