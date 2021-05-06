package com.robert.goods.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/session")
@RestController
public class SpringSession {
    private Logger logger = Logger.getLogger(SpringSession.class);

    @Value("${server.port}")
    Integer port;

    @RequestMapping("/setSession")
    public String setSession(HttpSession session){
        session.setAttribute("test","测试+");
        return String.valueOf(port);
    }
    @RequestMapping("/getSession")
    public String getSession(HttpSession session){
        return session.getAttribute("test")+":"+port;
    }
}
