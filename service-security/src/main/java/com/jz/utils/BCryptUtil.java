package com.jz.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 加密工具
 *
 * @author Jayszxs
 */
@Component
public class BCryptUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    static {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * 加密
     *
     * @return
     */
    public static String encoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * 验证密码
     *
     * @param password
     * @param salt
     * @return
     */
    public static Boolean matches(String password, String salt) {
        return bCryptPasswordEncoder.matches(password, salt);
    }

}