package cn.itcast.jdbc;

import java.sql.*;

public class jdbcDemo6 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs=null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String sql = "select * from [User]";

            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sms", "hb", "hb");

            stmt = conn.createStatement();

            rs=stmt.executeQuery(sql);

            rs.next();

//            String username=rs.getString(1);
//            String password=rs.getString(2);
//            String gender=rs.getString(3);
//            String resume=rs.getString(4);
            String username=rs.getString("Username");
            String password=rs.getString("Password");
            String gender=rs.getString("Gender");
            String resume=rs.getString("resume");
            System.out.println(username + "---"+password+"---"+gender+"---"+resume+"---");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
