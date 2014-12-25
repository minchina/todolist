<%@ page import="com.mysql.jdbc.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tw.todolist.Models.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <title>TODO</title>
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
      List<Item> items = (List<Item>) request.getAttribute("result");
      for(int i=0;i<items.size();i++){
    %>
    <li data-id="<%=items.get(i).id%>">
      <div class="view">
        <input class="toggle" type="checkbox">
        <label><%=(items.get(i).name+ "\t")%></label>
        <button class="destroy"></button>
      </div>
      <input class="edit" value="12">
    </li>
    <%
      }
    %>
  </ul>
</section>
<a href="test.jsp" class="active" role="button">Primary link</a>

<h3>Today is:</h3>
<%= new java.util.Date()%>

<script  src="./bower_components/jquery/dist/jquery.js"  ></script>
<script  src="./js/main.js"></script>

</body>
</html>
