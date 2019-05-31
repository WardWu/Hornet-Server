package com.hornet.nest.dao.impl;

import com.hornet.nest.dao.UserDao;
import com.hornet.nest.model.UserActionDo;
import com.hornet.nest.model.UserDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户数据处理实现层.
 * Author： shengwu
 * DATE ：  2019/3/7
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String TABLE_USER = "user_tbl";

    /**
     * 添加用户.
     */
    @Override
    public boolean addUser(UserActionDo userActionDo) {
        List<Object> arg = new ArrayList<>();
        arg.add(userActionDo.getUserId());
        arg.add(userActionDo.getUserCode());
        arg.add(userActionDo.getMail());
        arg.add(userActionDo.getPhoneNum());
        arg.add(userActionDo.getPassword());
        arg.add(new Date());
        String sql = String.format(" INSERT INTO %s ( user_id, user_code, user_mail,  phone_num, password, "
                + " create_time )  VALUE (?,?,?,?,?,?) ", TABLE_USER);
        return jdbcTemplate.update(sql, arg.toArray()) > 0;
    }

    /**
     * 根据账号密码获取用户id.
     */
    @Override
    public String getUserId(UserActionDo userActionDo) {
        StringBuilder sql = new StringBuilder()
                .append(" SELECT user_id FROM ")
                .append(TABLE_USER)
                .append(" WHERE password = ? ");
        List<Object> arg = new ArrayList<>();
        arg.add(userActionDo.getPassword());
        if (StringUtils.isNotBlank(userActionDo.getUserCode())) {
            sql.append(" AND user_code =  ?");
            arg.add(userActionDo.getUserCode());
        }
        if (StringUtils.isNotBlank(userActionDo.getMail())) {
            sql.append(" AND user_mail =  ?");
            arg.add(userActionDo.getUserCode());

        }
        if (StringUtils.isNotBlank(userActionDo.getPhoneNum())) {
            sql.append(" AND phone_num =  ?");
            arg.add(userActionDo.getPhoneNum());
        }
        sql.append( " AND flag = 1 LIMIT 1 " );
        return jdbcTemplate.queryForObject(sql.toString(), arg.toArray(), String.class);
    }

    /**
     * 更新密码.
     */
    @Override
    public boolean updateUserPassword(UserActionDo userActionDo) {
        StringBuilder sql = new StringBuilder();
        List<Object> arg = new ArrayList<>();
        sql.append(" UPDATE ").append(TABLE_USER).append(" SET password = ? WHERE flag = 1 " );
        arg.add(userActionDo.getPassword());
        if (StringUtils.isNotBlank(userActionDo.getPhoneNum())) {
            sql.append(" AND  phone_num = ? ");
            arg.add(userActionDo.getPhoneNum());
        }
        if (StringUtils.isNotBlank(userActionDo.getMail())) {
            sql.append(" AND  mail = ? ");
            arg.add(userActionDo.getMail());
        }
        if (StringUtils.isNotBlank(userActionDo.getUserCode())) {
            sql.append(" AND  user_code = ? ");
            arg.add(userActionDo.getUserCode());
        }
        if (StringUtils.isNotBlank(userActionDo.getUserId())) {
            sql.append(" AND  user_id = ? ");
            arg.add(userActionDo.getUserId());
        }
        sql.append( " LIMIT 1 ");
        return jdbcTemplate.update(sql.toString(), arg.toArray()) > 0;
    }

    /**
     * 根据userId获取用户信息.
     */
    @Override
    public UserDo getUser(String userId) {
        return null;
    }
}
