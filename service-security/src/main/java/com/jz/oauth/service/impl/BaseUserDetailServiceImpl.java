package com.jz.oauth.service.impl;

import com.jz.oauth.bean.SecurityUser;
import com.jz.oauth.bean.SysUser;
import com.jz.oauth.utils.BCryptUtil;
import com.jz.oauth.utils.CreateHardRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/14
 */
@Service
public class BaseUserDetailServiceImpl implements UserDetailsService {
    private Logger log = LoggerFactory.getLogger(BaseUserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("获取登录信息:" + username);
        // todo : 此处验证user是否合法性, 从db中获取！
        //  这里就做简单的判断验证就好了。
        String user = "test";
        if (!user.equals(username)) {
            log.error("找不到{}用户!", username);
            throw new UsernameNotFoundException("找不到用户! " + username);
        }
        // 对密码进行编码
        String password = BCryptUtil.encoder("123456");
        List<GrantedAuthority> authorities = CreateHardRole.createAuthorities().get();
        // 将用户相关信息交给security
        SysUser sysUser = new SysUser();
        sysUser.setAuthorities(authorities);
        sysUser.setPassword(password);
        sysUser.setUsername(username);
        return new SecurityUser(sysUser);
    }
}
