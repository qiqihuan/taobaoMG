package com.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.entity.Permission;
import com.user.mapper.PermissionExample;
import com.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限管理的service层
 * </p>
 *
 * @author:wells
 * @since:2020/9/12
 */
@Service
public class PermissionService {

    @Autowired
    PermissionMapper perMapper;

    public PageInfo<Permission> findPage(int pageNumber, int pageSize) {

        PageHelper.startPage(pageNumber,pageSize);
        PermissionExample example = new PermissionExample();
        List<Permission> permissionList = perMapper.selectByExample(example);
        return new PageInfo<Permission>(permissionList);

    }

    public Permission findById(int id) {
        Permission permission = perMapper.selectByPrimaryKey(id);
        return permission;
    }

    public int update(Permission permission) {

        return perMapper.updateByPrimaryKeySelective(permission);
    }

    public int add(Permission permission) {

        return perMapper.insert(permission);
    }

    public List<Permission> findAll() {
        PermissionExample example = new PermissionExample();
        return perMapper.selectByExample(example);
    }
}
