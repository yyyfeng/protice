<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
    <link href="/easyui/themes/icon.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg" class="easyui-datagrid" data-options="singleSelect:true ,pagination:true,url:''" width="1000px"
       toolbar="#tb" title="用户信息展示列表";>
    <thead>
    <tr>
        <th data-options="field:'userId'">ID</th>
        <th data-options="field:'userName'">姓名</th>
        <th data-options="field:'userPass'">密码</th>
        <th data-options="field:'userAge'">年龄</th>
        <th data-options="field:'userSex'">性别</th>
        <th data-options="field:'userMobile'">手机号</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list }" var="user">
        <tr>
            <td>${user.userId }</td>
            <td>${user.userName }</td>
            <td>${user.userPass }</td>
            <td>${user.userAge }</td>
            <td>${user.userSex }</td>
            <td>${user.userMobile }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="tb">
    <form action="userList" method="post">
        <div>
            <input type="text"  id="userName" name="userName" data-options="prompt:'请输入...'" style="width:300px" />
            <button type="submit">搜索</button>

        </div>
    </form>
    <div style="text-align:right">
        <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:alert('add')">Add</a>--%>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:del()">删除</a>
        <a href="register.html" class="easyui-linkbutton" iconCls="icon-save" plain="true" >添加</a>
    </div>
</div>
<div id="add" class="easyui-window" title="添加用户"
     style="overflow: hidden; width: 500px; height: 500px ;margin-left: auto;margin-top: auto;"
     data-options="closed:true,iconCls:'icon-save',modal:true">
    <iframe width="100%" style="border: 0px;"
            height="100%"></iframe>
</div>
<div id="edit" class="easyui-window" title="修改用户"
     style="overflow: hidden; width: 500px; height: 500px; margin-left: auto; margin-top: auto;"
     data-options="closed:true,iconCls:'icon-save',modal:true">
    <iframe id="editUser" width="100%" style="border: 0px;"
            height="100%"></iframe>
</div>
<script type="text/javascript">

    //删除用户方法
   function del(){
       var row = $('#dg').datagrid('getSelected');
       if (row){
           var userId=row.userId;
          var res= event.returnValue =confirm("您确认要删除?");
          if(res){
              $.ajax({
                  type:"get",
                  url:"delUser",
                  data:"userId="+userId,
                  dataType:"json",
                  success:function(result){
                      if(result==1){
                          alert("删除成功！");
                          location.reload();
                      }else{
                          alert("删除失败！");
                          location.reload();
                      }
                  }
              })
          }else{
              return;
          }
       }
   }



    //用户列表进行分页的方法
    $('#dg').datagrid({ loadFilter: pagerFilter }).datagrid({
        url: '/jspIndex'     //加载数据
    });

    // 分页数据的操作
    function pagerFilter(data) {
        if (typeof data.length == 'number' && typeof data.splice == 'function') {   // is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage: function (pageNum, pageSize) {
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                pager.pagination('refresh', {
                    pageNumber: pageNum,
                    pageSize: pageSize
                });
                dg.datagrid('loadData', data);
            }
        });
        if (!data.originalRows) {
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }

</script>
</body>