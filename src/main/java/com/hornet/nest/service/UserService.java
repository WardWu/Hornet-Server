package com.hornet.nest.service;

import com.hornet.nest.model.UserActionDo;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 用户行为业务处理层.
 * Author： shengwu
 * DATE ：  2019/3/7
 */
public interface UserService {

    /**
     * 用户注册.
     */
    String registered(UserActionDo userActionDo);

    /**
     * 用户登录.
     */
    String login(UserActionDo userActionDo);

    /**
     * 修改密码.
     */
    Boolean updateUserPassword(UserActionDo userActionDo);

    /**
     * 修改个人信息.
     */
    String updateUserInfo();

    /**
     * 账号实名认证.
     */
    String updateUserAuthenticate();


}
