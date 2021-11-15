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
    <title>商家商品</title>
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
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加图书</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改价格</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
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
            url: '<%=basePath%>businessQueryBook',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 60, title: 'ID', sort: true},
                {field: 'number', width: 60, title: '书号'},
                {field: 'count', width: 60, title: '数量'},
                {
                    field: 'ext',
                    width: 100,
                    title: '书籍图片',
                    templet: function (data) {
                        return '<div><img  src="/images/bookImages/' + data.ext + '" style="height: 35px;width: 30px"></div>';
                    }
                },
                {field: 'name', width: 100, title: '书名'},
                {field: 'author', width: 90, title: '作者'},
                {field: 'press', width: 100, title: '出版社'},
                {field: 'impression', width: 80, title: '印次'},
                {field: 'synopsis', width: 120, title: '内容简介'},
                {field: 'price', width: 80, title: '价格', sort: true},
                {title: '操作', minWidth: 120, toolbar: '#currentTableBar', align: "center"}
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
            if (obj.event === 'add') {  // 监听添加操作
                var isLogin =<%=id%>;
                if (isLogin == '0') {
                    layer.msg('尚未登陆，无法添加图书');
                } else {
                    var index = layer.open({
                        title: '添加图书',
                        type: 2,
                        shade: 0.2,
                        maxmin: true,
                        shadeClose: true,
                        area: ['100%', '100%'],
                        content: '../page/table/addBook.jsp',
                        btn: ['添加图书'],
                        yes: function (index, layero) {
                            var arr = $(layero).find("iframe")[0].contentWindow.submitBook();
                            $.ajax({
                                type: "post",
                                url: "<%=basePath%>addBook",
                                data: {
                                    "businessId": <%=id%>,
                                    "number": arr.number,
                                    "count": arr.count,
                                    "name": arr.name,
                                    "author": arr.author,
                                    "press": arr.press,
                                    "impression": arr.impression,
                                    "synopsis": arr.synopsis,
                                    "price": arr.price,
                                    "sort1": arr.sort1,
                                    "sort2": arr.sort2,
                                    "sort3": arr.sort3,
                                    "ext": arr.logPicture
                                }
                            });
                            alert('添加图书成功！');
                        }
                    });
                }
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var index = layer.open({
                    title: '修改价格',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['25%', '35%'],
                    content: '../page/table/edit-price.jsp',
                    btn: ['确认修改'],
                    yes: function (index, layero) {
                        var price = $(layero).find("iframe")[0].contentWindow.getInput();
                        if (typeof (price) != 'undefined') {
                            $.ajax({
                                type: "post",
                                url: "<%=basePath%>editPrice",
                                dataType: "json",
                                data: {
                                    "id": data.id,
                                    "price": price
                                }
                            });
                            alert('修改价格成功！');
                        }
                    }
                });
            } else if (obj.event === 'delete') {
                layer.confirm('确定删除该图书吗？', function (index) {
                    $.ajax({
                        type: "post",
                        url: "<%=basePath%>deleteBook",
                        dataType: "json",
                        data: {
                            "id": data.id
                        }, success: function () {
                            layer.msg('删除该图书成功');
                            //执行重载
                            table.reload('testReload', {
                                page: {
                                    curr: 1//重新从第1页开始
                                },
                                where: {
                                    businessId: <%=id%>
                                }
                            }, 'data');
                        }
                    });
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>

</body>
</html>
