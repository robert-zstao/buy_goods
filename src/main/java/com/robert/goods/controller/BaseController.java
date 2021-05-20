package com.robert.goods.controller;


import com.robert.goods.kafka.Producer;
import com.robert.goods.rabbit.MyProducer;
import com.robert.goods.service.IAsyncService;
import com.robert.goods.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {
    /* 数据存储 */
    protected Map<String, Object> info = new HashMap<String, Object>();

    @Autowired
    protected IUserService userService;

    @Autowired
    protected IAsyncService asyncService;

    //kafka 的生产者
//    @Autowired
//    protected Producer producer;

    //rabbitMQ 的生产者
    @Autowired
    protected MyProducer myProducer;
}
