<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/23 0023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/easyloader.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Icon.css">
    <style rel="stylesheet" type="text/css">
        .main_title{
            text-indent: 1em;
        }
        .panel{
            margin:0;
        }
        .panel-title{
            font-size: 12px;
        }
    </style>
    <script>
        function openTab(text,url,iconCls){
            if($("#tabs").tabs("exists",text)){
                $("#tabs").tabs("select",text);
            }else{
                var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>'";
                $("#tabs").tabs("add",{
                    title:text,
                    iconCls:iconCls,
                    closable:true,
                    content:content
                });

            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div region="north" split="false" style="background:#EBF3FF;height:100px;overflow: hidden;">
        <h3 class="main_title">博客后台系统</h3>
        <p>欢迎：。。。</p>
    </div>
    <div region="west" title="导航菜单" style="width:150px;padding:0;overflow: hidden;">
        <div class="easyui-accordion" style="width:150px;">
            <div title="常用操作" iconCls="icon-2012080404391" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('写博客','${pageContext.request.contextPath}/admin/writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" plain="true" iconCls="icon-writeblog"  style="width: 150px">写博客</a>
                <a href="javascript:openTab('评论审核','../index.html','icon-review')" class="easyui-linkbutton" plain="true" iconCls="icon-review"  style="width: 150px">评论审核</a>
            </div>
            <div title="博客管理" iconCls="icon-blog" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('写博客','${pageContext.request.contextPath}/admin/writeBlog.jsp','icon-writeblog')','icon-writeblog')" class="easyui-linkbutton" plain="true" iconCls="icon-writeblog" style="width: 150px">写博客</a>
                <a href="javascript:openTab('博客信息管理','../index.html','icon-bkgl')" class="easyui-linkbutton" plain="true" iconCls="icon-bkgl"  style="width: 150px">博客信息管理</a>
            </div>
            <div title="博客类别管理" iconCls="icon-2012080111634" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('博客类别信息管理','../index.html','icon-bklb')" class="easyui-linkbutton" plain="true" iconCls="icon-bklb"  style="width: 150px">博客信息管理</a>
            </div>
            <div title="评论管理" iconCls="icon-comment" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('评论审核','commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
                <a href="javascript:openTab('评论信息管理','commentManage.jsp','icon-plgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
            </div>
            <div title="个人信息管理" iconCls="icon-user" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('修改个人信息','modifyInfo.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
            </div>
            <div title="系统管理" iconCls="icon-computer" style="overflow: hidden;margin:0;">
                <a href="javascript:openTab('友情链接管理','linkManage.jsp','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
            </div>
            <!--text_list_bullets.png  home-->
        </div>
    </div>
    <div id="content" region="center" title="Language" style="padding:5px;">
        <div class="easyui-tabs" style="height:100%;" id="tabs">

        </div>
    </div>
    <script>
        function showcontent(language){
            $('#content').html('Introduction to ' + language + ' language');
        }
    </script>
</body>
</html>
