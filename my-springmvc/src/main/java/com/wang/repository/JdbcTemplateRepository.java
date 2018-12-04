package com.wang.repository;

import com.wang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/18 16:32  by  王帅（wangshuai@cloud-young.com）创建
 */
@Repository
public class JdbcTemplateRepository {
    private final static String sql="SELECT user_name from user WHERE id=?";
    @Autowired
//private JdbcTemplate jdbcTemplate;
    private JdbcOperations jdbcOperations;
//    @Autowired
//    public JdbcTemplateRepository(JdbcOperations jdbcOperations){
//        this.jdbcOperations = jdbcOperations;
//    }
    public String getUsername(Integer userId){
       return jdbcOperations.queryForObject(sql, String.class,userId);
    }
}
