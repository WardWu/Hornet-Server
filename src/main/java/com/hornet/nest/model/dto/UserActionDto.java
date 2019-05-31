package com.hornet.nest.model.dto;

import java.io.Serializable;

/**
 * 登录实体.
 * Author： shengwu
 * DATE ：  2018/11/22
 */
public class UserActionDto implements Serializable {

    /**
     * 账号：邮箱、手机、自定义账号.
     */
    private String account;

    /**
     * 密码.
     */
    private String password;

    /**
     * 验证码.
     */
    private String code;

    /**
     * 账号类型.
     */
    private String type;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
