package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author:wells
 * @since:2020/9/7
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Code {
    OK("00000","一切正常，处理成功"),
    NULL_ARG("A0410","必填参数为空"),
    ERROR_OPERATION("A0440","用户操作异常");
    /**
     * 状态码
     */
    private String code;

    /**
     * 状态码对应的中文含义
     */
    private String message;


}
