package com.example.mystore.core;

import lombok.Data;

@Data
public class Result {
    private boolean success;    // 操作是否成功
    private String message;     // 提示信息
    private Object data;       // 返回的数据
    
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}