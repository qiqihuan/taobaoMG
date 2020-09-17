package com.user.mapper;

import com.user.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PermissionMapper继承基类
 */
@Mapper
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}