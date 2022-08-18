package SessionTracking.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Cookie：客户端会话技术，将数据保存到客户端，以后每次请求都携带Cookie数据进行访问。<P>
 * 浏览器发送请求给服务端，服务端会把Cookie对象中的数据存储在浏览器内存中（数据最大为3KB），
 * 此时浏览器和服务端就建立了一次会话，在同一次会话中浏览器再次发送请求给服务端时，会携带Cookie对象中的所有数据 <p>
 *
 * Cookie的实现原理是基于HTTP协议的，其中设计到HTTP协议中的两个请求头信息: <p>
 * &emsp;   响应头: set-cookie </p>
 * &emsp;   请求头: cookie <p>
 *
 * Cookie的存活时间：默认情况下，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁，
 * 使用 setMaxAge(int seconds) 方法可以设置Cookie的存活时间 <p>
 *
 * Cookie分为发送Cookie和获取Cookie，此Servlet为发送Cookie
 */

@WebServlet(name = "Cookie", value = "/cookie")
public class CookieServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发送Cookie");

        //创建Cookie对象，设置要发送的数据
        Cookie cookie = new Cookie("name","ikun");

        /*设置Cookie的存活时间, 参数值为:
            1.正数：将Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除 (单位：秒)
            2.负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则Cookie被销毁
            3.零：删除对应Cookie
         */
        cookie.setMaxAge(60*60*24); //24小时

        //发生Cookie到客户端，使用的是response对象
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
