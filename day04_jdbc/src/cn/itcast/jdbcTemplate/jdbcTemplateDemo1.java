package cn.itcast.jdbcTemplate;

import cn.itcast.datasource.utils.jdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateDemo1 {
    public static void main(String[] args) {

        JdbcTemplate template=new JdbcTemplate(jdbcUtils.getDataSource());
        String sql="update [User] set nu=5000 where id=?";
       int count=template.update(sql,3);
        System.out.println(count);
    }
}
