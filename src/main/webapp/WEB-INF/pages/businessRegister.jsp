<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>商家注册</title>
    <link rel="icon" href="<%=basePath%>images/favicon.ico">
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

        button {
            height: 40px;
            width: 100px;
            font-size: 20px;
            text-align: center;
        }
    </style>
</head>
<body style="background: url(<%=basePath%>images/businessLogin.png) 0% 0% / cover no-repeat">
<strong style="font-size: 40px;color: cyan;position: relative;left: 45%;top: 0px;">商家注册</strong>
<div>
    <label>用&nbsp;户&nbsp;名：</label>
    <div>
        <input type="text" name="userName" required lay-verify="required" placeholder="用户名/账号(不超过12位)" autocomplete="off"
               class="userName" maxlength="12">
    </div>
</div>
<div>
    <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
    <div>
        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码(不超过16位)"
               autocomplete="off" class="password1" maxlength="16">
    </div>
</div>
<div>
    <label>确认密码：</label>
    <div>
        <input type="password" name="password" required lay-verify="required" placeholder="请再次输入密码(不超过16位)"
               autocomplete="off" class="password2" maxlength="16">
    </div>
</div>
<div>
    <label>书店店名：</label>
    <div>
        <input type="text" name="name" required lay-verify="required" placeholder="店名(不超过12位)" autocomplete="off"
               class="name" maxlength="12">
    </div>
</div>
<div>
    <label>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
    <div>
        <select id="province" onclick="getProvinceValue()">
            <option value="" selected="">省</option>
            <option value="湖南省">湖南省</option>
        </select>
        <select id="city" onclick="getCityValue()">
            <option value="" selected="">市</option>
            <option value="长沙市">长沙市</option>
        </select>
        <select id="county" onclick="getCountyValue()">
            <option value="" selected="">区县</option>
            <option value="开福区">开福区</option>
            <option value="芙蓉区">芙蓉区</option>
        </select>
    </div>
</div>
<div>
    <label>经营类型：</label>
    <div>
        <select id="type" onclick="getTypeValue()">
            <option value="" selected="">经营类型</option>
            <option value="计算机类">计算机类</option>
            <option value="网络文学">网络文学</option>
            <option value="教育书籍">教育书籍</option>
        </select>
    </div>
</div>
<div>
    <label>注册资金：</label>
    <div>
        <input type="text" name="registeredCapital" required lay-verify="required" placeholder="注册资金"
               autocomplete="off" class="registeredCapital" maxlength="10">
    </div>
</div>
<div>
    <label>商家log：</label>
    <div>
        <div id="zyupload" class="zyupload" style="float: left;"></div>
    </div>
</div>
<div style="height: 400px;width: 100%"></div>
<div>
    <div>
        <button onclick="addBusiness()">注册</button>
        <button onclick="reset()">重置</button>
    </div>
</div>
<script src="<%=basePath%>lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="<%=basePath%>lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="<%=basePath%>lib/jq-module/zyupload/zyupload-1.0.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
    var type;
    var province;
    var city;
    var county;
    var logPicture;

    $(function () {
        // 初始化插件
        $("#zyupload").zyUpload({
            width: "650px",                 // 宽度
            height: "120px",                 // 宽度
            itemWidth: "140px",                 // 文件项的宽度
            itemHeight: "115px",                 // 文件项的高度
            url: "<%=basePath%>uploadImage",  // 上传文件的路径
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

    function getTypeValue() {
        var select = document.getElementById("type");
        var index = select.selectedIndex;
        type = select.options[index].value;
    }

    function getProvinceValue() {
        var select = document.getElementById("province");
        var index = select.selectedIndex;
        province = select.options[index].value;
    }

    function getCityValue() {
        var select = document.getElementById("city");
        var index = select.selectedIndex;
        city = select.options[index].value;
    }

    function getCountyValue() {
        var select = document.getElementById("county");
        var index = select.selectedIndex;
        county = select.options[index].value;
    }

    function addBusiness() {
        var userName = document.querySelector('.userName').value;
        var password1 = document.querySelector('.password1').value;
        var password2 = document.querySelector('.password2').value;
        var name = document.querySelector('.name').value;
        var address = province + city + county;
        var registeredCapital = document.querySelector('.registeredCapital').value;
        if (password1 != password2) {
            alert('两次输入的密码不一样！');
        } else if (userName == '' || password1 == '' || name == '' || registeredCapital == '' || province == ''
            || city == '' || county == '' || type == '' || Object.is(province, undefined) || Object.is(city, undefined)
            || Object.is(county, undefined) || Object.is(type, undefined) || Object.is(logPicture, undefined)) {
            alert('注册信息不全');
        } else {
            //这里跳转到后端
            $.ajax({
                type: "post",
                url: "<%=basePath%>addBusiness",
                dataType: "json",
                data: {
                    "userName": userName,
                    "password": password1,
                    "name": name,
                    "address": address,
                    "type": type,
                    "registeredCapital": registeredCapital,
                    "logPicture": logPicture
                },success:function (result) {
                    if(result==1){
                        layer.msg('注册成功，即将跳转登陆界面');
                        window.setTimeout('window.location = \'page/login.jsp\'',1500);
                    }else {
                        layer.msg('注册失败，该用户名已存在');
                    }
                }
            });
        }
    }

    function reset() {
        location.reload();
    }
</script>
</body>
</html>
