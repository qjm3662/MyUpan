<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: qjm3662
  Date: 2017/1/15
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎界面</title>
</head>
<body>
    本站访问的次数为：${applicationScope.counter}<br/>
    ${sessionScope.user}, 您已经登录！<br/>
    ${requestScope.tip}<br/>
    从系统读取Cookie值：${cookie.user.value}<br/>
    额外信息：${requestScope.extra}
</body>
</html>
