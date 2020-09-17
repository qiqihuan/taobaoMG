package com.user.controlelr;

import com.user.entity.Permission;
import com.user.entity.Result;
import com.user.service.impl.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/v1/manager/permission/")
public class ManagerRestController {

    @Autowired
    PermissionService perService;

    /**
     * 添加权限
     * @param permission 用户提交的权限的数据
     * @return 添加的结果
     */
    @RequestMapping("add")
    public Result add(@RequestBody Permission permission) {
        int updateCount = perService.add(permission);
        return Result.buildOkResult(updateCount);
    }

    /**
     * 修改权限
     * @param permission 权限的新数据
     * @return 修改结果
     */
    @RequestMapping("update")
    public Result update(@RequestBody Permission permission) {
        int updateCount = perService.update(permission);
        return Result.buildOkResult(updateCount);
    }

}







