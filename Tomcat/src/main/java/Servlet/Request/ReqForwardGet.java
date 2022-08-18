package Servlet.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Request请求转发 接收数据
 */

@WebServlet(name = "Request2", value = "/get")
public class ReqForwardGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收数据, 根据数据名称获取数据值
        Object msg = req.getAttribute("msg");
        System.out.println("/get 接收到了数据\n" + msg);

        //删除request域中的数据
        req.removeAttribute("msg");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
