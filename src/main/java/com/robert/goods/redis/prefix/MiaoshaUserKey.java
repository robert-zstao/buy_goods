package com.robert.goods.redis.prefix;


import com.robert.goods.redis.BasePrefix;

/**
 * @Description:对于秒杀用户的redis-key
 */
public class MiaoshaUserKey extends BasePrefix {

    // 两天有效期
    public static final int TOKEN_EXPIRE_SECONDS = 3600 * 24 * 2;

    // 不让外部篡改
    private MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    // 创建一个UserKey：过期时间为0， 前缀为className+prefix=MiaoshaUserKey:token
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE_SECONDS, "tk");

    // 创建一个UserKey：过期时间为0， 前缀为className+prefix=MiaoshaUserKey:id
    public static MiaoshaUserKey getById = new MiaoshaUserKey(0, "id");
}
