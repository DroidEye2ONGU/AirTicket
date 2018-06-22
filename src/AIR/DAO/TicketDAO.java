package AIR.DAO;

import AIR.JavaBean.TicketBean;
import sun.security.krb5.internal.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/22.
 */
public class TicketDAO {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/air";
    public static final String DBUSER = "root";
    public static final String DBPASS = "admin";

    private static TicketDAO ticketDAO = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private TicketDAO() throws  ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static TicketDAO getTicketDAOInstance() {
        if (ticketDAO == null) {
            try {
                ticketDAO = new TicketDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return ticketDAO;
    }

    private boolean prepareMySql(String sql) {
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            pstmt = conn.prepareStatement(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void closeMySql() {
        if (conn != null) {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addTicket(TicketBean ticketBean) {
        String ticketID = ticketBean.getTicketID();
        String ticketAddress = ticketBean.getTicketAddress();
        String ticketPrice = ticketBean.getTicketPrice();

        if (prepareMySql("INSERT INTO ticket VALUES(?,?,?)")) {
            try {
                pstmt.setString(1, ticketID);
                pstmt.setString(2, ticketAddress);
                pstmt.setString(3, ticketPrice);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }

    public List<TicketBean> queryAllTickets() {
        List<TicketBean> tickets = new ArrayList<>();
        if (prepareMySql("SELECT * FROM ticket")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    TicketBean ticket = new TicketBean();
                    ticket.setTicketID(rs.getString("ticket_id"));
                    ticket.setTicketAddress(rs.getString("ticket_address"));
                    ticket.setTicketPrice(rs.getString("ticket_price"));
                    tickets.add(ticket);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                closeMySql();
            }
        }
        return tickets;
    }

    public boolean deleteTicket(String ticketID) {
        if (prepareMySql("DELETE FROM ticket WHERE ticket_id=\'" + ticketID + "\'")) {
            try {
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }

    public boolean modifyTicket(TicketBean ticketBean) {
        String ticketID = ticketBean.getTicketID();
        String ticketAddress = ticketBean.getTicketAddress();
        String ticketPrice = ticketBean.getTicketPrice();
        if (prepareMySql("UPDATE ticket SET ticket_address=\'" + ticketAddress + "\',ticket_price=\'" +
                ticketPrice + "\' WHERE ticket_id=\'" + ticketID + "\'")) {
            try {
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }

}
