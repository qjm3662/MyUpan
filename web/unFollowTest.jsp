<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/2/7
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取消关注测试</title>
</head>
<body>
<s:form action="unFollow" method="post" namespace="/user">
    <s:textfield name="myselfName" label="操作用户"/>
    <s:textfield name="otherName" label="取消关注对象"/>
    <s:submit value="取消关注"/>
</s:form>
</body>
</html>
