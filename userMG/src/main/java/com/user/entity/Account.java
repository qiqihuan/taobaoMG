package com.user.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Account implements Serializable {
    private Integer id;

    private String loginName;

    private String password;

    private String nickName;

    private Short age;

    private String location;

    private String role;

    // 角色
    private List<Role> roleList;

    // 具体的权限
    private List<Permission> permissionList;

    private static final long serialVersionUID = 1L;
}