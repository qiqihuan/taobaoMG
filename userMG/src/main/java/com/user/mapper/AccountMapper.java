package com.user.mapper;

import com.user.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountMapper继承基类
 */
@Mapper
@Repository
public interface AccountMapper extends MyBatisBaseDao<Account, Integer, AccountExample> {
    List<Account> selectByPermission();

    Account findByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}