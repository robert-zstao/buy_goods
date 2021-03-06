package com.robert.goods.service.impl;

import com.robert.goods.redis.KeyPrefix;
import com.robert.goods.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 读取
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = JsonUtil.strToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 插入
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = JsonUtil.beanToStr(value);
            if (str == null || str.length() <= 0) {
                return false;
            }
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            int expireSeconds = prefix.expireSeconds();
            if (expireSeconds <= 0) {//永不过期
                jedis.set(realKey, str);
            }else {
                // 设置过期时间
                jedis.setex(realKey, expireSeconds, str);
            }
        } finally {
            returnToPool(jedis);
        }
        return true;
    }

    /**
     * 删除
     */
    public boolean delete(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            Long del = jedis.del(realKey);
            return del>0;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断key是否存在
     */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 将 key 中储存的数字值增一。
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 将 key 中储存的数字值减一。
     * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key = KeyPrefix类(包括实现、子类)的类名:prefix+key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 将其返回连接池
     */
    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
