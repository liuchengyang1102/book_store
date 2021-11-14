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
    <title>订单评论</title>
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

        <script type="text/html" id="currentTableBar"></script>

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
            url: '<%=basePath%>queryComment',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {field: 'userName', width: 140, title: '购买用户'},
                {field: 'bookName', width: 160, title: '所购书籍'},
                {
                    field: 'level', width: 180, title: '评论星级', templet: function (data) {
                        return '<div><img  src="/images/level' + data.level + '.png " style="height: 40px;width: 160px"></div>';
                    }
                },
                {field: 'content', width: 200, title: '评论内容'},
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
                businessId: <%=id%>
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
        });

    });
</script>

</body>
</html>
