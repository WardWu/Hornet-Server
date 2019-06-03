package com.hornet.nest.util;

import com.hornet.nest.model.UserActionDo;
import com.hornet.nest.model.dto.UserActionDto;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证类.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class CheckUtil {

    /**
     * 手机号码正则校验.
     */
    public static boolean checkMobiPhoneNum(String telNum) {
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telNum);
        return matcher.matches();
    }


    /**
     * 前端传递数据校验.
     */
    public static UserActionDo checkUserAction(UserActionDto userActionDto) {
        if (userActionDto == null) {
            return null;
        }
        if (StringUtils.isBlank(userActionDto.getAccount())) {
            return null;
        }
        if (StringUtils.isBlank(userActionDto.getPassword())) {
            return null;
        }
        if (StringUtils.isBlank(userActionDto.getType())) {
            return null;
        }
        UserActionDo result = new UserActionDo();
        result.setPassword(userActionDto.getPassword());
        String type = userActionDto.getType();
        String account = userActionDto.getAccount();
        switch (type) {
            case "01":
                result.setUserId(account);
                break;
            case "02":
                result.setPhoneNum(account);
                break;
            case "03":
                result.setMail(account);
                break;
            case "04":
                result.setPhoneNum(account);
                break;
            case "05":
                result.setUserCode(account);
                break;
            default:
                return null;
        }
        return result;
    }

}
