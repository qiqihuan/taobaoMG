package com.huanjava.taobao.user.Filter;

import com.huanjava.taobao.user.entity.Account;
import com.huanjava.taobao.user.entity.Permission;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 过滤器
 * </p>
 *
 * @author:wells
 * @since:2020/9/10
 */
@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {

    // 不需要登录的uri
    private final String[] IGNORE_URI =
            {"/index","/doc.html", "/login", "/js", "/css", "/account/login", "/favicon","/images","/account/validataAccount","/errorPage"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---> 实现Filter的过滤器初始化 ");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---> 开始过滤 ");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        System.out.println("访问地址 ---> " + uri);

        // 1. 判断当前访问的uri在不在不需要验证的列表中
        if (canPassIgnoreUri(uri)) {
            // 1.1 如果在，就放行
            filterChain.doFilter(request, response);
            return;
        }
        // 1.2 如果不在，就进行下一步


        // 1. 从session里找Account
        Object accountO = request.getSession().getAttribute("account");

        // 1.1 如果找不到 -> 说明该用户没有登录
        // 1.1.1 跳转到登录页面
        if (null == accountO){
            response.sendRedirect("/account/login");
            return;
        }
        Account account = (Account)accountO;
        // 1.2 如果能找到 -> 说明该用户已经登录
        if(!hasAuth(account.getPermissionList(),uri )){
            request.setAttribute("message","您无权访问当前页面："+uri);
            request.getRequestDispatcher("/errorPage").forward(request,response);
            return;
        }

        // 1.2.1 读取当前用户可以访问的uri
        // 1.2.1.1 有权访问当前uri -> 放行
        // 1.2.1.2 无权访问当前uri -> 跳转到主页

        filterChain.doFilter(request, response);

        // 2. 判断当前访问的uri是不是在ignore列表中


        System.out.println("---> 过滤结束 ");


    }

    /**
     * 判断用户有没有访问的权限
     * @param permissionList 用户拥有的权限列表
     * @param uri 当前访问的路径
     * @return 是否有权限访问
     */
    private boolean hasAuth(List<Permission> permissionList, String uri) {

        for (Permission permission : permissionList) {
            if(uri.startsWith(permission.getUri())){
                return true;
            }
        }
        return false;
    }

    private boolean canPassIgnoreUri(String uri) {
        for (String val : IGNORE_URI) {

            if (uri.startsWith(val))
                return true;
        }
        return false;
    }

    @Override
    public void destroy() {
        System.out.println("---> 实现Filter的过滤器被销毁 ");
    }
}
