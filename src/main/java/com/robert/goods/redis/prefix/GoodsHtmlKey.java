package com.robert.goods.redis.prefix;

import com.robert.goods.redis.BasePrefix;

/**
 * @Description:(秒杀)商品列表页面实现页面缓存的redis-key
 */
public class GoodsHtmlKey extends BasePrefix {

    // 不让外部篡改
    private GoodsHtmlKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    // 创建一个GoodsHtmlKey：过期时间为60秒， 前缀为className+prefix=GoodsHtmlKey:gl
    public static GoodsHtmlKey getGoodsList = new GoodsHtmlKey(60, "gl");

    // 创建一个GoodsHtmlKey：过期时间为60秒， 前缀为className+prefix=GoodsHtmlKey:gd
    public static GoodsHtmlKey getGoodsDetail = new GoodsHtmlKey(60, "gd");

    // 创建一个GoodsHtmlKey：永不过期， 前缀为className+prefix=GoodsHtmlKey:mgs
    public static GoodsHtmlKey getMiaoshaGoodsStock = new GoodsHtmlKey(0, "mgs");
}
