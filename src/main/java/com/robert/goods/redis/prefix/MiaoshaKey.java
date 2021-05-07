package com.robert.goods.redis.prefix;

import com.robert.goods.redis.BasePrefix;

/**
 * @Description:用于秒杀商品过程中记录哪些商品被秒杀完了的redis-key
 */
public class MiaoshaKey extends BasePrefix {

    // 不让外部篡改
    private MiaoshaKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    // 创建一个MiaoshaKey：永不过期， 前缀为className+prefix=MiaoshaKey:over
    public static MiaoshaKey isGoodsOver = new MiaoshaKey(0, "over");
    //设置过期时间
    public static MiaoshaKey getMiaoshaPath = new MiaoshaKey(60, "path");
    public static MiaoshaKey getMiaoshaVerifyCode = new MiaoshaKey(300, "verifyCode");
}
