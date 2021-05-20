package com.robert.goods.controller;


import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;
import com.robert.goods.exception.AppException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private Logger logger = Logger.getLogger(UserController.class);

    /**
     * 添加用户
     * @robert
     * @date 2020.09.09
     * @return
     */
    @PostMapping("/insertUser")
    public Message insertUser(@RequestParam(value = "phone", required = true) String phone,
                                     @RequestParam(value = "password", required = true) String password,
                                     @RequestParam(value = "name", required = false) String name

    ){
        Message message = new Message();
        try {
            User user = new User();
            user.setName(name);
            user.setPhone(phone);
            user.setPassword(password);
            int count = userService.addInfo(user);
            if(count > 0){
                message.setCode("200");
                message.setMessage("新增成功");
            }else{
                message.setCode("500");
                message.setMessage("新增失败");
            }
        }catch (AppException a){

            message.setData(a.getCode());
            message.setMessage(a.getMsg());
        } catch (Exception e){
            e.printStackTrace();
            message.setCode("500");
            message.setMessage("系统异常！");
        }
        return message;
    }


}
