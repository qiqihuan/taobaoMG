package com.huanjava.taobao.user.controlelr;

import com.huanjava.taobao.user.api.ManagerApi;
import com.huanjava.taobao.user.api.ManagerRestApi;
import com.huanjava.taobao.user.entity.Permission;
import com.huanjava.taobao.user.entity.Result;
import com.huanjava.taobao.user.service.impl.PermissionService;
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
public class ManagerRestController implements ManagerRestApi {

    @Autowired
    PermissionService perService;

    /**
     * 添加权限
     * @param permission 用户提交的权限的数据
     * @return 添加的结果
     */
    @Override
    public Result add(@RequestBody Permission permission) {
        int updateCount = perService.add(permission);
        return Result.buildOkResult(updateCount);
    }

    /**
     * 修改权限
     * @param permission 权限的新数据
     * @return 修改结果
     */
    @Override
    public Result update(@RequestBody Permission permission) {
        int updateCount = perService.update(permission);
        return Result.buildOkResult(updateCount);
    }

}







