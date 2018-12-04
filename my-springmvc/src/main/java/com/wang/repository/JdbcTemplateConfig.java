package com.wang.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/18 17:38  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
public class JdbcTemplateConfig {
    @Autowired
    private DataSource dataSource;
    @Bean(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
