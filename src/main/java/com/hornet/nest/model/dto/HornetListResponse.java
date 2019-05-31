package com.hornet.nest.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 统一返回参数.
 * Author： shengwu
 * DATE ：  2019/3/8
 */
public class HornetListResponse<T extends Serializable> implements Serializable {

    /**
     * 总数据记录数.
     */
    private long total = 0L;

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
    private List<T> data;

    /**
     * 接口调用异常.
     *
     * @param code    错误码.
     * @param message 错误信息.
     */
    public HornetListResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 接口调用正常返回.
     *
     * @param total 总数
     * @param data  数据
     */
    public HornetListResponse(long total, List<T> data) {
        this.total = total;
        this.data = data;
    }


    /**
     * 接口调用正常返回.
     *
     * @param data 数据
     */
    public HornetListResponse(List<T> data) {
        this.data = data;
    }

    /**
     * 默认构造函数.
     */
    public HornetListResponse() {
    }

    /**
     * 默认构造函数.
     */
    public HornetListResponse(String code, String message, long total, List<T> data) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
