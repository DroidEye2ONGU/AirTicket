package AIR.Servlet;

import AIR.DAO.TicketDAO;
import AIR.JavaBean.TicketBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DroidEye on 2017/6/22.
 */
@WebServlet(value = "/ModifyTicketServlet", name = "ModifyTicketServlet")
public class ModifyTicketServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String ticketID = request.getParameter("ticketID");
        String ticketAddress = request.getParameter("ticketAddress");
        String ticketPrice = request.getParameter("ticketPrice");

        TicketBean ticket = new TicketBean(ticketID, ticketAddress, ticketPrice);
        TicketDAO ticketDAO = TicketDAO.getTicketDAOInstance();

        if (ticketDAO.modifyTicket(ticket)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改成功')</script>");
            response.setHeader("refresh", "0;URL=checkTicketPage.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改失败')</script>");
            response.setHeader("refresh", "0;URL=checkTicketPage.jsp");
        }
    }
}
