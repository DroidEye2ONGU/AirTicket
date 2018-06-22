<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转界面</title>
</head>
<body>

<%
    String ticketID = request.getParameter("message");
%>
<h2>
    <a href="checkTicketPage.jsp">返回</a>
</h2>
<center>
    <h1>
        ↓请选择要对机票号为<%=ticketID%>的机票信息进行的操作↓<br>
        <a href="modifyTicketPage.jsp?message=<%=ticketID%>">修改信息</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="deleteTicketPage.jsp?message=<%=ticketID%>">删除此机票信息</a>
    </h1>
</center>

</body>
</html>
