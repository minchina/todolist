<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tw.todolist.Models.ToDo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <title>TODO主页</title>
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css" />
  <link rel="stylesheet" type="text/css" href="./bower_components/todomvc-common/base.css">
</head>
<body>

<header id="header">
  <h1>todos</h1>
  <input id="new-todo" placeholder="What needs to be done?" autofocus="">
</header>

<section id="main" style="display: block;">
  <input id="toggle-all" type="checkbox">
  <label for="toggle-all">Mark all as complete</label>
  <ul id="todo-list">

    <%
      List<ToDo> toDoItems = (List<ToDo>)request.getAttribute("toDoList");
    %>

    <c:forEach items="<%= toDoItems %>" var="toDo">
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
<a href="user" class="btn btn-primary btn-lg" role="button">用户列表</a>
<script  src="./bower_components/jquery/dist/jquery.js"  ></script>
<script  src="./js/main.js"></script>

</body>
</html>
