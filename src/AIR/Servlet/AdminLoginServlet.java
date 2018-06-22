package AIR.Servlet;

import AIR.DAO.AdminDAO;
import AIR.JavaBean.AdminBean;

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
@WebServlet(value = "/AdminLoginServlet", name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String adminID = request.getParameter("adminID");
        String adminPassword = request.getParameter("adminPassword");

        AdminDAO adminDAO = AdminDAO.getAdminDAOInstance();
        AdminBean adminBean = adminDAO.queryAdminAccount(adminID);

        if (adminBean != null) {
            if (adminBean.getAdminPassword().equals(adminPassword)) {
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('登录成功')</script>");
                response.setHeader("refresh", "0;URL=logingPage.jsp");
            } else {
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('用户名或密码错误！')</script>");
                response.setHeader("refresh", "0;URL=index.jsp");
            }
        } else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('用户名或密码错误！')</script>");
            response.setHeader("refresh", "0;URL=index.jsp");
        }


    }
}
