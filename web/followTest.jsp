<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/2/4
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关注测试</title>
</head>
<body>
<form action="/user/follow" method="post">
    <s:textfield name="myselfName" label="操作用户"/>
    <s:textfield name="otherName" label="关注对象"/>
    <s:submit value="关注"/>
</form>
</body>
</html>
