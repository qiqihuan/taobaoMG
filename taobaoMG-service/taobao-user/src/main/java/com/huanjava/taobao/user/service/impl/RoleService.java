package com.huanjava.taobao.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanjava.taobao.user.mapper.RoleExample;
import com.huanjava.taobao.user.mapper.RoleMapper;
import com.huanjava.taobao.user.entity.Role;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色的service层
 * </p>
 *
 * @author:wells
 * @since:2020/9/12
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roMapper;

    public PageInfo<Role> findPage(int pageNumber, int pageSize) {

        PageHelper.startPage(pageNumber,pageSize);

        RoleExample roleExample = new RoleExample();
        List<Role> roleList = roMapper.selectByExample(roleExample);
        return new PageInfo<Role>(roleList);
    }


    public Role findById(int id) {

        return roMapper.findById(id);
    }

    public int addPermission(int id, String name, int[] permissionIds) {
        Role role = new Role(id,name,null);
        int i = roMapper.updateByPrimaryKeySelective(role);
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("permissionIds",permissionIds);
        roMapper.addRolePermission(map);
        System.out.println(ToStringBuilder.reflectionToString(permissionIds));
        return i ;
    }
}
