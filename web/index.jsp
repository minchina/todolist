<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%@ page import="com.tw.todolist.Services.JdbcService" %>

<html>
<head>
  <title>TODO</title>
  <link rel="stylesheet" type="text/css" href="bower_components/todomvc-common/base.css">
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
      JdbcService jd = new JdbcService();
      ResultSet rs = null;
      try {
        rs = jd.getAll();
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      while (rs.next()){
    %>
    <li data-id="<%=rs.getInt(1)%>">
      <div class="view">
        <input class="toggle" type="checkbox" checked>
        <label><%=(rs.getString(2) + "\t")%></label>
        <button class="destroy"></button>
      </div>
      <input class="edit" value="12">
    </li>
    <%}
      rs.close();
    %>
  </ul>
</section>
<a href="test.jsp" class="active" role="button">Primary link</a>

<h3>Today is:</h3>
<%= new java.util.Date()%>

<script  src="bower_components/jquery/dist/jquery.js"  ></script>
<script  src="js/main.js"></script>

</body>
</html>
