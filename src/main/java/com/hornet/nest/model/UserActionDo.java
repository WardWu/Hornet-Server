package com.hornet.nest.model;

import java.io.Serializable;

/**
 * 用户登录.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class UserActionDo implements Serializable {

    /**
     * 手机号.
     */
    private String phoneNum;

    /**
     * 邮箱.
     */
    private String mail;

    /**
     * 用户账号.
     */
    private String userId;

    /**
     * 密码.
     */
    private String password;

    /**
     * 身份证.
     */
    private String userCode;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
