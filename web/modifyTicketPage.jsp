<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改机票信息页面</title>
</head>
<body>
<%
    String ticketID = request.getParameter("message");
%>
<center>
    <h1>
        请输入<%=ticketID%>号的新机票信息<br>

        <form action="/ModifyTicketServlet" method="post">
            机票起始地与目的地：<input type="text" name="ticketAddress"><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            机票价格：<input type="text" name="ticketPrice"><br>
            <input type="hidden" name="ticketID" value=<%=ticketID%>>
            <input type="submit" value="提交">
        </form>
    </h1>
</center>

</body>
</html>
