package com.robert.goods.controller;


import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;
import com.robert.goods.bean.vo.PrototypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户登录
     */
     @PostMapping("/login")
    public Message login(HttpServletRequest request, HttpSession session){
         Message message = PrototypeFactory.getMessage();
         String number = request.getParameter("number");
         String pwd = request.getParameter("password");
         User user = new User();
         //用户及权限验证
        user.setId("1");
        user.setNumber("123456");
        user.setName("Admin");
         //验证通过
         //设置session
         message.setMessage("登录成功");

         return message;
     }


    @PostMapping("/test")
    public Message test(){
        Message message = PrototypeFactory.getMessage();
        return message;
    }
}
