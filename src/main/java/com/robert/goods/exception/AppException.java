package com.robert.goods.exception;

import com.robert.goods.bean.vo.Message;

/**
 * 自定义异常类
 * @Author robert
 * @Date 2021/3/24 15:44
 * @Version 1.0
 */
public class AppException extends RuntimeException{


    private static final long serialVersionUID = 5505917702452570234L;

    private String code;

    private String msg;

    private Message message;

    public AppException(String code,String message){
        this.code = code;
        this.msg = message;
    }
    public AppException(String code){
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }
}
