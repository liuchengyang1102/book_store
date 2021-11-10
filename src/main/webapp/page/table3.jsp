<%@ page import="com.lcy.po.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
    User loginUser = (User) request.getSession().getAttribute("loginUser");
    int id = 0;
    if (loginUser != null) {
        id = loginUser.getId();
    }
%>

<html>
<head>
    <meta charset="utf-8">
    <title>待评论订单</title>
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
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="comment">添加评论</a>
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
            url: '<%=basePath%>queryOrder',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 60, title: 'ID', sort: true},
                {field: 'businessId', width: 80, title: '商家Id'},
                {field: 'businessName', width: 120, title: '商家店名'},
                {field: 'bookName', width: 120, title: '书名'},
                {field: 'price', width: 80, title: '价格', sort: true},
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
                userId: <%=id%>,
                state: '待评论'
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
            if (obj.event === 'comment') {
                var index = layer.open({
                    title: '添加评论',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['35%', '70%'],
                    content: '../page/table/comment.jsp',
                    btn: ['提交评论'],
                    yes: function (index, layero) {
                        var arr = $(layero).find("iframe")[0].contentWindow.submitComment();
                        $.ajax({
                            type: "post",
                            url: "<%=basePath%>addComment",
                            dataType: "json",
                            data: {
                                "userId": <%=id%>,
                                "businessId": data.businessId,
                                "orderId": data.id,
                                "level": arr.level,
                                "content": arr.content
                            }
                        });
                    }
                });
            }
        });

    });
</script>

</body>
</html>