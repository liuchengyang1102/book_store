<%@ page import="com.lcy.po.Business" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
    Business loginBusiness = (Business) request.getSession().getAttribute("loginBusiness");
    int id = 0;
    if (loginBusiness != null) {
        id = loginBusiness.getId();
    }
%>

<html>
<head>
    <title>管理店铺</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="open">营业</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="close">休息</a>
        </script>

    </div>
</div>
<script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '<%=basePath%>queryState',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'state', width: 180, title: '店铺当前状态'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id: 'testReload'
        });

        //执行重载
        table.reload('testReload', {
            page: {
                curr: 1//重新从第1页开始
            },
            where: {
                id: <%=id%>
            }
        }, 'data');

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {

        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'open') {
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>businessManage",
                    dataType: "json",
                    data: {
                        "state": '营业中',
                        "id": <%=id%>
                    }, success: function (result) {
                        if (result == 1) {
                            layer.msg('修改店铺状态成功，店铺营业中');
                            //执行重载
                            table.reload('testReload', {
                                page: {
                                    curr: 1//重新从第1页开始
                                },
                                where: {
                                    id: <%=id%>
                                }
                            }, 'data');
                        } else {
                            layer.msg('修改店铺状态失败，店铺已在营业中');
                        }
                    }
                });
            } else if (obj.event === 'close') {
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>businessManage",
                    dataType: "json",
                    data: {
                        "state": '休息中',
                        "id": <%=id%>
                    }, success: function (result) {
                        if (result == 1) {
                            layer.msg('修改店铺状态成功，店铺休息中');
                            //执行重载
                            table.reload('testReload', {
                                page: {
                                    curr: 1//重新从第1页开始
                                },
                                where: {
                                    id: <%=id%>
                                }
                            }, 'data');
                        } else {
                            layer.msg('修改店铺状态失败，店铺已在休息中');
                        }
                    }
                });
            }
        });

    });
</script>

</body>
</html>
