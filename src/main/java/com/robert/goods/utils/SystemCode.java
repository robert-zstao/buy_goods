package com.robert.goods.utils;

import com.robert.goods.bean.vo.Message;

import java.io.Serializable;

/**
 * 状态码
 */
public class SystemCode implements Serializable {


    private static final long serialVersionUID = -7686875877764432217L;

    //报错
    public static final String NO = "404";
    //失败
    public static final String FAIL = "500";
    //成功
    public static final String  YES = "200";

    public static final String SELECT = "查询";

    public static final String ADD = "添加";

    public static final String UPDATE = "更新";

    public static final String DELETE = "删除";

    /**
     * 登录返回消息
     */
    public final static String LOGIN_MSG_SUCCESS = "登录成功";
    public final static String LOGIN_MSG_NO_USER = "账号或密码错误";
    public final static String LOGIN_MSG_PERMISSION_DENIED = "账号没有登录权限";
    public final static String LOGIN_MSG_USER_DISABLE = "账号已禁用，请联系管理员";

    /**
     * session key
     */
    public final static String SESSION_USER = "admin";

    /**
     * 排序方式
     */
    public final static String ASC = "asc";
    public final static String DESC = "desc";

    public final static String SAVE_SUCCESS = "操作成功";
    public final static String SAVE_FAILED = "操作失败";
    public final static String REMOVE_FAILED = "删除失败";
    public final static String REMOVE_SUCCESS = "删除成功";
    public final static String ASSIGN_SUCCESS = "分配成功";
    public final static String ASSIGN_FAILED = "分配失败";
    public final static String UPDATE_SUCCESS = "修改成功";
    public final static String UPDATE_FAILED = "修改失败";

    public static Message ERROR = new Message("404", "失败");
    // 成功
    public static Message SUCCESS = new Message("200", "成功");

    public static Message SERVER_ERROR = new Message("500", "服务端异常");
    // 参数绑定时异常
    public static Message BIND_ERROR = new Message("500", "参数校验异常：%s");
    // 请求异常
    public static Message REQUEST_ILLEGAL = new Message("500", "请求非法");
    public static Message GET_VERIFY_CODE = new Message("500", "获取验证码失败！");
    public static Message VERIFY_CODE_ERROR = new Message("500", "验证码错误，请重新输入！");
    public static Message ACCESS_LIMIT_REACHED = new Message("400", "访问太频繁！");
    //登录模块
    public static Message SESSION_ERROR = new Message("500", "Session不存在或者已经失效,请重新登录！");
    public static Message PASSWORD_EMPTY = new Message("500", "登录密码不能为空");
    public static Message MOBILE_EMPTY = new Message("500", "手机号不能为空");
    public static Message MOBILE_ERROR = new Message("500", "手机号格式错误");
    public static Message MOBILE_NOT_EXIST = new Message("500", "手机号不存在");
    public static Message PASSWORD_ERROR = new Message("500", "密码错误");

}
