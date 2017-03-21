<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <jsp:include page="foreground/common/head.jsp"/>
    </div>
    <div class="row clearfix">
        <div class="col-md-3 column">
            <jsp:include page="foreground/blogger/bloggerMain.jsp"/>
            <jsp:include page="foreground/blogType/blogTypeMain.jsp"/>
        </div>
        <div class="col-md-9 column">
            <div class="data-list">
                <div class="title">
                    <i class="fa fa-list"></i>
                    <strong>文章列表</strong>
                </div>
                <!-- 文章列表块 -->
                <div class="article-list">
                    <c:forEach items="${blogList}" var="blog">
                        <div class="article-ever">
                            <h3 class="article-list-title">
                                ${blog.title}
                            </h3>
                            <p class="article-list-content">
                                ${blog.summary}
                            </p>
                            <div class="article-list-comment">
                                <span>${blog.releaseDateStr}&nbsp;&nbsp;&nbsp;</span>
                                <a href="#">阅读</a><span>(${blog.clickHit})&nbsp;</span>
                                <a href="#">评论</a><span>(${blog.replyHit})</span>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div>
                    <ul class="pagination">
                        <c:forEach var="i" begin="1" end="${pageNumber}" step="1">
                            <li class="pageList">
                                <a href="${pageContext.request.contextPath}/index.do?page=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="clea"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-3 column">
            <div class="data-list footer">
                <div class="title">
                    <i class="fa fa-link"></i>
                    <strong>友情链接</strong>
                </div>
                <div class="link">
                    <ul>
                        <c:forEach var="link" items="${linkList}">
                            <li><a href="${link.linkUrl}" target="_blank">${link.linkName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="static/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $('.pageList').eq(${page - 1}).addClass("active");
        console.log( $('.pageList').eq(${page}));
    });
</script>
</body>
</html>