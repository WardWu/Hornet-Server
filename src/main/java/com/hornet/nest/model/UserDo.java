package com.hornet.nest.model;

import java.io.Serializable;
import java.util.List;

/**
 * 用户基础信息.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class UserDo extends UserBaseDo implements Serializable {

    /**
     * 地址.
     */
    private String address;

    /**
     * 真实姓名.
     */
    private String userName;

    /**
     * 身份证(固定唯一).
     */
    private String userCode;

    /**
     * 身份证照片.
     */
    private List<BaseDo> userImg;

    /**
     * 头像地址.
     */
    private String headPortrait;

    /**
     * 性别.
     */
    private String sex;

    /**
     * 年龄.
     */
    private Integer age;

    /**
     * 邀请码.
     */
    private String invitationCode;

    /**
     * 用户角色等级.
     */
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<BaseDo> getUserImg() {
        return userImg;
    }

    public void setUserImg(List<BaseDo> userImg) {
        this.userImg = userImg;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
}
