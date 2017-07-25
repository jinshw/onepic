package com.ykkj.weiyi.filter;


import com.ykkj.weiyi.common.StaticUtils;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jinshw on 2015/11/13.
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        //基于http协议的servlet

        //如果没有登录.
        String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/", 1), req.getRequestURI().length());


        // 设置session
       /* SysUser user = new SysUser();
        user.setUserName("jinshw@163.com");
        user.setUserId("BD353140A7A84D9C9C7AEB1CD0709CE4");
        HttpSession sn = req.getSession();
        user.setWorkSpace(1);// 设置个人工作空间
        sn.setAttribute("CUR_USER", user);*/

        //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面，注册页面，首页就不去检查.
        if ( !"/page/homedoctor/staticpage/reg.html".equals(requestURI)//用户注册
                && !"/page/homedoctor/staticpage/login.html".equals(requestURI)//验证登录
                ) {
            //取得session. 如果没有session则自动会创建一个, 我们用false表示没有取得到session则设置为session为空.
            HttpSession session = req.getSession(false);
            //如果session中没有任何东西.
            if (session == null ) {
//            if (session == null || session.getAttribute(StaticUtils.CURRENT_USERDOCTORAPP) == null) {
                //判断是不是ajax请求
//                if (req.getHeader("x-requested-with") != null
//                        && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
//                    res.setStatus(300); //打回到登录页面
//                    return;
//                } else {
                    res.sendRedirect(req.getContextPath() + "/page/homedoctor/staticpage/login.html");
                    //返回
                    return;
//                }


            }

        }
        //session中的内容等于登录页面, 则可以继续访问其他区资源.
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
