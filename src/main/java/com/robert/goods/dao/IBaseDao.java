package com.robert.goods.dao;

import com.robert.goods.bean.User;

import java.util.List;

/**
 * @Author robert
 * @Date 2021/3/31 16:14
 * @Version 1.0
 */
public interface IBaseDao<T> {

    int addInfo(T t);

    int deleteInfo(int fdId);

    int updateInfo(T t);

    T queryById(int fdId);

    T queryById(T t);

    List<T> queryByList(User user, T t);

}
