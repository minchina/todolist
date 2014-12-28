<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="./bower_components/todomvc-common/base.css">

    <title>用户列表</title>
</head>
<body>



<header id="header">
  <h1>用户列表</h1>
  <input id="new-todo" placeholder="请输入一个新用户" autofocus="">
</header>

<ul id="todo-list">
    <li data-id="1" >
      <div class="view">
        <%--<input class="toggle" type="checkbox" >--%>
        <label>zhangsan</label>
        <button class="destroy"></button>
      </div>
      <input class="edit" value="123">
    </li>
</ul>


<script  src="./bower_components/jquery/dist/jquery.js"  ></script>
<script src="js/user.js"></script>
</body>
</html>
