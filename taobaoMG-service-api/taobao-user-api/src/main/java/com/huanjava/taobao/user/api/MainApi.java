package com.huanjava.taobao.user.api;

import io.swagger.annotations.Api;
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
public interface MainApi {

    @RequestMapping("/")
    String index();

    @RequestMapping("/index")
    String index1();


    @RequestMapping("/errorPage")
    String errorPage();


}












