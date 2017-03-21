<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/11 0011
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script>
        var url;

        function addBlogType(){
            $("#dlg").dialog('open').dialog('setTitle','添加博客类别');
            url = "${pageContext.request.contextPath}/admin/blogType/save.do";
        }
        function editBlogType(){
            var rows = $("#dg").datagrid("getSelections");
            if(rows.length != 1){
                $.messager.alert("系统提示","请选择一个要修改的数据");
                return ;
            }
            var selectRow = rows[0];
            $("#dlg").dialog('open').dialog('setTitle','修改博客类别');
            $("#fm").form("load",selectRow);
            url = "${pageContext.request.contextPath}/admin/blogType/save.do?id=" + selectRow.id;

        }
        function deleteBlogType(){
            var rows = $("#dg").datagrid("getSelections");
            if(rows.length == 0 ){
                $.messager.alert("系统提示","请选择要删除的数据");
                return ;
            }
            var ids = [];
            for(var i=0; i<rows.length; i++){
                ids.push(rows[i].id);
            }
            var idsStr = ids.join(",");
            $.messager.confirm("系统提示","确定删除您选择的" + rows.length + "条数据吗？",function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/admin/blogType/delete.do",{ids:idsStr},                      function (result) {
                            if(result.exist){
                                $.messager.alert("系统提示",result.exist);
                                $("#dg").datagrid("reload");
                            }else if(result.success){
                                $.messager.alert("系统提示","博客删除成功");
                                $("#dg").datagrid("reload");
                            }else{
                                $.messager.alert("系统提示","博客删除失败");
                            }
                        }
                        ,"json")
                }
            })
        }
        function saveBlogType(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function () {
                    return $(this).form("validate");
                },
                success:function (result) {
                    var result = eval("(" + result + ")");
                    if(result.success){
                        $.messager.alert("系统提示","博客类别保存成功");
                        $('#fm')[0].reset();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert("系统提示","博客类别保存失败");
                        return ;
                    }
                }
            })
        }
    </script>
</head>
<body>
<table id="dg" title="博客类别管理" class="easyui-datagrid" fitColumns="true" pagination="true" pageSize="10"
       url="${pageContext.request.contextPath}/admin/blogType/listBlogType.do" toolbar="#toolbar">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="20" align="center">编号</th>
        <th field="typeName" width="100" align="center">博客分类名称</th>
        <th field="orderNum" width="100" align="center">类别排序</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addBlogType()">添加博客类别</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBlogType()">修改博客类别</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBlogType()">删除博客类别</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>博客类型名:</label>
            <input name="typeName" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>博客类型排序:</label>
            <input name="orderNum" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBlogType()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close');$('#fm')[0].reset();">Cancel</a>
</div>
</body>
</html>
