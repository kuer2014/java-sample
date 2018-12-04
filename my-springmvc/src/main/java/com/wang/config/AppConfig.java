package com.wang.config;

//import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/17 14:24  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
public class  AppConfig {
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        //c3p0
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClass("com.mysql.jdbc.Driver");
//        driverManagerDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo1");
//        driverManagerDataSource.setUser("root");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;

          //spring-jdbc
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo1");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }
}
