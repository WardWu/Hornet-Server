package com.hornet.nest.model;

import java.io.Serializable;

/**
 * 基础.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
public class BaseDo implements Serializable {

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
