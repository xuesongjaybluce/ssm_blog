<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/21 0021
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/Icon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/editor.md-master/css/editormd.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/editor.md-master/src/editormd.js"></script>
    <style rel="stylesheet">
        .blog_information .form-horizontal .form-group{
            margin:50px 0;

        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-3 column" style="height:100%">
                <div class="data-list">
                    <div class="title">
                        <i class="fa fa-navicon"></i>
                        <strong>博客信息</strong>
                    </div>
                    <div class="blog_information">
                        <form class="form-horizontal" >
                            <div class="form-group">
                                <span>博客标题：</span>
                                <input class="form-control"  type="text" id="title">
                            </div>
                            <div class="form-group">
                                <span>博客分类：</span>
                                <select class="form-control" id="blogType">
                                    <option value="">请选择博客类别</option>
                                        <option value="hhhh">hhhh</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <span>关键字（空格键分隔）：</span>
                                <input type="text" id="keyWord" class="form-control">
                            </div>
                            <div class="form-group">
                                <button class="btn btn-danger" style="float:right">发布博文</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9 column">
                <div class="data-list">
                    <div class="title">
                        <i class="fa fa-edit"></i>
                        <strong>博客正文</strong>
                    </div>
                    <div class="editormd" id="test-editormd">
                        <textarea class="editormd-markdown-textarea" name="ditormd-markdown-doc"></textarea>
                        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                        <textarea class="editormd-html-textarea" name="text"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $(function() {
            editormd("test-editormd", {
                width   : "100%",
                height  : 640,
                syncScrolling : "single",
                path    : "${pageContext.request.contextPath}/static/editor.md-master/lib/",
                //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                saveHTMLToTextarea : true
            });
        });
    </script>
</body>
</html>
