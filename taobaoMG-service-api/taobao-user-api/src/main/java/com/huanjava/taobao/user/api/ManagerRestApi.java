package com.huanjava.taobao.user.api;

import com.huanjava.taobao.user.entity.Permission;
import com.huanjava.taobao.user.entity.Result;
import io.swagger.annotations.Api;
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
@Api(value = "添加修改权限", tags = "添加修改权限")
@RequestMapping("/api/v1/manager/permission/")
public interface ManagerRestApi {

    /**
     * 添加权限
     *
     * @param permission 用户提交的权限的数据
     * @return 添加的结果
     */
    @RequestMapping("add")
    Result add(@RequestBody Permission permission);

    /**
     * 修改权限
     *
     * @param permission 权限的新数据
     * @return 修改结果
     */
    @RequestMapping("update")
    Result update(@RequestBody Permission permission);
}