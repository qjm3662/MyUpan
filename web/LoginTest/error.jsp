<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/1/15
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:text name="errPage"/></title>
</head>
<body>
账号或密码错误<br/>
异常信息: <s:property value="exception.message"/>
<p/>
<a href="login.jsp">重新登录</a>
</body>
</html>
