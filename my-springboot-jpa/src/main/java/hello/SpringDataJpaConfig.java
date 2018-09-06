package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/22 13:13  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
@EnableJpaRepositories(basePackages="hello")
public class SpringDataJpaConfig {
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        //spring-jdbc
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/demo_spring");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }
//    @Bean
//    public HibernateJpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.MYSQL);
//        adapter.setShowSql(false);
//        adapter.setGenerateDdl(true);
//        return adapter;
//    }
}
