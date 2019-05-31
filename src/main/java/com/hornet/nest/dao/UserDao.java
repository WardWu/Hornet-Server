package com.hornet.nest.dao;

import com.hornet.nest.model.UserActionDo;
import com.hornet.nest.model.UserDo;

/**
 * 用户数据处理层.
 * Author： shengwu
 * DATE ：  2019/3/7
 */
public interface UserDao {

    /**
     * 添加用户.
     */
    boolean addUser(UserActionDo userActionDo);

    /**
     * 根据账号密码获取用户id.
     */
    String getUserId(UserActionDo userActionDo);

    /**
     * 更新密码.
     */
    boolean updateUserPassword(UserActionDo userActionDo);

    /**
     * 根据userId获取用户信息.
     */
    UserDo getUser(String userId);
}
