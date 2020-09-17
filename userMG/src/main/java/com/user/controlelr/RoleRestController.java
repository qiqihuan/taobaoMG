package com.user.controlelr;

import com.user.entity.Result;
import com.user.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * restful风格URI的controller
 * 只和用户交换json数据
 * </p>
 *
 * @author:wells
 * @since:2020/9/12
 */
@RestController
@RequestMapping("/api/v1/manager/role/")
public class RoleRestController {

    @Autowired
    RoleService roleService;

    /**
     * 修改角色中的数据
     * @param permissionIds 赋予当前角色的权限
     * @param id 当前角色的id
     * @param name 当前角色的名字
     * @return 修改当前角色的结果
     */
    @RequestMapping("update")
    public Result update(@RequestParam int[] permissionIds,Integer id,@RequestParam String name){
        int count = roleService.addPermission(id,name,permissionIds);
        return Result.buildOkResult(count);
    }

}







