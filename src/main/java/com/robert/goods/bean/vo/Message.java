package com.robert.goods.bean.vo;

import com.robert.goods.utils.SystemCode;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 此处使用原型模式只是为了测试，具体业务中没有必要使用Message 的原型模式
 * 因为 new 比 clone 快
 * 推荐在具有数据库操作的时候使用原型模式，减少数据库开销
 */
@Data
@NoArgsConstructor
public class Message implements Cloneable{
    private String code; //请求状态码
    private Object data; //需要返回的数据
    private String message; //需要返回的提示信息
    private Long total; //数据列表的数量
    //在toString方法中使用JSON格式
    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


    public Message(String code,String message){
       this.code = code;
       this.message = message;
    }
    /**
     * 成功时候的调用
     */
    public static Message success() {

        return SystemCode.SUCCESS;
    }

    /**
     * 失败时候的调用
     */
    public static Message error() {
        return SystemCode.ERROR;
    }

    public static Message error(Message message) {
        return message;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
