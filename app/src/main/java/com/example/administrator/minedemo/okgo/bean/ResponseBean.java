package com.example.administrator.minedemo.okgo.bean;

import java.io.Serializable;

/**
 * Created by ccb on 2017/10/11.
 *
 */


public class ResponseBean<T> implements Serializable {

    public boolean isSuccess;
    public String message;
    public T resultData;


}