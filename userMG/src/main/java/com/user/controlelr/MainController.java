package com.user.controlelr;

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
public class MainController {



    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/index")
    public String index1(){
        return "index";
    }


    @RequestMapping("/errorPage")
    public String errorPage(){
        return "/errorPage";
    }


}












