package com.robert.goods.controller;


import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户登录
     */
     @PostMapping("/login")
    public Message login(HttpServletRequest request, HttpServletResponse response, HttpSession session){
         String phone = request.getParameter("phone");
         String pwd = request.getParameter("password");
         Message message = userService.queryByPhone(response, phone, pwd);
         //验证通过
         //设置session
         return message;
     }


    @PostMapping("/test")
    public Message test(){
        Message message = new Message();
        return message;
    }
}
