package com.robert.goods.bean.vo;

import java.util.Arrays;


public class UserVo {
    private String[] roles;
    private String introduction;
    private String avatar;
    private String name;
    private String token;
    private String corpId;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setAvatar(String avatar) {
            this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "roles=" + Arrays.toString(roles) +
                ", introduction='" + introduction + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
