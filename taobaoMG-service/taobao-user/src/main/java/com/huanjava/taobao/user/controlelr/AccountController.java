package com.huanjava.taobao.user.controlelr;

import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.huanjava.taobao.user.api.AccountApi;
import com.huanjava.taobao.user.entity.Account;
import com.huanjava.taobao.user.entity.Config;
import com.huanjava.taobao.user.entity.Result;
import com.huanjava.taobao.user.service.impl.AccountService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 用户账号相关的controller
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */

@Controller
public class AccountController implements AccountApi {

    @Autowired
    AccountService accService;

    @Autowired
    Config config ;

    @Autowired
    FastFileStorageClient fc;

    /**
     * 登录链接
     * @return 登录页面
     */
    @Override
    public String login(Model model) {
        model.addAttribute("config",config);
        return "/account/login";
    }

    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    @ResponseBody
    public Result deleteById(Integer id){

        return accService.deleteById(id);
    }

    /**
     * 使用fdfs-client客户端上传文件到fdfs
     * 上传文件的controller
     * @param filename 文件名
     * @param password 用户密码
     * @return 上传的结果
     */
    @Override
    public String fileUpload (MultipartFile filename, String password, HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");

        Set<MetaData> metaDataSet = new HashSet<MetaData>();
        metaDataSet.add(new MetaData("Author","qiqh"));
        metaDataSet.add(new MetaData("CreateDate", LocalDate.now().toString()));

        try {
            StorePath uploadFile = fc.uploadFile(filename.getInputStream(), filename.getSize(), FilenameUtils.getExtension(filename.getOriginalFilename()), metaDataSet);

            account.setPassword(password);
            account.setLocation(uploadFile.getPath());

            accService.update(account);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/account/profile";
    }

    @Override
    public ResponseEntity<byte[]> fileDownLoad(){
        DownloadByteArray cb = new DownloadByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment","王老二");
        byte[] bs = fc.downloadFile("group1", "M00/00/00/wKhVC19t53qAbJYAAAFgVnVbLjw888.png",cb);
        return new ResponseEntity<>(bs,headers, HttpStatus.OK);
    }

}












