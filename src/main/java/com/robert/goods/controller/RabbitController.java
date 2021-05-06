package com.robert.goods.controller;

import com.robert.goods.bean.vo.Message;
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
                    myProducer.sendMsg("这是第"+name+":个测试！！！");
                }
            }).start();
        }
        return message;
    }
}
