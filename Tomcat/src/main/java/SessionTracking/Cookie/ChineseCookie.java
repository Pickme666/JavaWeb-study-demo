package SessionTracking.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Cookie不能存储中文数据，否则会报错，我们可以用到URL编码工具对中文数据编码后在存储
 */

@WebServlet(name = "Cookie2", value = "/cnCookie")
public class ChineseCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cookie存储中文数据");

        //要存储的中文数据
        String value = "张三";

        //对中文进行URL编码
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据："+value);

        //将编码后的值存入Cookie中
        Cookie cookie = new Cookie("username",value);

        //设置存活时间
        cookie.setMaxAge(60*60);

        //2. 发送Cookie
        resp.addCookie(cookie);
    }
}
