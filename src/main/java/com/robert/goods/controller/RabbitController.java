package com.robert.goods.controller;

import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;
import com.robert.goods.rabbit.GoodMessage;
import com.robert.goods.utils.JsonUtil;
import com.robert.goods.utils.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author robert
 * @date 2021/4/15 11:58
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController extends BaseController{


    @GetMapping("/test")
    public Message test(){
        Message message = new Message();
        for(int i = 0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取当前线程的名称
                    String name=Thread.currentThread().getName();
                    GoodMessage goodMessage = new GoodMessage();
                    int count = RandomUtils.getRandom(100);
                    System.out.println("商品i为："+count);
                    goodMessage.setGoodsId(count);
                    User user = new User();
                    user.setId(count);
                    goodMessage.setUser(user);

                    myProducer.sendTopic(JsonUtil.beanToStr(goodMessage));
                }
            }).start();
        }
        return message;
    }
}
