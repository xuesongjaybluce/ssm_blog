<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/Icon.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <jsp:include page="../common/head.jsp"/>
    </div>
    <div class="row clearfix">
        <div class="col-md-3 column">
            <jsp:include page="../blogger/bloggerMain.jsp"/>
            <jsp:include page="../blogType/blogTypeMain.jsp"/>
        </div>
        <div class="col-md-9 column" style="margin-bottom:100px;">
            <div class="data-list">
                <div class="title">
                    <i class="fa fa-list"></i>
                    <strong>查询结果</strong>
                </div>
                <div class="article-list">
                    <c:choose>
                        <c:when test="${blogList.size() == 0}">
                            <div align="center" style="padding-top:20px">未查询到结果，请换个关键字试试>_<</div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${blogList }" var="blog">
                                <li style="margin-bottom: 20px">
						  	<span class="title">
						  		<a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html" target="_blank">${blog.title }</a></span>
                                    <span class="summary">摘要: ${blog.content }...</span>
                                    <span class="link"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html">${pageContext.request.contextPath}/blog/articles/${blog.id }.html</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;修改日期：${blog.releaseDateStr }</span>
                                </li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
</body>
</html>