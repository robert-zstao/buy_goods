package com.robert.goods.service.impl;

import com.robert.goods.dao.IUserDao;
import com.robert.goods.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author robert
 * @date 2021/5/18 15:24
 */
@Service
public class BaseService {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected RedisService redisService;
}
