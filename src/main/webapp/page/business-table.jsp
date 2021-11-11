<%@ page import="com.lcy.po.Business" %>
<%@ page import="com.lcy.po.RegionalOperator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
    RegionalOperator loginRegionalOperator = (RegionalOperator) request.getSession().getAttribute("loginRegionalOperator");
    String area = "未登录";
    if (loginRegionalOperator != null) {
        area = loginRegionalOperator.getArea();
    }
%>

<html>
<head>
    <title>待审核商家</title>
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
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="pass">审核通过</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="failed">审核不通过</a>
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
            url: '<%=basePath%>queryBusiness',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {
                    field: 'logPicture', width: 80, title: '商家log',
                    templet: function (data) {
                        return '<div><img  src="/images/businessLog/' + data.logPicture + '" style="height: 35px;width: 30px"></div>';
                    }
                },
                {field: 'name', width: 140, title: '店名'},
                {field: 'type', width: 160, title: '经营类型'},
                {field: 'registeredCapital', width: 120, title: '注册资金'},
                {title: '', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
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
                area: "<%=area%>"
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
            if (obj.event === 'pass') {
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>pass",
                    dataType: "json",
                    data: {
                        "id": data.id
                    }
                });
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1//重新从第1页开始
                    },
                    where: {
                        area: "<%=area%>"
                    }
                }, 'data');
                layer.msg('审核成功，该商家审核通过，已可正常登录');
            } else if (obj.event === 'failed') {
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>failed",
                    dataType: "json",
                    data: {
                        "id": data.id
                    }
                });
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1//重新从第1页开始
                    },
                    where: {
                        area: "<%=area%>"
                    }
                }, 'data');
                layer.msg('审核成功，该商家审核不通过，已删除');
            }
        });

    });
</script>

</body>
</html>
