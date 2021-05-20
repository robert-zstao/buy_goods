package com.robert.goods.dao.impl;

import com.robert.goods.bean.User;
import com.robert.goods.dao.BaseDao;
import com.robert.goods.dao.IUserDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robert
 * @date 2021/5/18 15:17
 */
@Repository
public class UserDao extends BaseDao implements IUserDao {

    private static final String NAMESPACE = "com.robert.goods.UserDao.";

    @Override
    public User queryUserByPhone(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phone", phone);
        User user = this.getSqlSession().selectOne(NAMESPACE + "queryUserByPhone", params);
        //因为业务层需要经常判断user==null，造成代码冗余，直接返回一个空的，减少一层判断
        return user==null?new User():user;
    }

    @Override
    public int addInfo(User user) {
        return this.getSqlSession().insert(NAMESPACE + "addInfo", user);
    }

    @Override
    public int deleteInfo(int fdId) {

        return this.getSqlSession().delete(NAMESPACE + "deleteInfo", fdId);
    }

    @Override
    public int updateInfo(User user) {
        return this.getSqlSession().update(NAMESPACE + "updateInfo", user);
    }

    @Override
    public User queryById(int fdId) {
        return this.getSqlSession().selectOne(NAMESPACE + "queryById", fdId);
    }

    @Override
    public User queryById(User user) {
        return this.getSqlSession().selectOne(NAMESPACE + "selectByPrimaryKey", user);
    }

    @Override
    public List<User> queryByList(User user, User user2) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user", user);
        List<User> list = this.getSqlSession().selectList(NAMESPACE + "queryByList", params);
        return list.isEmpty()?new ArrayList<>():list;
    }
}
