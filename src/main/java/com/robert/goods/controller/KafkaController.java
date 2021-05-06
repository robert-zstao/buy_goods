package com.robert.goods.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController extends BaseController{



    @GetMapping("/test")
    @Transactional(rollbackFor = Exception.class)
    public void send(){
        //producer.send("这是一条测试数据！");
    }


}
