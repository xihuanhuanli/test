package cn.itcast.jdbc;

import cn.itcast.util.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDemo10 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        try {
            conn=jdbcUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1="update dbo.[User] set nu=nu-? where id=?";
            String sql2="update dbo.[User] set nu=nu+? where id=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt2=conn.prepareStatement(sql2);
            pstmt1.setInt(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setInt(1,500);
            pstmt2.setInt(2,2);
            pstmt1.executeUpdate();
            int i=3/0;
            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if (conn!=null)
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            jdbcUtils.close(pstmt1,conn);
            jdbcUtils.close(pstmt2,conn);
        }
    }
}
