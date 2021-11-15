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

        * {
            margin: 0;
            padding: 0;
        }

        body {
            font-size: 16px;
            background-color: #EDEDED;
            font-style: inherit;
            color: #757576;
        }

        .main {
            width: 100%;
            margin-left: 20px;
        }

        a {
            text-decoration: none;
            outline: none;
            color: #757576;
        }

        ul, ol {
            list-style: none;
        }

        li {
            float: left;
            display: inline-block;
            width: 240px;
            height: 40px;
            text-align: left;
            line-height: 40px;
        }

        .li3{
            float: left;
            display: inline-block;
            width: 240px;
            height: 30px;
            text-align: left;
            line-height: 30px;
        }

        li a:hover {
            color: red;
        }

        .frist {
            opacity: 0;
        }

        .frist li {
            float: none;
            position: relative;
        }

        li a:hover {
            color: red;
            transition: all 0.5s;
        }

        :hover {
            transition: all 2s;
        }

        .second {
            opacity: 0;
            margin: -40px 0 0 100px;
            padding: 0px;
            position: absolute;
        }

        .nav_one:hover .frist {
            opacity: 1;
            transition: all 2s;
        }

        .nav_two:hover .second {
            opacity: 1;
            transition: all 2s;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="nav main" style="height: 160px">
        <ul id="nav">
            <li class="nav_one"><a href="#" class="a1">计算机类</a>
                <ul class="frist">
                    <li class="nav_two">
                        <a href="#" class="a2">编程语言类</a>
                        <ul class="second">
                            <li class="li3"><a href="#" class="a3">Java语言类</a></li>
                            <li class="li3"><a href="#" class="a3">C语言类</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="nav_one"><a href="#" class="a1">网络文学</a>
                <ul class="frist">
                    <li class="nav_two">
                        <a href="#" class="a2">小说类</a>
                        <ul class="second">
                            <li class="li3"><a href="#" class="a3">玄幻小说</a></li>
                            <li class="li3"><a href="#" class="a3">悬疑小说</a></li>
                            <li class="li3"><a href="#" class="a3">推理小说</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="nav_one"><a href="#" class="a1">教育书籍</a>
                <ul class="frist">
                    <li class="nav_two">
                        <a href="#" class="a2">外语类</a>
                        <ul class="second">
                            <li class="li3"><a href="#" class="a3">大学英语</a></li>
                            <li class="li3"><a href="#" class="a3">中学英语</a></li>
                        </ul>
                    </li>
                    <li class="nav_two" class="a2">
                        <a href="#">物理类</a>
                        <ul class="second">
                            <li class="li3"><a href="#" class="a3">大学物理</a></li>
                            <li class="li3"><a href="#" class="a3">中学物理</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
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
    var sort1;
    var sort2;
    var sort3;

    function getSelectValue() {
        var myselect = document.getElementById("select");
        var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index
        if (myselect.options[index].value == "书名") {
            document.querySelector('#price_min').value = '';
            document.querySelector('#price_max').value = '';
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'name';
            input.id = 'name';
        } else if (myselect.options[index].value == "作者") {
            document.querySelector('#price_min').value = '';
            document.querySelector('#price_max').value = '';
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'author';
            input.id = 'author';
        } else if (myselect.options[index].value == "出版社") {
            document.querySelector('#price_min').value = '';
            document.querySelector('#price_max').value = '';
            inline1.style.display = 'inline-block';
            inline2.style.display = 'none';
            input.name = 'press';
            input.id = 'press';
        } else if (myselect.options[index].value == "价格范围") {
            input.value = '';
            inline1.style.display = 'none';
            inline2.style.display = 'inline-block';
        }
    }

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        $('.a1').click(function () {
            sort1 = $(this).text();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1//重新从第1页开始
                },
                where: {
                    sort1: sort1
                }
            }, 'data');
        });

        $('.a2').click(function () {
            sort2 = $(this).text();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1//重新从第1页开始
                },
                where: {
                    sort2: sort2
                }
            }, 'data');
        });

        $('.a3').click(function () {
            sort3 = $(this).text();
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1//重新从第1页开始
                },
                where: {
                    sort3: sort3
                }
            }, 'data');
        });

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
                {field: 'id', width: 60, title: 'ID', sort: true},
                {field: 'businessName', width: 120, title: '商家店名'},
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

        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'add') {
                var isLogin =<%=id%>;
                if (isLogin == '0') {
                    layer.msg('尚未登陆，无法添加购物车');
                } else {
                    $.ajax({
                        type: "post",
                        url: "<%=basePath%>addShoppingCart",
                        dataType: "json",
                        data: {
                            "userId": <%=id%>,
                            "bookId": data.id,
                            "bookName": data.name,
                            "price": data.price
                        }
                    });
                    layer.msg('成功加入购物车');
                }
            } else if (obj.event === 'buy') {
                var isLogin =<%=id%>;
                if (isLogin == '0') {
                    layer.msg('尚未登陆，无法下订单购买');
                } else {
                    $.ajax({
                        type: "post",
                        url: "<%=basePath%>addBuy",
                        dataType: "json",
                        data: {
                            "userId": <%=id%>,
                            "bookId": data.id,
                            "bookName": data.name,
                            "price": data.price
                        }
                    });
                    layer.msg('已加入订单，请尽快前往付款');
                }
            }
        });

    });
</script>

</body>
</html>
