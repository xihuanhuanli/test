package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidDemo {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();
       InputStream is= druidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
       pro.load(is);
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
