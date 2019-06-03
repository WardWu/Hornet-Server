package com.hornet.nest.model;

import java.io.Serializable;

/**
 * 基础 model.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class UserBaseDo implements Serializable {

    /**
     * 用户ID(随机).
     */
    private String userId;

    /**
     * 昵称.
     */
    private String nickName;

    /**
     * 邮箱.
     */
    private String mail;

    /**
     * 手机.
     */
    private String phone;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
