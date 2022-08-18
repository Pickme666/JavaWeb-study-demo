package Ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * AJAX (Asynchronous JavaScript And XML)：异步的 JavaScript 和 XML 。<p>
 * 1. 与服务器进行数据交换：通过AJAX可以给服务器发送请求，服务器将数据直接响应回给浏览器 </p>
 * 2. 异步交互：可以在不重新加载整个页面的情况下，与服务器交换数据并更新部分网页的技术，
 */

@WebServlet(name = "Ajax", value = "/ajaxServ")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //响应Ajax页面的请求
        response.getWriter().write("Hello Ajax");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
