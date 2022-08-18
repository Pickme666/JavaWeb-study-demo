package mvc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 筛选出用户登录信息，已登录和未登录
 */

@WebFilter(filterName = "Filter", value = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("utf-8");

        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};

        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //循环判断
        for (String u : urls) {
            //如果当前请求访问的资源路径包含登录注册相关资源路径就放行
            if (url.contains(u)) {
                chain.doFilter(req,response);
                //跳出方法
                return;
            }
        }

        //获取session中的用户登录信息
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //判断是否已经登录
        if (user != null) {
            //已登录, 可以放行
            chain.doFilter(request,response);
        } else {
            //没有登录, 跳转到登录页面
            req.setAttribute("login_msg","请登录后在访问");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
