
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TODO</title>
  <link rel="stylesheet" href="bower_components/todomvc-common/base.css">
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
    <li data-id="917bc809-7e52-4cf3-8dc6-fd95e2462304">
      <div class="view">
        <input class="toggle" type="checkbox">
        <label>12</label>
        <button class="destroy"></button>
      </div>
      <input class="edit" value="12">
    </li>
    <li data-id="bf086285-4746-4772-acf3-266e6ba1eb4f">
      <div class="view">
        <input class="toggle" type="checkbox">
        <label>123</label>
        <button class="destroy"></button>
      </div>
      <input class="edit" value="123">
    </li>
  </ul>
</section>
<a href="test.jsp" class="active" role="button">Primary link</a>

<h3>Today is:</h3>
<%= new java.util.Date()%>

<script src="bower_components/jquery/dist/jquery.js"  ></script>
<script src="js/main.js"></script>

</body>
</html>
