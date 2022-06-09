package cn.itcast.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sms","hb","hb");
        String sql=" update dbo.[User] set resume = 20 where Gender=1 ";
        Statement stmt =conn.createStatement();
        int count =stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        conn.close();
    }
}
