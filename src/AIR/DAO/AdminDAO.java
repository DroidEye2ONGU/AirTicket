package AIR.DAO;

import AIR.JavaBean.AdminBean;

import java.sql.*;

/**
 * Created by DroidEye on 2017/6/22.
 */
public class AdminDAO {

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/air";
    public static final String DBUSER = "root";
    public static final String DBPASS = "admin";

    private static AdminDAO adminDAO = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private AdminDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static AdminDAO getAdminDAOInstance() {
        if (adminDAO == null) {
            try {
                adminDAO = new AdminDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return adminDAO;
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

    public AdminBean queryAdminAccount(String adminID) {
        AdminBean admin = null;
        if (prepareMySql("SELECT * FROM admin WHERE admin_id=\'" + adminID + "\'")) {
            try {
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    admin = new AdminBean();
                    admin.setAdminID(rs.getString("admin_id"));
                    admin.setAdminPassword(rs.getString("admin_password"));
                    admin.setAdminName(rs.getString("admin_name"));
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

        return admin;
    }




}
