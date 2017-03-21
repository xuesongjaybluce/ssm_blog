<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/21 0021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客管理</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script>
        function blogTitle(val,row){
            return "<a href='"+row.id+"'>"+val+"</a>";
        }
        function blogType(val,row) {
            return val.typeName;
        }
        function searchBlog(){
            //TODO
            $('#dg').datagrid("load",{
                "title":$('#s_title').val()
            });
        }
        function reloadBlog() {
            $('#dg').datagrid("reload");
        }
        function openModifyBlog() {
            var selectRows = $('#dg').datagrid("getSelections");

            if(selectRows.length != 1){
                $.messager.alert("系统提示","请选择一个需要修改的博客");
                return ;
            }

            window.parent.openTab("修改博客","modifyBlog.jsp?id=" + selectRows[0].id,"icon-writeblog");

        }
        function deleteBlog(){
            var selectRows = $('#dg').datagrid("getSelections");
            if(selectRows.length == 0){
                $.messager.alert("系统提示","请选择需要删除的博客");
                return;
            }
            var ids = [];

            for(var i = 0; i < selectRows.length; i++){
                ids.push(selectRows[i].id);
            }
            var idsStr = ids.join(",");

            $.messager.confirm("系统提示","是否删除您选择的"+ids.length+"条博客",function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/admin/blog/delete.do",{ids:idsStr},function(result){
                        if(result.exist){
                            $.messager.alert("系统提示",result.exist);
                            $("#dg").datagrid('reload');
                        }else if(result.success){
                            $.messager.alert("系统提示","博客删除成功");
                            $("#dg").datagrid('reload');
                        }else{
                            $.messager.alert("系统提示","博客删除失败");
                        }
                    },"json")
                }
            });

        }
    </script>
</head>
<body>
    <table id="dg" title="博客类别管理" class="easyui-datagrid" fitColumns="true" pagination="true" pageSize="10"
           url="${pageContext.request.contextPath}/admin/blog/listBlog.do" toolbar="#toolbar">
        <thead>
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="id" width="20" align="center">编号</th>
            <th field="blogType" width="20" align="center" formatter="blogType">博客类型</th>
            <th field="title" width="50" align="center" formatter="blogTitle">标题</th>
            <th field="releaseDate" width="20" align="center">创建日期</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <div>
            &nbsp;标题&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()">
            <a href="javascript:searchBlog()" icon-Cls="icon-search"class="easyui-linkbutton" plain="true">搜索</a>
            <a href="javascript:openModifyBlog()" icon-Cls="icon-edit"class="easyui-linkbutton" plain="true">修改</a>
            <a href="javascript:deleteBlog()" icon-Cls="icon-delete"class="easyui-linkbutton" plain="true">删除</a>
            <a href="javascript:reloadBlog()" icon-Cls="icon-reload"class="easyui-linkbutton" plain="true">刷新</a>
        </div>
    </div>
</body>
</html>
