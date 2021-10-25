<%@ page import="com.lcy.util.Result" %>
<%@ page import="com.lcy.po.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 刘呈洋
  Date: 2021/10/13
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    User loginUser = (User) request.getSession().getAttribute("loginUser");
    String name = loginUser.getName();
%>

<html>
<head>
    <title>测试spring mvc</title>
</head>
<body>
您好，<%=name%>
测试人：刘呈洋
</body>
</html>
