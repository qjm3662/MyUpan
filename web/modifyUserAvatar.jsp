<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/2/3
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户头像测试</title>
</head>
<body>
<form action="/user/modifyAvatar" enctype="multipart/form-data" method="post">
    <s:textfield name="username" label="上传用户名"/>
    <s:file name="avatar" label="选择头像"/>
    <s:submit value="修改"/>
</form>
</body>
</html>
