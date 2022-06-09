package cn.itcast.datasource.druid;

import cn.itcast.datasource.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class druidDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn=jdbcUtils.getConnection();
            String sql="insert into [User] values(3,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"zaoyou");
            pstmt.setString(2,"zaoyou");
            pstmt.setInt(3,3000);
            int count=pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(pstmt,conn);
        }
    }
}
