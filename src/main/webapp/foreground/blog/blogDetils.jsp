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
                    <i class="fa fa-bars"></i>
                    <strong>文章信息</strong>
                </div>
                <div class="blog_title">
                    <h2>
                        <strong>${blog.title}</strong>
                    </h2>
                </div>
                <div class="blog_info">
                    <div style="float:left">
                        <strong>标签：</strong>
                        <c:choose>
                            <c:when test="${keyWords} == null">
                                &nbsp;&nbsp;无
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${keyWords}" var="keyWord">
                                    <a href="#">${keyWord}&nbsp;</a>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div style="float:right;">
                        发布于：『
                            ${blog.releaseDateStr}
                        』&nbsp;&nbsp; 博客类别：<a
                            href="${pageContext.request.contextPath}/index.html?typeId=${blog.blogType.id }">${blog.blogType.typeName }</a>&nbsp;&nbsp;
                        阅读(${blog.clickHit })&nbsp;&nbsp; 评论(${blog.replyHit })
                    </div>
                    <br><br>
                    <div class="xian" style="clear:both; margin:0 auto; border-top:1px solid #ddd"></div>
                    <div style="line-height:3; background-color: #F8F8FF">
                        <font style="color:#8B2323">作者：Garry&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尊重博主原创文章，转载请注明文章出于此处。</font>
                    </div>
                    <div class="xian" style="margin:0px auto; border-top:1px solid #ddd"></div>
                    <div class="blog_content">${blog.content }</div>
                    <div class="xian" style="margin:0 auto; border-top:1px solid #ddd"></div>
                    <div style="margin-top: 25px;">${pageCode }</div>
                </div>
            </div>
            <div class="data-list">
                <div class="title">
                    <i class="icon-comment_icon"></i>
                    <strong>评论列表</strong>
                </div>
                <div class="commentDatas">
                    <ul>
                        <c:choose>
                            <c:when test="${commentList.size() == 0}">
                                暂无评论
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${commentList}" var="comment" varStatus="status">
                                    <c:choose>
                                        <c:when test="${status.index<10 }">
                                            <div class="comment">
                                            <span>
											${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }
										<br>&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }<br>&nbsp;&nbsp;&nbsp;&nbsp;
										<span style="float:right">[${comment.commentDateStr }]</span> </span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="otherComment">
                                            <span>
											${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }
										<br>&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }<br>&nbsp;&nbsp;&nbsp;&nbsp;
										<span style="float:right">[${comment.commentDateStr }]</span> </span>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
                <div class="data-list">
                    <div class="title">
                        <i class="fa fa-comment"></i>
                        <strong>发表评论</strong>
                    </div>
                    <div class="publish_comment">
                        <div>
			                <textarea style="width: 100%" rows="3" id="content" name="content" placeholder="来说两句吧..."></textarea>
                        </div>
                        <div class="verCode">
                            验证码：<input type="text" value="" name="imageCode" id="imageCode"
                                       size="10" onkeydown="if(event.keyCode==13)form1.submit()" />&nbsp;
                            <img onclick="javascript:loadimage();" title="换一张试试" name="randImage"
                                 id="randImage" src="${pageContext.request.contextPath}/captcha/getCaptchaImage.do"border="1" align="absmiddle">
                        </div>
                        <div class="publishButton">
                            <button class="btn btn-primary" type="button" onclick="checkCaptche()">发表评论</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script>
    function loadimage(){
        var imgSrc = $('#randImage');
        var src = imgSrc.attr("src");
        imgSrc.attr("src",chgUrl(src));
    }
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        var stamp = $("#timestamp");
//    alert(url);
        url = url.substring(0, 60);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
            stamp.val(timestamp);
        }
        return url;
    };
    function checkCaptche(){
        var code = $("#imageCode").val();
        if(code.length != 0){
            $.post("${pageContext.request.contextPath}/captcha/captchaCheck.do",{code:code},function(result){
                if(result.success){
                    submitData();
                }else{
                    alert('验证码输入错误');
                }
            },"json")
        }
    }
    function submitData(){
        var content = $('#content').val();
        if(content == null || content == ''){
            alert("请输入评论内容");
        }else{
            $.post("${pageContext.request.contextPath}/Comment/addComment.do",{
                blog_id:${blog.id},
                commentStr:content
            },function (result) {
                if(result.success){
                    alert("评论成功，审核后将输入评论区内");
                    window.location.reload();
                }else{
                    alert("评论失败");
                }
            },"json");
        }
    }
</script>
</body>
</html>