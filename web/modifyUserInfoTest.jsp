<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/1/31
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<s:form action="ModifyUserInfoAction"  method="POST">
    <s:textfield name="username" value="用户名"/>
    <s:textfield name="nickname" value="昵称"/>
    <s:textfield name="sex" value="性别"/>
    <s:textfield name="signature" value="个签"/>
    <s:submit type="submit" value="修改"/>
</s:form>
</body>
</html>
