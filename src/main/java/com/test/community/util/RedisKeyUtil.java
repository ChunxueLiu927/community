package com.test.community.util;

/**
 * @ClassName RedisKeyUtil
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/25 20:11
 * @Version 1.0
 */

public class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    private static final String PRETIX_USER_LIKE = "like:user";

    // 生成某个实体的赞
    // like:entity:entityType:entityId -> set(userId)
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某个用户的赞
    public static String getUserLikeKey(int userId) {
        return PREFIX_ENTITY_LIKE + SPLIT + userId;
    }

}
