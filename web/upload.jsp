<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/1/31
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
<s:form action="UploadAction" enctype="multipart/form-data" method="post">
    <s:textfield name="username" label="上传用户名"/><br/>
    <s:file name="file" label="选择文件"/><br/>
    <s:submit value="上传"/>
</s:form>
</body>
</html>
