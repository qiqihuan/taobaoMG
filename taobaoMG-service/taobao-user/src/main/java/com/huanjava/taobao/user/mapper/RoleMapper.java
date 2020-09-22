package com.huanjava.taobao.user.mapper;

import com.huanjava.taobao.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * RoleMapper继承基类
 */
@Mapper
@Repository
public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
    void addRolePermission(Map map);

    Role findById(int id);
}