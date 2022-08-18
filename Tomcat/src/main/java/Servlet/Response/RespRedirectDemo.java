package Servlet.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Response请求重定向  <p>
 * 一种资源跳转方式, 可以跳转到任意网页  <p>
 * 请求重定向的特点:
 * <ul>
 *     <li>浏览器地址栏路径发送变化, 当进行重定向访问的时候，由于是由浏览器发送的两次请求，所以地址会发生变化</li>
 *     <li>可以重定向到任何位置的资源(服务内容、外部均可), 因为第一次响应结果中包含了浏览器下次要跳转的路径，所以这个路径是可以任意位置资源。</li>
 *     <li>有两次请求和响应，且不能在多个资源使用request共享数据, 因为浏览器发送了两次请求，是两个不同的request对象，就无法通过request对象进行共享数据</li>
 * </ul>
 */

@WebServlet(name = "Response1", value = "/redirect")
public class RespRedirectDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response请求重定向");

        //设置响应状态码
        response.setStatus(302);
        //设置响应头和重定向地址 (服务内容、外部资源均可)
        response.setHeader("location", "https://www.4399.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求重定向简化版
        //response.sendRedirect("/tomcat_demo/html/req.html");

        //动态获取虚拟目录, 重新定向需要加上虚拟目录
        String path = request.getContextPath();
        response.sendRedirect(path + "/html/tomcat.html");

        /* 路径问题
            虚拟目录是运行web应用程序的webapp上下文路径, 可以在pom.xml文件中tomcat插件的<path>标签配置
            浏览器使用: 需要加虚拟目录 (运行web应用程序的路径)
            服务端使用: 不需要加虚拟目录
        */
    }
}
