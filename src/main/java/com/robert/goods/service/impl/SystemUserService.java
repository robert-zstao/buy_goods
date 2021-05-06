package com.robert.goods.service.impl;


import com.robert.goods.service.ISystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


/**
 * @author robert
 * @className UserService
 * @date 2020/9/1
 * @description
 */
@Service
@Configurable
public class SystemUserService implements ISystemUserService {

    Logger logger = LoggerFactory.getLogger(getClass());



  /*  @Override
    public Message selectByCorp(SystemUser user, String userId, String userName, String userPhone, int page, int limit) {
        Message message = new Message();
        PageHelper.startPage(page, limit);
        List<SystemUser> systemUsers = systemUserDao.selectByCorp(user, user.getFdCorpId(), userId, userName, userPhone);
        PageInfo<SystemUser> pageInfo = new PageInfo<SystemUser>(systemUsers);
        message.setCode("200");
        message.setData(pageInfo.getList());
        message.setTotal(pageInfo.getTotal());
        return message;
    }*/


}
