package com.aifurion.blog.Utils;

import java.util.Random;

/**
 * @author: zzy
 * @description: TODO
 * @date: 2021/3/23 10:58
 * @Param: null
 */

public class SaltUtils {

    /**
     * @author: zzy
     * @description: 产生随机盐工具类
     * @date: 2021/3/23 20:12
     * @Param: null
     */
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            builder.append(aChar);
        }
        return builder.toString();
    }
}
