package com.huanjava.taobao.user.api;

import com.huanjava.taobao.user.entity.Result;
import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户账号相关的controller
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */
@RequestMapping("/account/")
public interface AccountApi {

    /**
     * 登录链接
     *
     * @return 登录页面
     */
    @RequestMapping("login")
    String login(Model model);

    @RequestMapping("profile")
    String profile();


    /**
     * 验证登录信息
     *
     * @param loginName 用户名
     * @param password  用户密码
     * @param request   HttpServletRequest
     * @return 操作结果
     */
    @RequestMapping("validataAccount")
    @ResponseBody
    String validataAccount(String loginName, String password, HttpServletRequest request);

    /**
     * 退出登录
     *
     * @param request HttpServletRequest
     * @return 退出登录
     */
    @RequestMapping("logOut")
    String logOut(HttpServletRequest request, Model model);

    /**
     * 查询账户列表
     *
     * @param model 数据模型
     * @return list界面
     */
    @RequestMapping("list")
    String list(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "1") int pageSize);

    /**
     * 根据用户的id删除用户
     *
     * @param id 用户id
     * @return 操作结果
     */
    @RequestMapping("deleteById")
    @ResponseBody
    Result deleteById(Integer id);

    /**
     * 上传文件的controller
     *
     * @param filename 文件名
     * @param password 用户密码
     * @return 上传的结果
     */
    @RequestMapping("fileUploadController")
    String fileUpload(MultipartFile filename, String password, HttpServletRequest request);

}












