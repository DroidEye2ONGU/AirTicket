<%@ page import="java.util.List" %>
<%@ page import="AIR.JavaBean.OrderBean" %>
<%@ page import="AIR.DAO.OrderDAO" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/6/22
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<%
    List<OrderBean> orders = OrderDAO.getOrderDAOInstance().queryAllOrder();
%>
<h2>
    <a href="index.jsp">退出登录</a>
</h2>
<center>
    <h1>
        <a href="addTicketPage.jsp">添加机票信息</a>
        <a href="checkTicketPage.jsp">查询与删除机票信息</a>
    </h1>

    <%
        String orderID = null;
        String bookPeopleName = null;
        if (orders.isEmpty()) {
    %>
    暂无订单信息
    <%
    } else {
    %>
    <h1>
        已经收到的订单信息如下<br>
    <table width="25%" border="1" align="center" id="tab2">
        <tr>
            <td align="center" valign="middle">订单号</td>
            <td align="center" valign="middle">订单人</td>
        </tr>

        <%
            for (OrderBean order : orders
                    ) {
                orderID = order.getOrderID();
                bookPeopleName = order.getBookPeopleName();
            }
        %>

        <tr>
        <td align="center" valign="middle"><%=orderID%>
        </td>
        <td align="center" valign="middle"><%=bookPeopleName%>
        </td>
        </tr>
    </table>
    </h1>
    <%
        }
    %>

</center>

</body>
</html>
