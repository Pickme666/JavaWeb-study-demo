package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter 表示Web过滤器（筛选器），是 JavaWeb 三大组件(Servlet、Filter、Listener)之一，
 * 过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能。<p>
 * Filter 执行流程：执行放行前逻辑 -> 放行 -> 访问资源 -> 执行放行后逻辑 <p>
 * 在一个Web应用中，可以配置多个过滤器，这多个过滤器称为过滤器链，多个过滤器的优先级是按照过滤器类名字符串的自然排序进行划分。
 */

/*
    定义Web过滤器需要实现 Filter 接口并在类上用 @WebFilter 注解标记，设置拦截资源路径，拦截路径有如下四种配置方式：
        拦截具体的资源：/index.jsp 只有访问index.jsp时才会被拦截
        目录拦截：/user/* 访问/user下的所有资源，都会被拦截
        后缀名拦截：*.jsp 访问后缀名为jsp的资源，都会被拦截
        拦截所有：/* 访问所有资源，都会被拦截
*/
@WebFilter(filterName = "Filter", value = "/jsp/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //放行前，对request请求数据进行处理
        System.out.println("1.Filter 执行过滤");

        //放行，可以访问资源或到下一个过滤器
        chain.doFilter(request,response);

        //放行后，对response响应数据进行处理
        System.out.println("4.Filter 访问完成");
    }

    @Override
    public void destroy() {

    }
}
