package com.robert.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 5883208389725905601L;

    private int id;

    private String name;

    private String password;

    private String salt;

    private String token;

    private String phone;

    private String createDate;

}
