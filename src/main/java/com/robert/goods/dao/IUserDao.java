package com.robert.goods.dao;

import com.robert.goods.bean.User;

/**
 * @author robert
 * @date 2021/5/18 15:14
 */
public interface IUserDao extends IBaseDao<User>{

    User queryUserByPhone(String phone);


}
