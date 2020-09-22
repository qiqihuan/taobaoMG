package com.huanjava.taobao.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 返回的数据封装
 * </p>
 *
 * @author:wells
 * @since:2020/9/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{

    /**
     * 状态码
     */
    private String code;

    /**
     * 需要带给前端的数据
     */
    private T data;

    /**
     * 消息说明
     */
    private String message;


    /**
     * 一般方法
     * @param code 状态码
     * @param data 返回数据
     * @param message 消息
     * @return 返回对象
     */
    public static <T> Result buildResult(String code, T data, String message){
        return new Result<T>(code,data,message);
    }

    /**
     * 封装好的正常返回结果的方法
     * @param data 返回数据
     * @return 一切ok的返回对象
     */
    public static <T> Result buildOkResult (T data){
        return new Result<T>(Code.OK.getCode(),data,Code.OK.getMessage());
    }

}
