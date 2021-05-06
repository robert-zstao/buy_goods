package com.robert.goods.controller;


import com.robert.goods.bean.vo.Message;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @GetMapping("/querySubUser")
    public Message querySubUser(@RequestParam(value = "username", required = true) String username,
                                @RequestParam(value = "userId", required = false) String userId,
                                @RequestParam(value = "fdUsername", required = false) String fdUsername,
                                @RequestParam(value = "page", required = false) int page,
                                @RequestParam(value = "limit", required = false) int limit,
                                @RequestParam(value = "userPhone", required = false) String userPhone){
        Message message = new Message();
       // message = userService.selectByCorp(systemUser, userId, fdUsername, userPhone,page,limit);

        return message;
    }

    /**
     * 添加用户
     * @robert
     * @date 2020.09.09
     * @param fdUserId
     * @param fdUserName
     * @param fdEnable
     * @param fdUserPwd
     * @param fdCorpId
     * @param fdPhone
     * @param roleCode
     * @return
     */
    @PostMapping("/insertUser")
    @ResponseBody
    public Message insertUser(@RequestParam(value = "username", required = true) String username,
                                     @RequestParam(value = "fdUserId", required = false) String fdUserId,
                                     @RequestParam(value = "fdUserName", required = false) String fdUserName,
                                     @RequestParam(value = "fdEnable", required = false) String fdEnable,
                                     @RequestParam(value = "fdUserPwd", required = false) String fdUserPwd,
                                     @RequestParam(value = "fdCorpId", required = false) String fdCorpId,
                                     @RequestParam(value = "fdPhone", required = false) String fdPhone,
                                     @RequestParam(value = "roleCode", required = false) String roleCode

    ){
        Message message = new Message();

        try {
            int count = 1;
            //int count = userService.insertUser(user,roleCode);
            if(count == 1){
                message.setCode("200");
                message.setMessage("新增成功");
            }else if(count == 2){
                message.setCode("500");
                message.setMessage("该用户账号已存在！");
            }else{
                message.setCode("500");
                message.setMessage("新增失败");
            }
        }catch (Exception e){
            message.setCode("500");
            message.setMessage("新增失败");
        }
        return message;
    }


}
