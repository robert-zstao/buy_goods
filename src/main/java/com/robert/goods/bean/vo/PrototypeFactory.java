package com.robert.goods.bean.vo;


import com.robert.goods.utils.StateCode;

/**
 * 原型工厂
 *
 */
public class PrototypeFactory {

    //此处使用饿汉式单例模式 只执行一次构造方法 使用静态是为了保证构造只使用一次.如果使用多次那么和new一个对象没什么区别
    private static Message message = new Message();

    public static Message getMessage() {
        try {
            return  (Message) message.clone();
        }catch (Exception e){
            Message message = new Message();
            message.setCode(StateCode.NO);
            message.setMessage("系统异常");
            return message;
        }
    }

}
