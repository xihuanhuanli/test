package cn.itcast.jdbcTemplate;

import cn.itcast.datasource.utils.jdbcUtils;
import cn.itcast.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class jdbcTemplateDemo2 {
    private  JdbcTemplate template=new JdbcTemplate(jdbcUtils.getDataSource());
    @Test
    public void test1(){


        String sql="update [User] set nu=4000 where id=2";
        int count=template.update(sql);
        System.out.println(count);
    }
    @Test
    public void test2(){
        String sql="insert into [User](id,username,password)values(?,?,?)";

       int count= template.update(sql,3,"yaoyao","yaoyao");
        System.out.println(count);

    }
    @Test
    public void test3(){
        String sql="delete from [User] where username=?";
        int count=template.update(sql,"yaoyao");
        System.out.println(count);
    }
    @Test
    public void test4(){
        String sql="select * from [User] where id=?";
        Map<String,Object> map =template.queryForMap(sql,2);
        System.out.println(map);
    }
    @Test
    public void test5(){
        String sql="select * from [User] ";
        List<Map<String,Object>> list=template.queryForList(sql);
        for (Map<String,Object> stringObjectMap:list){
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test6(){
        String sql="select * from [User] ";
        List<Emp> list= template.query(sql,new BeanPropertyRowMapper<>(Emp.class));



        for (Emp emp:list){
            System.out.println(emp);
        }
    }
    @Test
    public void test7(){
        String sql="select count(id) from [User] ";
        Long total=template.queryForObject(sql,Long.class);
        System.out.println(total);
    }

}
