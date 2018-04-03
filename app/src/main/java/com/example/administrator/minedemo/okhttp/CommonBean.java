package com.example.administrator.minedemo.okhttp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public class CommonBean {

    /**
     *
     */
    private static final long serialVersionUID = -3440061414071692254L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 数据
     */
    private String resultData;

    public Boolean isIsSuccess() {
        return success;
    }

    public void setSuccess(Boolean isSuccess) {
        this.success = isSuccess;
    }

    public String getData() {
        return resultData;
    }

    public void setData(String resultData) {
        this.resultData = resultData;
    }
}