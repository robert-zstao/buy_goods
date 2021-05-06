package com.robert.goods.utils;

import java.util.UUID;

public class UUIDUtils {
    /**
     *
     * 通过jdk自带的uuid生成器生成36位的uuid；
     */
    public static String getUUID() {
        // 使用JDK自带的UUID生成器
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     *
     * 通过jdk自带的uuid生成器生成36位的uuid；线程安全
     */
    public static synchronized String getOneUUID() {
        // 使用JDK自带的UUID生成器
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
