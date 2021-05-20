package com.robert.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author robert
 * @date 2021/5/6 17:40
 */
@SpringBootApplication
@EnableTransactionManagement
public class BuyGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuyGoodsApplication.class, args);
    }

}
