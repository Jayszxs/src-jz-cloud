package com.jz.bean;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/14
 */
public class SysUser {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
