package com.wang.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/16 15:44  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MyLoginService implements UserDetailsService {

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(userName.equals("ww")){
//            com.wang.security.User user= new com.wang.security.User();
//            List authorityList= new ArrayList<GrantedAuthority>();
//            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            user.setAuthorities(authorityList);
//            return user;
            List authorityList= new ArrayList<GrantedAuthority>();
          authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            User u= new User(userName,"pwd",authorityList);
            return u;
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
