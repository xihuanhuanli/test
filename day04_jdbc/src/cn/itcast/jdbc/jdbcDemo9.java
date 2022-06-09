package cn.itcast.jdbc;

import cn.itcast.util.jdbcUtils;

import java.sql.*;
import java.util.Scanner;

public class jdbcDemo9 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        boolean flag=new jdbcDemo9().login1(username,password);
        if(flag){
            System.out.println("登录成功");

        }else {
            System.out.println("登录失败");
        }
    }









    public boolean login(String username,String password){
        if (username==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn= jdbcUtils.getConnection();
            String sql="select * from [User] where username='"+username+"' and password ='"+password+"'";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(rs,stmt,conn);
        }
        return false;
    }
    public boolean login1(String username,String password){
        if (username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            conn= jdbcUtils.getConnection();
            String sql="select * from [User] where username=? and password =?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(rs,pstmt,conn);
        }
        return false;
    }
}
