package com.jz.oauth.bean;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/14
 */
public class SecurityUser implements UserDetails, CredentialsContainer {

    private final SysUser sysUser;
    private final User user;

    public SecurityUser(SysUser sysUser) {
        this.sysUser = sysUser;
        this.user = new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getAuthorities());
    }

    @Override
    public void eraseCredentials() {
        user.eraseCredentials();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public SysUser getSysUser() {
        return sysUser;
    }
}
