package Servlet.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Request请求转发 <p>
 * 一种在服务器内部的资源跳转方式, 在服务器资源转发请求之前,
 * 会将数据存入request域对象中, 可以在转发多个资源之间共享数据。<p>
 * 请求转发的特点:
 * <ul>
 *     <li>浏览器地址栏路径不发生变化</li>
 *     <li>只能转发到当前服务器的内部资源, 不能从一个服务器通过转发访问另一台服务器</li>
 *     <li>只会有一次请求和响应，可以在转发资源间使用request共享数据</li>
 * </ul>
 */

@WebServlet(name = "Request1", value = "/relay")
public class ReqForwardDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/relay 请求转发数据");

        //存储数据到request域中
        req.setAttribute("msg","你鸡太美");

        //请求转发到 /get
        req.getRequestDispatcher("/get").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
