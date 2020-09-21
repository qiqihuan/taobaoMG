package com.user.controlelr;

import com.github.pagehelper.PageInfo;
import com.user.entity.Account;
import com.user.entity.Config;
import com.user.entity.Permission;
import com.user.entity.Role;
import com.user.service.impl.AccountService;
import com.user.service.impl.PermissionService;
import com.user.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 用户账号相关的controller
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */

@Controller
@RequestMapping("/manager/")
public class ManagerController {

    @Autowired
    AccountService accService;

    @Autowired
    PermissionService perService;

    @Autowired
    RoleService roService;


    @Autowired
    Config config;


    /**
     * 分页查询账户
     * @param model 模型
     * @param pageNumber 页码
     * @param pageSize 每一页的大小
     * @return 账户分页界面
     */
    @RequestMapping("accountList")
    public String accountList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize) {
        PageInfo<Account> pageInfo = accService.findPage(pageNumber, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "manager/accountList";
    }

    /**
     * 权限列表
     * @param model 模型
     * @param pageNumber 页码
     * @param pageSize 每页数量
     * @return 权限页面
     */
    @RequestMapping("permissionList")
    public String permissionList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize) {
        PageInfo<Permission> pageInfo = perService.findPage(pageNumber, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "manager/permissionList";
    }

    /**
     * 修改权限的页面
     * @param model 将需要修改的权限的旧数据放入到模型中
     * @param id 当前权限的id
     * @return 修改权限的页面
     */
    @RequestMapping("permissionModify")
    public String permissionModify(Model model, int id) {

        Permission permission = perService.findById(id);
        model.addAttribute("permission",permission);
        return "manager/permissionModify";
    }

    /**
     * 添加权限
     * @return 添加权限的页面
     */
    @RequestMapping("permissionAdd")
    public String permissionAdd() {
        return "manager/permissionModify";
    }


    /**
     * 分页查询角色列表
     * @param model 数据模型对象，将分页数据放入到model中
     * @param pageNumber 页码
     * @param pageSize 每一页的大小
     * @return 角色列表页面
     */
    @RequestMapping("roleList")
    public String roleList(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "6") int pageSize) {
        PageInfo<Role> pageInfo = roService.findPage(pageNumber, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "manager/roleList";
    }

    /**
     * 修改角色
     * @param model 模型对象，将当前角色的旧数据和权限列表放到里面
     * @param id 需要修改的角色的id
     * @return 修改角色的页面
     */
    @RequestMapping("roleModify")
    public String roleModify(Model model,int id){
        // 查出来当前角色
        Role role = roService.findById(id);
        // 查出来所有的权限列表
        List<Permission> permissionList = perService.findAll();
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "manager/roleModify";
    }

    /**
     * 添加角色
     * @return 添加角色的页面
     */
    @RequestMapping("roleAdd")
    public String roleAdd(){
        return "manager/roleModify";
    }


}












