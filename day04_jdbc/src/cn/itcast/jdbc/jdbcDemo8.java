package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.jdbcUtils;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo8 {
    public static void main(String[] args) {
        List<Emp> list=new jdbcDemo8().findAll2();
        System.out.println(list);
    }
    public List<Emp> findAll(){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sms", "hb", "hb");
            String sql = "select * from [User]";
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<Emp>();
            while (rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                int gender = rs.getInt("Gender");
                int resume = rs.getInt("resume");
                emp=new Emp();
                emp.setUsername(username);
                emp.setPassword(password);
                emp.setId(gender);
                emp.setNu(resume);
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }
    public List<Emp> findAll2(){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=sms", "hb", "hb");
            conn=jdbcUtils.getConnection();
            String sql = "select * from [User]";
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<Emp>();
            while (rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                int gender = rs.getInt("Gender");
                int resume = rs.getInt("resume");
                emp=new Emp();
                emp.setUsername(username);
                emp.setPassword(password);
                emp.setId(gender);
                emp.setNu(resume);
                list.add(emp);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
