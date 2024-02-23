package com.test.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @ClassName CommunityUtil
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/22 20:14
 * @Version 1.0
 */
public class CommunityUtil {

    // 生成一个随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密：只能加密，不能解密
    // hello + 随机字符串
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
