<%--
  Created by IntelliJ IDEA.
  User: minchina
  Date: 14-12-28
  Time: 下午2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <%
    String name = (String) request.getAttribute("name");
  %>
</head>
<body>
<h3><%= name %></h3>

</body>
</html>
