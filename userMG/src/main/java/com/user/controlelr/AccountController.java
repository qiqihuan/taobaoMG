package com.user.controlelr;

import com.github.pagehelper.PageInfo;
import com.user.entity.Account;
import com.user.entity.Config;
import com.user.entity.Result;
import com.user.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 用户账号相关的controller
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */

@Controller
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    AccountService accService;

    @Autowired
    Config config ;

    /**
     * 登录链接
     * @return 登录页面
     */
    @RequestMapping("login")
    public String login(Model model) {
        model.addAttribute("config",config);
        return "/account/login";
    }

    @RequestMapping("profile")
    public String profile () {
        return "/account/profile";
    }


    /**
     * 验证登录信息
     * @param loginName 用户名
     * @param password 用户密码
     * @param request HttpServletRequest
     * @return 操作结果
     */
    @RequestMapping("validataAccount")
    @ResponseBody
    public String validataAccount(String loginName, String password, HttpServletRequest request) {

        System.out.println(loginName);
        System.out.println(password);
        Account account = accService.findByLoginNameAndPassword(loginName, password);
        if (account == null)
            return "登录失败";

        request.getSession().setAttribute("account", account);

        return "success";
    }

    /**
     * 退出登录
     * @param request HttpServletRequest
     * @return 退出登录
     */
    @RequestMapping("logOut")
    public String logOut(HttpServletRequest request, Model model){
       request.getSession().removeAttribute("account");
        model.addAttribute("config",config);
        return "/account/login";

    }

    /**
     * 查询账户列表
     * @param model 数据模型
     * @return list界面
     */
    @RequestMapping("list")
    public String list(Model model, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "1") int pageSize){

        PageInfo pageInfo = accService.findPage(pageNumber, pageSize);

        model.addAttribute("pageInfo",pageInfo);

       return "/account/list";

    }

    /**
     * 根据用户的id删除用户
     * @param id 用户id
     * @return 操作结果
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(Integer id){

        return accService.deleteById(id);
    }

    /**
     * 上传文件的controller
     * @param filename 文件名
     * @param password 用户密码
     * @return 上传的结果
     */
    @RequestMapping("fileUploadController")
    public String fileUpload (MultipartFile filename, String password, HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        try {

            filename.transferTo(new File(config.getUploadPath()+"/"+filename.getOriginalFilename()));

            account.setPassword(password);
            account.setLocation(filename.getOriginalFilename());

            accService.update(account);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "/account/profile";
    }

}












