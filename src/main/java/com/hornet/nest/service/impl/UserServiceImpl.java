package com.hornet.nest.service.impl;

import com.alibaba.fastjson.JSON;
import com.hornet.nest.dao.UserDao;
import com.hornet.nest.model.UserActionDo;
import com.hornet.nest.service.UserService;
import com.hornet.nest.util.CommonUtil;
import com.hornet.nest.util.SnowflakeKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户行为业务处理实现层.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private SnowflakeKeyUtil snowflakeKeyUtil;
    @Autowired
    private UserDao userDao;

    /**
     * 用户注册.
     */
    @Override
    public String registered(UserActionDo userActionDo) {
        String userId = snowflakeKeyUtil.generateKey().toString();
        userActionDo.setUserId(userId);
        userActionDo.setPassword(CommonUtil.md5Encrypt(userActionDo.getPassword()));
        boolean registered = false;
        try {
            registered = userDao.addUser(userActionDo);
        } catch (Exception e) {
            log.error("registered error, params:{}, error message:{}", JSON.toJSONString(userActionDo), e);
        }
        return registered ? userId : null;
    }

    /**
     * 用户登录.
     */
    @Override
    public String login(UserActionDo userActionDo) {
        userActionDo.setPassword(CommonUtil.md5Encrypt(userActionDo.getPassword()));
        String userId = null;
        try {
            userId = userDao.getUserId(userActionDo);
        } catch (Exception e) {
            log.error("login error, params:{}, error message:{}", JSON.toJSONString(userActionDo), e);
        }
        return userId;
    }

    /**
     * 修改密码.
     */
    @Override
    public Boolean updateUserPassword(UserActionDo userActionDo) {
        userActionDo.setPassword(CommonUtil.md5Encrypt(userActionDo.getPassword()));
        Boolean update = null;
        try {
            update = userDao.updateUserPassword(userActionDo);
        } catch (Exception e) {
            log.error("updateUserPassword error, params:{}, error message:{}", JSON.toJSONString(userActionDo), e);
        }
        return update;
    }

    /**
     * 修改个人信息.
     */
    @Override
    public String updateUserInfo() {
        return null;
    }

    /**
     * 账号实名认证.
     */
    @Override
    public String updateUserAuthenticate() {
        return null;
    }
}
