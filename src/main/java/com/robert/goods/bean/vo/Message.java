package com.robert.goods.bean.vo;

import com.robert.goods.utils.StateCode;

/**
 * 此处使用原型模式只是为了测试，具体业务中没有必要使用Message 的原型模式
 * 因为 new 比 clone 快
 * 推荐在具有数据库操作的时候使用原型模式，减少数据库开销
 */
public class Message implements Cloneable{
    private String code;
    private Object data;
    private String message;
    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Message(){
        //更加业务逻辑对对象属性进行复制
    }

    public Message(String code,String message){
        //更加业务逻辑对对象属性进行复制
       this.code = code;
       this.message = message;
    }
    /**
     * 成功时候的调用
     */
    public static Message success() {

        return StateCode.SUCCESS;
    }

    /**
     * 失败时候的调用
     */
    public static Message error() {
        return StateCode.ERROR;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
