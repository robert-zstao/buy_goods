package com.robert.goods.service.impl;

import com.robert.goods.bean.User;
import com.robert.goods.bean.vo.Message;
import com.robert.goods.exception.AppException;
import com.robert.goods.redis.prefix.MiaoshaUserKey;
import com.robert.goods.service.IUserService;
import com.robert.goods.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author robert
 * @date 2021/5/7 16:28
 */
@Service
public class UserService extends BaseService implements IUserService {

    @Override
    public int addInfo(User user) {
        user.setCreateDate(DateUtil.formatDate("yyyyMMddHHmmss",new Date()));

        user.setSalt(RandomUtils.generateString(6));
        //user.setPassword(MD5Util.formPassToDBPass(user.getPassword(), user.getSalt()));
        user.setPassword(MD5Util.inputPassToDbPass(user.getPassword(), user.getSalt()));
        System.out.println(user.getPassword());
        return userDao.addInfo(user);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public User queryById(User user) {
        return null;
    }

    @Override
    public List<User> queryByList(User user, User user2) {
        return null;
    }

    @Override
    public Message queryByPhone(HttpServletResponse response,String phone,String password) {
        User user = userDao.queryUserByPhone(phone);
        if(user.getPhone()==null){
            throw new AppException(SystemCode.FAIL,SystemCode.LOGIN_PHONE_NO_USER);
        }
        //判断密码

        //数据库的密码
        //String dbPass = user.getPassword();
        //数据库的盐
        //String saltDB = user.getSalt();
        //生成两次加密的密码
        //String calcPass = MD5Util.formPassToDBPass(password, saltDB);
        // 对比
        //if (!calcPass.equals(dbPass)) {
          //  throw new AppException(SystemCode.FAIL,SystemCode.LOGIN_MSG_NO_USER);
       // }
        String token = UUIDUtils.getUUID();

        //addCookie(response, token, user);
        user.setToken(token);
        Message message = SystemCode.SUCCESS;
        message.setData(user);
        return message;
    }

    /**
     * 根据token读取秒杀用户信息
     */
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(MiaoshaUserKey.token, token, User.class);
        //延长有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    /**
     * https://blog.csdn.net/tTU1EvLDeLFq5btqiK/article/details/78693323
     */
    @Override
    public Message updatePassword(String token, int id, String formPass) {
        //取user
        User user = this.findOne(id);
        if(user == null) {
            throw new AppException(SystemCode.FAIL,SystemCode.LOGIN_PHONE_NO_USER);
        }
        //更新数据库
        user.setId(id);
        user.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
        userDao.updateInfo(user);
        //处理缓存
        redisService.delete(MiaoshaUserKey.getById, ""+id);
        redisService.set(MiaoshaUserKey.token, token, user);
        Message message = new Message();
        return message;
    }

    /**
     * 添加cookie到response里
     */
    private void addCookie(HttpServletResponse response, String token, User user) {
        // 拼接上cookie作为key，将秒杀用户信息保存到redis中 key=MiaoshaUserKey:tokenxxxxx value:miaoshaUser
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(SystemCode.COOKIE_TOKEN, token);
        // 设置生命周期为MiaoshaUser的redis key的生命周期
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        // 正常一个cookie只能由创建它的应用获得，下面方法可以让这个cookie在同一应用服务器内共享
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
