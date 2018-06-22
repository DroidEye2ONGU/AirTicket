<%@ page import="AIR.DAO.TicketDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除页面</title>
</head>
<body>
<%
    String ticketID = request.getParameter("message");
    TicketDAO ticketDAO = TicketDAO.getTicketDAOInstance();
%>
<%
    if (ticketDAO.deleteTicket(ticketID)) {
%>
<script language='javascript'>alert('删除成功')</script>
<%response.setHeader("refresh", "0;URL=checkTicketPage.jsp");
}else {
%>
<script language='javascript'>alert('删除失败')</script>
<%
    response.setHeader("refresh", "0;URL=checkTicketPage.jsp");
    }
%>
</body>
</html>
