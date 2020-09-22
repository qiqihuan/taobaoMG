package com.huanjava.taobao.user.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Permission implements Serializable {
    private Integer id;

    private String uri;

    private String name;

    private Boolean create;

    private Boolean retrieve;

    private Boolean update;

    private Boolean delete;

    private static final long serialVersionUID = 1L;
}