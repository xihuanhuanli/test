package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) {
        Statement stmt =null;
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql="insert into [User] values(33,33,3,333)";
            conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sms","hb","hb");
            stmt =conn.createStatement();
            int count =stmt.executeUpdate(sql);
            System.out.println(count);
            if (count>0){
                System.out.println("添加成功");
            }else
                System.out.println("添加失败");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }






    }
}
