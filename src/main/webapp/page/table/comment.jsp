<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>添加评论</title>
    <link rel="stylesheet" href="<%=basePath%>lib/layui-v2.6.3/css/layui.css" media="all">
    <style>
        #score1 i {
            vertical-align: middle;
            display: inline-block;
            width: 25px;
            height: 25px;
            background: url('<%=basePath%>images/star.png') no-repeat center center;
            background-size: cover;
        }

        #score1 i.on {
            background-image: url('<%=basePath%>images/yellowStar.png');
        }

        textarea {
            width: 350px;
            height: 120px;
        }
    </style>
</head>
<body>
<div style="float: left;width: 100%;height: 40px">
    评价等级：
    <span id="score1">
          <i></i>
          <i></i>
          <i></i>
          <i></i>
          <i></i>
     </span>
</div>
<div style="float: left;width: 100%;height: 150px">
    评价内容：
    <textarea name="content" class="content"></textarea>
</div>
<script src="<%=basePath%>lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script>
    var i = 0;

    function score(scoreId, extentStr) {
        scoreId = "#" + scoreId;
        $(scoreId + " i").hover(function () { // 鼠标移入，未确定选择分数时
            for (i = 0; i <= $(this).index(); i++) {
                $(scoreId + " i").eq(i).addClass(extentStr); // 实星星
            }
            $(scoreId + " i").click(function () { // 点击评分，确定好分数后无法更改
                for (var i = 0; i <= $(this).index(); i++) {
                    $(scoreId + " i").eq(i).addClass(extentStr);
                }
                $(scoreId).val($(this).index() + 1);
                $(scoreId + " i").unbind(); // 清除移入移出
            });

        }, function () { // 鼠标移出
            $(scoreId + " i").removeClass(extentStr); // 描线星星
        });
    }

    score("score1", "on");

    function submitComment() {
        var content = document.querySelector('.content').value;
        var data = {
            level: i,
            content: content
        };
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);//关闭当前页
        window.parent.location.reload();//刷新父页面
        return data;
    }
</script>

</body>
</html>
