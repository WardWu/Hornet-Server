package com.hornet.nest.model;

import java.io.Serializable;

/**
 * 虚拟币.
 * Author： shengwu
 * DATE ：  2018/11/22
 */
public class VirtualCurrencyModel implements Serializable {

    /**
     * 唯一编码.
     */
    private String code;

    /**
     * 名称.
     */
    private String name;

    /**
     * 价格.
     */
    private float price;

    /**
     * 时间.
     */
    private String date;

    /**
     * 总量.
     */
    private String count;

    /**
     * 创建时间.
     */
    private String createTime;

    /**
     * 更新时间.
     */
    private String updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "VirtualCurrencyModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", count='" + count + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
