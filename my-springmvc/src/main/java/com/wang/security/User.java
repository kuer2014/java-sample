package com.wang.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/16 15:52  by  王帅（wangshuai@cloud-young.com）创建
 */
public class User implements UserDetails {
    public User() {
    }
    private Collection<GrantedAuthority> authorities;
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
      //权限列表
        this.authorities = authorities;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    private String password="pwd";
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    private String username="ww";
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    private boolean isAccountNonExpired=true;
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }
    private boolean isAccountNonLocked =true;
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }
    private boolean isCredentialsNonExpired=true;
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }
    private boolean isEnabled=true;
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }






}
