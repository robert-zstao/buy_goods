package com.robert.goods.service;

import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;

import javax.servlet.http.HttpServletResponse;

/**
 * @author robert
 * @date 2021/5/7 16:28
 */
public interface IUserService extends IBaseService<User> {

    Message queryByPhone(HttpServletResponse response,String phone, String password);

    Message updatePassword(String token, int id, String formPass);
}
