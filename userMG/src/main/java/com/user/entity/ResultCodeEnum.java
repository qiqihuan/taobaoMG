package com.user.entity;

/**
 * <p>
 *  封装了处理前端请求的状态码
 * </p>
 *
 * @author:wells
 * @since:2020/8/6
 */
public enum ResultCodeEnum {

    SUCCESS("00000","success"),
    FAILED("A410","null param");
    String code;
    String message;

    ResultCodeEnum(String code, String message) {
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















