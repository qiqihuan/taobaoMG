package com.user.mapper;

import com.user.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * MenuMapper继承基类
 */
@Mapper
@Repository
public interface MenuMapper extends MyBatisBaseDao<Menu, Integer, MenuExample> {
}