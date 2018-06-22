<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加机票信息</title>
</head>
<body>

<center>

    <h1>

        <form action="/AddTicketServlet" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            机票号：<input type="text" name="ticketID"><br>
            始发点与目的地：<input type="text" name="ticketAddress"><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            机票价格：<input type="text" name="ticketPrice"><br>
            <input type="submit" value="确认添加">
        </form>
    </h1>
    <a href="logingPage.jsp">返回</a>
</center>

</body>
</html>
