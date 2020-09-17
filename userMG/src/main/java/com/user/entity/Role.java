package com.user.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private Integer id;

    private String name;

    private List<Permission> permissions;

    private static final long serialVersionUID = 1L;
}