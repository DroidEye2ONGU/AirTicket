<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>管理员登录</title>
  </head>
  <body>


  <center>
    <h1>

      <form method="post" action="/AdminLoginServlet">
        <br><br>&nbsp;&nbsp;<b>管理员登录</b>
        <br><br><br>&nbsp;&nbsp;管理员号：<input type="text" name="adminID"><br>
        <br>&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="adminPassword"><br>
        <br> &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset"
                                                                                              value="重置">
        &nbsp;&nbsp;&nbsp;

      </form>
    </h1>
  </center>
  </body>
</html>
