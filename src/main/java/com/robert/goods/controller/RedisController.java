package com.robert.goods.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = Logger.getLogger(RedisController.class);
//    @Autowired
//    private RedisUtil redisUtil;
//    @GetMapping("/get")
//    public Message getRedis(){
//        Message message = PrototypeFactory.getMessage();
//        Object robert = redisUtil.get("robert");
//        message.setData(robert);
//        message.setCode(StateCode.YES);
//        return message;
//    }
//
//
//    @GetMapping("/set")
//    public Message setRedis(){
//        Message message = PrototypeFactory.getMessage();
//        boolean b = redisUtil.set("robert", "java开发工程师", 100000);
//        message.setCode(StateCode.YES);
//        return message;
//    }
}
