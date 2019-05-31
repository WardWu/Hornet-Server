package com.hornet.nest.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 公共工具类.
 * Author： shengwu
 * DATE ：  2019/3/7
 */
public class CommonUtil {

    //盐，用于混交md5
    private static final String slat = "00Q$Q%**^**Q@Q#00";


    /**
     * 不可逆加密.
     */
    public static String md5Encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte bytes[] = md5.digest();
            StringBuilder result = new StringBuilder();
            for (byte value : bytes) {
                result.append(Integer.toHexString((0x000000FF & value) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
