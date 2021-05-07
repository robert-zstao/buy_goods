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
@Builder
public class Message implements Cloneable{
    private String code;
    private Object data;
    private String message;
    private Long total;


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
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
