<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/1/15
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="loginPage"/></title>
</head>
<script language="JavaScript">
    function register() {
        //获取页面的第一个表单
        var targetForm = document.forms[0];
        targetForm.action = "registerAction";
    }
</script>
<body>
<s:form action="loginAction">
    <s:textfield name="username" key="user"/>
    <s:password name="password" key="pass"/>
    <s:submit value="登录"/>
    <input type="submit" value="注册" onclick="register();">
</s:form>
</body>
</html>
