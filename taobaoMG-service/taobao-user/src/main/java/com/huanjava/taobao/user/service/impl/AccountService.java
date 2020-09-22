package com.huanjava.taobao.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanjava.taobao.user.mapper.AccountExample;
import com.huanjava.taobao.user.mapper.AccountMapper;
import com.huanjava.taobao.user.entity.Account;
import com.huanjava.taobao.user.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 明哥用户管理系统业务层
 * </p>
 *
 * @author:wells
 * @since:2020/9/9
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accMapper;


    public Account findByLoginNameAndPassword(String loginName, String password) {


        return accMapper.findByLoginNameAndPassword(loginName,password);
    }




    public PageInfo<Account> findPage(int pageNumber, int pageSize) {


        List<Account> list = accMapper.selectByPermission();
        System.out.println(list);

        PageHelper.startPage(pageNumber,pageSize);
        AccountExample accountExample = new AccountExample();
        List<Account> accountList = accMapper.selectByExample(accountExample);
        PageInfo<Account> accountPageInfo = new PageInfo<>(accountList,5);
        return accountPageInfo;
    }

    public Result deleteById(Integer id) {

        int deleteByIdNumber = accMapper.deleteByPrimaryKey(id);
        return Result.buildOkResult(deleteByIdNumber);
    }

    public void update(Account account) {
        accMapper.updateByPrimaryKeySelective(account);
    }
}
