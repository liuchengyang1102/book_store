<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>用户注册</title>
    <link rel="icon" href="<%=basePath%>images/favicon.ico">
    <style>
        label {
            font-size: 25px;
            color: #00a2d4;
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
<body style="background: url(<%=basePath%>images/userLogin.png) 0% 0% / cover no-repeat">
<strong style="font-size: 40px;color: cyan;position: relative;left: 45%;top: 0px;">用户注册</strong>
<div>
    <label>用&nbsp;户&nbsp;名：</label>
    <div>
        <input type="text" name="username" required lay-verify="required" placeholder="用户名/账号(不超过12位)" autocomplete="off"
               class="username" maxlength="12">
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
    <label>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
    <div>
        <input type="text" name="name" required lay-verify="required" placeholder="请输入您的昵称(不超过12位)" autocomplete="off"
               class="name"maxlength="12">
    </div>
</div>
<div style="height: 50px;width: 100%"></div>
<div>
    <div>
        <button onclick="addUser()">注册</button>
        <button onclick="reset()">重置</button>
    </div>
</div>
<script src="<%=basePath%>lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="<%=basePath%>lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    function addUser() {
        var username = document.querySelector('.username').value;
        var password1 = document.querySelector('.password1').value;
        var password2 = document.querySelector('.password2').value;
        var name = document.querySelector('.name').value;
        if (password1 != password2) {
            alert('两次输入的密码不一样！');
        } else if (username == '' || password1 == '' || name == '') {
            alert('注册信息不全');
        }else {
            //这里跳转到后端
            $.ajax({
                type: "post",
                url: "<%=basePath%>addUser",
                dataType: "json",
                data: {
                    "username": username,
                    "password": password1,
                    "name": name
                },success:function (result) {
                    if(result==1){
                        layer.msg('注册成功,即将跳转登陆界面');
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
