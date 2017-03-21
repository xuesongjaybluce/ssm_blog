<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/13 0013
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论审核</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script>
        function formatterBlogTitle(val, row) {
            if(val == null){
                return "该博客已删除";
            }else{
                return "<a href='${pageContext.request.contextPath}/blog/article/"+val.id+".do'>"+val.title+"</a>";
            }
        }

        function passAudit(){
            var choose = "1";
            var selectRows = $('#dg').datagrid("getSelections");
            if(selectRows.length == 0){
                $.messager.alert("系统提示","请选择审核的博客");
                return;
            }
            var ids = [];
            for(var i=0; i<selectRows.length; i++){
                ids.push(selectRows[i].id);
            }
            var idsStr = ids.join(",");
            save(choose,idsStr);
        }
        function disPassAudit() {
            var choose = "2";
            var selectRows = $('#dg').datagrid("getSelections");
            if(selectRows.length == 0){
                $.messager.alert("系统提示","请选择审核的博客");
                return;
            }
            var ids = [];
            for(var i=0; i<selectRows.length; i++){
                ids.push(selectRows[i].id);
            }
            var idsStr = ids.join(",");
            save(choose,idsStr);
        }
        function save(choose,idsStr){
            $.messager.confirm("系统提示","确定通过您选择的" + idsStr.length + "条评论吗？",function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/admin/comment/editAudit.do",{ids:idsStr,choose:choose},                      function (result) {
                                if(result.exist){
                                    $.messager.alert("系统提示",result.exist);
                                    $("#dg").datagrid("reload");
                                }else if(result.success){
                                    $.messager.alert("系统提示","评论审核成功");
                                    $("#dg").datagrid("reload");
                                }else{
                                    $.messager.alert("系统提示","评论审核失败");
                                }
                            }
                            ,"json")
                }
            })
        }
    </script>
</head>
<body>
    <table id="dg" title="评论审核" class="easyui-datagrid" fitColumns="true" pagination="true" pageSize="10"
           url="${pageContext.request.contextPath}/admin/comment/commentList.do" toolbar="#toolbar">
        <thead>
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="id" width="20" align="center">编号</th>
            <th field="userIp" width="20" align="center">评论ip</th>
            <th field="content" width="50" align="center">评论内容</th>
            <th field="commentDate" width="20" align="center">评论日期</th>
            <th field="blog" width="20" align="center" formatter="formatterBlogTitle">博客标题</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <div>
            <a href="javascript:passAudit()" icon-Cls="icon-search"class="easyui-linkbutton" plain="true">通过审核</a>
            <a href="javascript:disPassAudit()" icon-Cls="icon-edit"class="easyui-linkbutton" plain="true">不通过审核</a>
        </div>
    </div>
</body>
</html>
