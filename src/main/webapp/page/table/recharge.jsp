<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户充值</title>
</head>
<body>
<div>
    充值金额：
    <input placeholder="请输入充值金额" class="layui-input">
</div>
<script>
    function getInput() {
        var input = document.querySelector(".layui-input").value;
        console.log(input);
        if (input == '') {
            alert("请输入数字");
        } else if ((parseFloat(input) + '') != input) {
            alert("输入错误，请输入数字");
        } else {
            var input = document.querySelector(".layui-input").value;
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);//关闭当前页
            window.parent.location.reload();//刷新父页面
            return input;
        }
    }
</script>
</body>
</html>
