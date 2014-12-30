<%@ page import="java.util.List" %>
<%@ page import="com.tw.todolist.Models.ToDo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <%
        String basePath = request.getContextPath();
        List<ToDo> userToDoList = (List<ToDo>) request.getAttribute("usertodolist");
    %>
    <title>TODO主页</title>
    <link rel="stylesheet" href="<%=basePath%>/bower_components/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/bower_components/todomvc-common/base.css">
</head>
<body>

<header id="header">
    <h1>todos</h1>
    <input id="new-todo" placeholder="What needs to be done?" autofocus="">
</header>

<section id="main" style="display: block;">
    <ul id="todo-list">
        <c:forEach items="<%= userToDoList %>" var="toDo">
            <li data-id="${toDo.id}" ${toDo.done==1? "class='completed'":""}>
                <div class="view">
                    <input class="toggle" type="checkbox" ${toDo.done==1?"checked":""}>
                    <label>${toDo.name}</label>
                    <button class="destroy"></button>
                </div>
                <input class="edit" value="${toDo.name}">
            </li>
        </c:forEach>

    </ul>
</section>
</body>
</html>
