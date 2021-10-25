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
    int id;
    if (loginUser != null) {
        id = loginUser.getId();
    } else {
        id = 0;
    }
%>

<html>
<head>
    <meta charset="utf-8">
    <title>商城首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
    <style>
        #layui-inline1 {
            display: inline-block;
        }

        #layui-inline2 {
            display: none;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="demoTable">
            <div class="layui-input-inline">
                <select name="quiz1" id="select" onclick="getSelectValue()">
                    <option value="书名" selected="">书名</option>
                    <option value="作者">作者</option>
                    <option value="出版社">出版社</option>
                    <option value="价格范围">价格范围</option>
                </select>
            </div>

            <div class="layui-inline" id="layui-inline1">
                <input class="layui-input" name="name" id="name" autocomplete="off">
            </div>

            <div class="layui-inline" id="layui-inline2">
                <label class="layui-form-label">价格范围</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="text" name="price_min" id="price_min" placeholder="￥" autocomplete="off"
                           class="layui-input">
                </div>
                <span>—</span>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="text" name="price_max" id="price_max" placeholder="￥" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="add">加入购物车</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="buy">购买</a>
        </script>

    </div>
</div>
<script src="../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    var input = document.querySelector('.layui-input');
    var inline1 = document.querySelector('#layui-inline1');
    var inline2 = document.querySelector('#layui-inline2');

    function getSelectValue() {
        var myselect = document.getElementById("select");
        var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index
        if (myselect.options[index].value == "书名") {
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'name';
            input.id = 'name';
        } else if (myselect.options[index].value == "作者") {
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'author';
            input.id = 'author';
        } else if (myselect.options[index].value == "出版社") {
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'press';
            input.id = 'press';
        } else if (myselect.options[index].value == "价格范围") {
            inline1.style.display = 'none';
            inline2.style.display = 'inline-block';
        }
    }

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '<%=basePath%>queryBook',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {field: 'businessId', width: 80, title: '商家id'},
                {field: 'number', width: 80, title: '书号'},
                {field: 'count', width: 80, title: '数量'},
                {field: 'name', width: 120, title: '书名'},
                {field: 'author', width: 80, title: '作者'},
                {field: 'press', width: 160, title: '出版社'},
                {field: 'impression', width: 80, title: '印次'},
                {field: 'synopsis', width: 120, title: '内容简介'},
                {field: 'price', width: 80, title: '价格', sort: true},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id: 'testReload'
        });

        var $ = layui.$, active = {
            reload: function () {
                var name = $('#name').val();
                var author = $('#author').val();
                var press = $('#press').val();
                var priceMin = $('#price_min').val();
                var priceMax = $('#price_max').val();
                if ((priceMin == '' && priceMax == '')) {
                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1//重新从第1页开始
                        },
                        where: {
                            name: name,
                            author: author,
                            press: press,
                            priceMin: priceMin,
                            priceMax: priceMax
                        }
                    }, 'data');
                } else if (!(priceMin != '' && priceMax != '')) {
                    alert("范围最大值和最小值都需要输入才能查询");
                } else if (((parseFloat(priceMin) + '') != priceMin && parseFloat(priceMin) != parseInt(priceMin)) || ((parseFloat(priceMax) + '') != priceMax && parseFloat(priceMax) != parseInt(priceMax))) {
                    alert("输入错误，请输入数字");
                } else if (parseFloat(priceMin) > parseFloat(priceMax) || parseFloat(priceMin) < 0 || parseFloat(priceMax) < 0) {
                    alert("价格范围输入错误,请重新输入");
                } else {
                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1//重新从第1页开始
                        },
                        where: {
                            name: name,
                            author: author,
                            press: press,
                            priceMin: priceMin,
                            priceMax: priceMax
                        }
                    }, 'data');
                }
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '../page/table/add.html',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            console.log(data);
            if (obj.event === 'add') {
                $.ajax({
                    type: "post",
                    url: "<%=basePath%>addShoppingCart",
                    dataType: "json",
                    data: {
                        "businessId": data.businessId,
                        "userId": <%=id%>,
                        "bookName": data.name,
                        "price": data.price
                    }
                });
                layer.msg('成功加入购物车');
            }
            // if (obj.event === 'edit') {
            //
            //     var index = layer.open({
            //         title: '编辑用户',
            //         type: 2,
            //         shade: 0.2,
            //         maxmin: true,
            //         shadeClose: true,
            //         area: ['100%', '100%'],
            //         content: '../page/table/edit.html',
            //     });
            //     $(window).on("resize", function () {
            //         layer.full(index);
            //     });
            //     return false;
            // } else if (obj.event === 'delete') {
            //     layer.confirm('真的删除行么', function (index) {
            //         obj.del();
            //         layer.close(index);
            //     });
            // }
        });

    });
</script>

</body>
</html>
