package com.huanjava.taobao.user.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 用户账号相关的controller
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */

@RequestMapping("/manager/")
public interface ManagerApi {

    /**
     * 分页查询账户
     *
     * @param model      模型
     * @param pageNumber 页码
     * @param pageSize   每一页的大小
     * @return 账户分页界面
     */
    @RequestMapping("accountList")
    String accountList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize);

    /**
     * 权限列表
     *
     * @param model      模型
     * @param pageNumber 页码
     * @param pageSize   每页数量
     * @return 权限页面
     */
    @RequestMapping("permissionList")
    String permissionList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize);

    /**
     * 修改权限的页面
     *
     * @param model 将需要修改的权限的旧数据放入到模型中
     * @param id    当前权限的id
     * @return 修改权限的页面
     */
    @RequestMapping("permissionModify")
    String permissionModify(Model model, int id);

    /**
     * 添加权限
     *
     * @return 添加权限的页面
     */
    @RequestMapping("permissionAdd")
    String permissionAdd();


    /**
     * 分页查询角色列表
     *
     * @param model      数据模型对象，将分页数据放入到model中
     * @param pageNumber 页码
     * @param pageSize   每一页的大小
     * @return 角色列表页面
     */
    @RequestMapping("roleList")
    String roleList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize);

    /**
     * 修改角色
     *
     * @param model 模型对象，将当前角色的旧数据和权限列表放到里面
     * @param id    需要修改的角色的id
     * @return 修改角色的页面
     */
    @RequestMapping("roleModify")
    String roleModify(Model model, int id);

    /**
     * 添加角色
     *
     * @return 添加角色的页面
     */
    @RequestMapping("roleAdd")
    String roleAdd();


}












