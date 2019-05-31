package com.hornet.nest.controller;

import com.hornet.nest.common.ResponseMeta;
import com.hornet.nest.model.UserActionDo;
import com.hornet.nest.model.dto.HornetResponse;
import com.hornet.nest.model.dto.UserActionDto;
import com.hornet.nest.service.UserService;
import com.hornet.nest.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户行为控制层.
 * @author： shengwu
 * @date ：  2019/3/7
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册.
     */
    @RequestMapping("registered")
    public HornetResponse<String> registered(UserActionDto userActionDto) {
        UserActionDo userActionDo = CheckUtil.checkUserAction(userActionDto);
        if (userActionDo == null) {
            return new HornetResponse<>(ResponseMeta.PARAMS_EXCEPTION_CODE, ResponseMeta.PARAMS_EXCEPTION_MESSAGE);
        }
        String userId = userService.registered(userActionDo);
        if (StringUtils.isBlank(userId)) {
            return new HornetResponse<>(ResponseMeta.SERVER_EXCEPTION_CODE, ResponseMeta.SERVER_EXCEPTION_MESSAGE);
        }
        return new HornetResponse<>(userId);
    }

    /**
     * 用户登录.
     */
    @RequestMapping("login")
    public HornetResponse<String> login(UserActionDto userActionDto) {
        UserActionDo userActionDo = CheckUtil.checkUserAction(userActionDto);
        if (userActionDo == null) {
            return new HornetResponse<>(ResponseMeta.PARAMS_EXCEPTION_CODE, ResponseMeta.PARAMS_EXCEPTION_MESSAGE);
        }
        String userId = userService.login(userActionDo);
        return new HornetResponse<>(userId);
    }




    /**
     * 账号实名认证.
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return "Hello Spring Boot !";
    }

    /**
     * 修改密码.
     */
    @RequestMapping("password.update")
    public HornetResponse<Boolean> updateUserPassword(UserActionDto userActionDto) {
        UserActionDo userActionDo = CheckUtil.checkUserAction(userActionDto);
        if (userActionDo == null) {
            return new HornetResponse<>(ResponseMeta.PARAMS_EXCEPTION_CODE, ResponseMeta.PARAMS_EXCEPTION_MESSAGE);
        }
        boolean update = userService.updateUserPassword(userActionDo);
        return new HornetResponse<>(update);
    }


    /**
     * 修改个人信息.
     */
    @RequestMapping("info.update")
    public String updateUserInfo() {
        return "Hello Spring Boot !";
    }

    /**
     * 账号实名认证.
     */
    @RequestMapping("authenticate")
    public String updateUserAuthenticate() {
        return "Hello Spring Boot !";
    }
}
