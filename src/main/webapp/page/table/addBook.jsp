<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>添加图书</title>
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>lib/jq-module/zyupload/zyupload-1.0.0.min.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>css/public.css" media="all">
    <style>
        label {
            font-size: 25px;
            color: #FAFAFA;
        }

        input {
            outline: 0;
            -webkit-appearance: none;
            transition: all .3s;
            -webkit-transition: all .3s;
            box-sizing: border-box;
            height: 6%;
            width: 20%;
        }
    </style>
</head>
<body style="background: url(<%=basePath%>images/businessLogin.png) 0% 0% / cover no-repeat">
<div>
    <label>书号：</label>
    <div>
        <input type="number" name="number" required lay-verify="required" placeholder="书号(不超过12位)"
               autocomplete="off" class="number" maxlength="12">
    </div>
</div>
<div>
    <label>库存：</label>
    <div>
        <input type="number" name="count" required lay-verify="required" placeholder="请输入库存(不超过6位)"
               autocomplete="off" class="count" maxlength="5">
    </div>
</div>
<div>
    <label>书名：</label>
    <div>
        <input type="text" name="name" required lay-verify="required" placeholder="书名(不超过16位)" autocomplete="off"
               class="name" maxlength="16">
    </div>
</div>
<div>
    <label>作者：</label>
    <div>
        <input type="text" name="author" required lay-verify="required" placeholder="作者(不超过12位)" autocomplete="off"
               class="author" maxlength="12">
    </div>
</div>
<div>
    <label>出版社：</label>
    <div>
        <input type="text" name="press" required lay-verify="required" placeholder="作者(不超过12位)" autocomplete="off"
               class="press" maxlength="12">
    </div>
</div>
<div>
    <label>印次：</label>
    <div>
        <input type="number" name="impression" required lay-verify="required" placeholder="请输入印次(不超过8位)"
               autocomplete="off" class="impression" maxlength="8">
    </div>
</div>
<div>
    <label>简介：</label>
    <div>
        <input type="text" name="synopsis" required lay-verify="required" placeholder="简介" autocomplete="off"
               class="synopsis">
    </div>
</div>
<div>
    <label>价格：</label>
    <div>
        <input type="number" name="price" required lay-verify="required" placeholder="请输入价格"
               autocomplete="off" class="price" maxlength="6">
    </div>
</div>
<div>
    <label>分类：</label>
    <div>
        <select id="sort1" onclick="getSort1()">
            <option value="计算机类" selected="">计算机类</option>
            <option value="网络文学">网络文学</option>
            <option value="教育书籍">教育书籍</option>
        </select>
        <select id="sort2_1" class="sort2" style="display: none">
            <option value="编程语言类" selected="">编程语言类</option>
        </select>
        <select id="sort2_2" class="sort2" style="display: none">
            <option value="小说类" selected="">小说类</option>
        </select>
        <select id="sort2_3" class="sort2" style="display: none">
            <option value="外语类" selected="">外语类</option>
            <option value="物理类" selected="">物理类</option>
        </select>
        <select id="sort3_1" class="sort3" style="display: none">
            <option value="Java语言类" selected="">Java语言类</option>
            <option value="C语言类">C语言类</option>
        </select>
        <select id="sort3_2" class="sort3" style="display: none">
            <option value="玄幻小说" selected="">玄幻小说</option>
            <option value="悬疑小说">悬疑小说</option>
            <option value="推理小说">推理小说</option>
        </select>
        <select id="sort3_3" class="sort3" style="display: none">
            <option value="大学英语" selected="">大学英语</option>
            <option value="中学英语">中学英语</option>
        </select>
        <select id="sort3_4" class="sort3" style="display: none">
            <option value="大学物理" selected="">大学物理</option>
            <option value="中学物理">中学物理</option>
        </select>
    </div>
</div>
<div>
    <label>书籍图片：</label>
    <div>
        <div id="zyupload" class="zyupload" style="float: left;"></div>
    </div>
</div>
<div style="height: 400px;width: 100%"></div>
<script src="<%=basePath%>lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="<%=basePath%>lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="<%=basePath%>lib/jq-module/zyupload/zyupload-1.0.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
    var sort1;
    var sort2;
    var sort3;
    var logPicture;

    $(function () {
        // 初始化插件
        $("#zyupload").zyUpload({
            width: "650px",                 // 宽度
            height: "120px",                 // 宽度
            itemWidth: "140px",                 // 文件项的宽度
            itemHeight: "115px",                 // 文件项的高度
            url: "<%=basePath%>uploadImage2",  // 上传文件的路径
            fileType: ["jpg", "png"],// 上传文件的类型
            fileSize: 51200000,                // 上传文件的大小
            multiple: false,                    // 是否可以多个文件上传
            dragDrop: true,                    // 是否可以拖动上传文件
            tailor: true,                    // 是否可以裁剪图片
            del: true,                    // 是否可以删除文件
            finishDel: false,  				  // 是否在上传文件完成后删除预览
            /* 外部获得的回调接口 */
            onSelect: function (selectFiles, allFiles) {    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
                console.info("当前选择了以下文件：");
                console.info(selectFiles);
            },
            onDelete: function (file, files) {              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
                console.info("当前删除了此文件：");
                console.info(file.name);
            },
            onSuccess: function (file, response) {          // 文件上传成功的回调方法
                // console.info("此文件上传成功：");
                // console.info(file.name);
                // console.info("此文件上传到服务器地址：");
                // console.info(response);
                // $("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
                logPicture = response;
                alert("图片上传成功!");
            },
            onFailure: function (file, response) {          // 文件上传失败的回调方法
                console.info("此文件上传失败：");
                console.info(file.name);
            },
            onComplete: function (response) {           	  // 上传完成的回调方法
                console.info("文件上传完成");
                console.info(response);
            }
        });

    });

    function getSort1() {
        var select = document.getElementById("sort1");
        var sort2_1 = document.getElementById("sort2_1");
        var sort2_2 = document.getElementById("sort2_2");
        var sort2_3 = document.getElementById("sort2_3");
        var index = select.selectedIndex;
        sort1 = select.options[index].value;
        if (sort1 == '计算机类') {
            sort2_1.style.display = 'inline-block';
            sort2_2.style.display = 'none';
            sort2_3.style.display = 'none';
        } else if (sort1 == '网络文学') {
            sort2_1.style.display = 'none';
            sort2_2.style.display = 'inline-block';
            sort2_3.style.display = 'none';
        } else if (sort1 == '教育书籍') {
            sort2_1.style.display = 'none';
            sort2_2.style.display = 'none';
            sort2_3.style.display = 'inline-block';
        }
    }

    function submitBook() {
        var number = document.querySelector('.number').value;
        var count = document.querySelector('.count').value;
        var name = document.querySelector('.name').value;
        var author = document.querySelector('.author').value;
        var press = document.querySelector('.press').value;
        var impression = document.querySelector('.impression').value;
        var synopsis = document.querySelector('.synopsis').value;
        var price = document.querySelector('.price').value;
        var data = {
            number: number,
            count: count,
            name: name,
            author: author,
            press: press,
            impression: impression,
            synopsis: synopsis,
            price: price,
            sort1: sort1,
            sort2: sort2,
            sort3: sort3,
            logPicture: logPicture
        };
        if (number == '' || count == '' || name == '' || author == '' || press == '' || impression == '' || synopsis == '' || price == '' ||
            Object.is(sort1, undefined) || Object.is(sort2, undefined) || Object.is(sort3, undefined) || Object.is(logPicture, undefined)) {
            alert('添加图书信息不全，请检查');
        } else {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);//关闭当前页
            window.parent.location.reload();//刷新父页面
            return data;
        }
    }

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery;

        $('.sort2').click(function () {
            sort2 = $(this).val();
            var sort3_1 = document.getElementById("sort3_1");
            var sort3_2 = document.getElementById("sort3_2");
            var sort3_3 = document.getElementById("sort3_3");
            var sort3_4 = document.getElementById("sort3_4");
            if (sort2 == '编程语言类') {
                sort3_1.style.display = 'inline-block';
                sort3_2.style.display = 'none';
                sort3_3.style.display = 'none';
                sort3_4.style.display = 'none';
            } else if (sort2 == '小说类') {
                sort3_1.style.display = 'none';
                sort3_2.style.display = 'inline-block';
                sort3_3.style.display = 'none';
                sort3_4.style.display = 'none';
            } else if (sort2 == '外语类') {
                sort3_1.style.display = 'none';
                sort3_2.style.display = 'none';
                sort3_3.style.display = 'inline-block';
                sort3_4.style.display = 'none';
            } else if (sort2 == '物理类') {
                sort3_1.style.display = 'none';
                sort3_2.style.display = 'none';
                sort3_3.style.display = 'none';
                sort3_4.style.display = 'inline-block';
            }
        });

        $('.sort3').click(function () {
            sort3 = $(this).val();
        });
    });
</script>
</body>
</html>
