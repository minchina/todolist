<%@ page import="com.tw.todolist.Models.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="./bower_components/todomvc-common/base.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <title>用户列表</title>
</head>
<body>


<header id="header">
    <h1>用户列表</h1>
    <input id="new-todo" placeholder="请输入一个新用户" autofocus="">
</header>


<%
    List<User> userList = (List<User>) request.getAttribute("userList");
%>

<section id="main" style="display: block;">
    <ul id="todo-list">
        <c:forEach items="<%= userList %>" var="User">
            <li data-id="${User.id}" }>
                <div class="view">
                    <a href="user/${User.name}/todos">${User.name}</a>
                    <button class="destroy"></button>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>


<script src="./bower_components/jquery/dist/jquery.js"></script>
<script src="js/user.js"></script>
</body>
</html>
