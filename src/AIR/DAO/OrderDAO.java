package AIR.DAO;

import AIR.JavaBean.OrderBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DroidEye on 2017/6/22.
 */
public class OrderDAO {


    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/air";
    public static final String DBUSER = "root";
    public static final String DBPASS = "admin";

    private static OrderDAO orderDAO = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private OrderDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static OrderDAO getOrderDAOInstance() {
        if (orderDAO == null) {
            try {
                orderDAO = new OrderDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return orderDAO;
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

    public List<OrderBean> queryAllOrder() {
        OrderBean order = null;
        List<OrderBean> orders = new ArrayList<>();
        if (prepareMySql("SELECT * FROM orderticket")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    order = new OrderBean();
                    order.setOrderID(rs.getString("order_id"));
                    order.setBookPeopleName(rs.getString("book_people_name"));
                    orders.add(order);
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
        return orders;
    }
}
