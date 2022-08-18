package Ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Axios 对原生的AJAX进行封装，简化书写。
 * Axios官网是： <a href="https://www.axios-http.cn">https://www.axios-http.cn</a>
 */

@WebServlet(name = "Axios", value = "/axios")
public class AxiosServlet extends HttpServlet {
    String ask = "Axios 的get请求";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(ask);
        ask = "Axios 的get请求";

        //获取数据
        String username = request.getParameter("username");

        //响应数据
        response.getWriter().write(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ask = "Axios 的post请求";
        this.doGet(request, response);
    }
}
