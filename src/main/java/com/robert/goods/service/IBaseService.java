package com.robert.goods.service;

import com.robert.goods.bean.User;

import java.util.List;

/**
 * @Author robert
 * @Date 2021/3/31 16:24
 * @Version 1.0
 */
public interface IBaseService<T> {

    int addInfo(T t);
    int delete(String id);

    int update(T t);

    T findOne(String id);

    T queryById(T t);

    List<T> queryByList(User user, T t);
}
