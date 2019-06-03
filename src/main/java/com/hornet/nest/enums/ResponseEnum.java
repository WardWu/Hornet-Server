package com.hornet.nest.enums;

/**
 * 请求返回状态枚举.
 *
 * @author: shengwu
 * @date: 2019/6/3
 */
public enum ResponseEnum {

    /**
     * success.
     */
    SUCCESS("200", "success"),

    /**
     * 服务异常.
     */
    SERVER_ERROR("201", "server error"),

    /**
     * 数据库异常.
     */
    DB_SERVER("202", "db error"),


    /**
     * 参数异常.
     */
    PARAM_ERROR("301", "param error");

    /**
     * 状态码.
     */
    private String code;

    /**
     * 请求信息.
     */
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
