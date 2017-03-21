<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/25 0025
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <!-- 配置文件 -->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.js"></script>
    <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <style>
        .form-control{
            width:40%;
            display:inline;
            height:30px;
        }
        .container{
            margin-top:70px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-offset-2 col-md-8 column">
            <form class="form-horizontal" >
                <div class="form-group">
                    <span>博客标题：</span><input class="form-control"  type="text" id="title">
                </div>
                <div class="form-group">
                    <span>博客分类：</span>
                    <select class="form-control" id="blogType">
                        <option value="">请选择博客类别</option>
                        <c:forEach items="${BlogTypeList}" var="BlogType">
                            <option value="${BlogType.id}">${BlogType.typeName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <span>博客正文：</span><br/><br/>
                    <script id="myEidtor" name="content" type="text/plain">这里写你的初始化内容</script>
                </div>
                <div class="form-group">
                    <span>关键字：</span><br/><br/>
                    <input type="text" id="keyWord" class="form-control">
                </div>
                <div class="form-group" style="margin-right:18.8%">
                    <a href="javascript:submit()" class="btn-group" style="float:right">发布博文</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    var editor = new UE.ui.Editor({
        initialFrameWidth:'80%',
        initialFrameHeight:'300',
        toolbars:[['undo','redo','|','bold','italic','underline']],
        elementPathEnabled:false,
        wordCount:false
    });
    editor.render('myEidtor');
    editor.addListener("ready",function(){
       UE.ajax.request("${pageContext.request.contextPath}//admin/blog/findById.do",{
         method:"post",
         async:true,
         data:{"id":"${param.id}"},
         onsuccess:function(result){
            result = eval("(" + result.responseText + ")");
            $("#title").val(result.title);
            editor.setContent(result.content);
            $("#keyWord").val(result.keyWord);
            $("#blogType").val(result.blogType.id);
         }
       })
    });
    function submit(){
        var title = $('#title').val();
        var blogTypeId = $('#blogType').val();
        var content = UE.getEditor('myEidtor').getContent();
        var summary = UE.getEditor('myEidtor').getContentTxt().substr(0,155);
        var keyWord = $('#keyWord').val();
        var contentNoTag = UE.getEditor('myEidtor').getContentTxt();

        if(title == null || title == ''){
            $.messager.alert("系统提示","请输入标题");
        }
        else if(blogTypeId == null || blogTypeId == ''){
            $.messager.alert("系统提示","请选择博客分类");
        }
        else if(content == null || content == ''){
            $.messager.alert("系统提示","内容不能为空");
        }
        else{
            $.post("${pageContext.request.contextPath}/admin/blog/save.do",
                    {
                        'id':${param.id},
                        'title':title,
                        'blogType.id':blogTypeId,
                        'content':content,
                        'summary':summary,
                        'keyWord':keyWord,
                        'contentNoTag':contentNoTag
                    }, function (result) {
                        if(result.success){
                            $.messager.alert("系统提示","博客修改成功");
                        }
                        else{
                            $.messager.alert("系统提示","博客修改失败");
                        }
                    },"json");
        }
    }

</script>
</body>
</html>