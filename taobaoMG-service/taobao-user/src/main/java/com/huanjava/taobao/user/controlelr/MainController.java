package com.huanjava.taobao.user.controlelr;

import com.huanjava.taobao.user.api.MainApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 明哥权限管理系统控制层
 * </p>
 *
 * @author:wells
 * @since:2020/9/9
 */
@Controller
public class MainController implements MainApi {


    @Override
    public String index(){

        return "index";
    }

    @Override
    public String index1(){
        return "index";
    }


    @Override
    public String errorPage(){
        return "/errorPage";
    }


}












