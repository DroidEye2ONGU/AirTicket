<%@ page import="AIR.DAO.TicketDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="AIR.JavaBean.TicketBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询机票信息</title>
</head>
<body>

<%
    TicketDAO ticketDAO = TicketDAO.getTicketDAOInstance();
    List<TicketBean> tickets = new ArrayList<>();
    tickets = ticketDAO.queryAllTickets();
    String ticketID = null;
    String ticketAddress = null;
    String ticketPrice = null;
%>
<h2>
<a href="logingPage.jsp">返回</a>
</h2>
<center>
    <h1>
        <%
            if (tickets.isEmpty()) {
        %>
        暂无机票信息
        <a href="logingPage.jsp">返回</a>
        <%
        } else {
        %>
        已录入机票信息如下，点击机票号即可修改或删除其信息
        <table width="100%" border="1" align="center" id="tab2">
            <tr>
                <td align="center" valign="middle">机票号</td>
                <td align="center" valign="middle">机票始发地与目的地</td>
                <td align="center" valign="middle">机票价格</td>
            </tr>
                <%
                for (TicketBean ticket : tickets) {
                    ticketID = ticket.getTicketID();
                    ticketAddress = ticket.getTicketAddress();
                    ticketPrice = ticket.getTicketPrice();
                %>

            <tr>
                <td align="center" valign="middle">
                    <a href="operateTicket.jsp?message=<%=ticketID%>"><%=ticketID%>
                    </a>
                </td>
                <td align="center" valign="middle"><%=ticketAddress%>
                </td>
                <td align="center" valign="middle"><%=ticketPrice%>
                </td>
            </tr>
                <%
                }
            }%>
    </h1>

</center>

</body>
</html>
