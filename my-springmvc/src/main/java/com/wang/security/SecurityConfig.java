package com.wang.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/16 10:39  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        //1、基本认证
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
        //2、按路径
        http
                .authorizeRequests()
                //.antMatchers("/ad/").authenticated()
                .antMatchers("/ad/").permitAll()
               // .antMatchers("/ad/**","/ex/").authenticated() //antMatchers()支持ant通配符，支持传多个路径参数
                .antMatchers(HttpMethod.GET,"/ad/calc/").authenticated()
                //.regexMatchers("/ad/.*").authenticated() // 正则表达式
                //.antMatchers().access("hasRole('ROLE_ADMIN') and hasIpAddress('192.168.1.12')")//access()方法与SpEl表达式
                .and()  //and()相当于xml文件中的结束标签
                .csrf().disable() //关闭CSRF
                .formLogin().and()// 表单登录
                //.loginPage("/loginPage").and()// 指定登录页
                .logout()
                .logoutUrl("sigout") //指定退出页
                .logoutSuccessUrl("/")//指定退出成功跳转页
                .and()
                .rememberMe().tokenValiditySeconds(2419200).key("rmkey") //记住我

               // .and().httpBasic() //浏览器弹窗
//        .and()
//        .requiresChannel()
//        .antMatchers("/ex1/**").requiresSecure() //转为https通道
//        //.antMatchers("").requiresInsecure()//转到http通道
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1、基于内存的用户认证
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("pwd").roles("USER").and()
//                .withUser("admin").password("pwd").roles("USER", "ADMIN");
//        //2、基于JDBC连接数据库 未成功
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
        .usersByUsernameQuery("SELECT user_name,pass_word from user\n" +
                "WHERE user_name=?")
        .authoritiesByUsernameQuery("SELECT user_name,'ROLE_USER' from user\n" +
                "WHERE user_name=?");
        //3、自定义的用户服务  未成功
//auth
//        //.authenticationProvider(authenticationProvider) //DaoAuthenticationProvider
//
//        .userDetailsService(new MyLoginService());

    }
}
