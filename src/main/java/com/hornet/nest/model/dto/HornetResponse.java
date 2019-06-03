package com.hornet.nest.model.dto;

import com.hornet.nest.enums.ResponseEnum;

import java.io.Serializable;

/**
 * 统一返回参数.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class HornetResponse<T extends Serializable> implements Serializable {

    /**
     * 错误码.
     */
    private String code = "200";

    /**
     * 错误信息.
     */
    private String message = "OK";

    /**
     * 数据内容.
     */
    private T data;


    /**
     * 接口调用异常.
     *
     * @param code    错误码.
     * @param message 错误信息.
     */
    public HornetResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 接口调用正常.
     *
     * @param data 返回的数据.
     */
    public HornetResponse(T data) {
        this.data = data;
    }

    /**
     * 默认构造函数.
     */
    public HornetResponse() {
    }

    /**
     * 默认构造函数.
     */
    public HornetResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }


    /**
     * 默认构造函数.
     */
    public HornetResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
