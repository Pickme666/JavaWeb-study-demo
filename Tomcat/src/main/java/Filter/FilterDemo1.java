package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 多个过滤器形成过滤器链
 */

@WebFilter(filterName = "Filter1", value = "/jsp/hello_jsp.jsp")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //放行前，对request请求数据进行处理
        System.out.println("2.Filter 执行过滤");

        //放行，可以访问资源或到下一个过滤器
        chain.doFilter(request,response);

        //放行后，对response响应数据进行处理
        System.out.println("3.Filter 访问完成");
    }

    @Override
    public void destroy() {

    }
}