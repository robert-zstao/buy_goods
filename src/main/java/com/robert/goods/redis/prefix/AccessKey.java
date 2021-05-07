package com.robert.goods.redis.prefix;

import com.robert.goods.redis.BasePrefix;

/**
 * @Description:接口限流防刷的redis-key
 */
public class AccessKey extends BasePrefix {

    private AccessKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    // 创建一个AccessKey：过期时间为expireSeconds， 前缀为className+prefix=AccessKey:access
    public static AccessKey withExpire(int expireSeconds) {
        return new AccessKey(expireSeconds, "access");
    }

}

