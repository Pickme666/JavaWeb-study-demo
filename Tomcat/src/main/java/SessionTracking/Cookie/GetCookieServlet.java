package SessionTracking.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * 此Servlet为获取Cookie
 */

@WebServlet(name = "Cookie1", value = "/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取Cookie");

        //获取客户端此次请求携带的所有Cookie，使用request对象
        Cookie[] cookies = request.getCookies();

        //遍历Cookie数组，获取每一个Cookie对象
        for (Cookie c : cookies) {

            //获取CooKie中的数据
            String name = c.getName();
            String value = c.getValue();

            //判断
            if (name.equals("username")) {
                //URL解码
                value = URLDecoder.decode(value,"utf-8");
            }

            System.out.println(name + ": " + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
