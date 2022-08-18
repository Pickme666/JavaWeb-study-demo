package SessionTracking.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Session：服务端会话跟踪技术，将数据保存到服务端 <p>
 * Session是存储在服务端而Cookie是存储在客户端，存储在客户端的数据容易被窃取和截获，
 * 存在很多不安全的因素，存储在服务端的数据相比于客户端来说就更安全 <p>
 * Session是基于Cookie实现的，浏览器请求时，服务端会发送一个包含 Session id 的Cookie，在同一次会话中，
 * 服务端会根据浏览器Cookie中的Session id来获取对应Session中的数据 <p>
 * JavaEE中提供了HttpSession接口，来实现一次会话的多次请求之间数据共享功能。
 * HttpSession提供方法可用于在多个页面请求或访问Web站点时识别用户，并存储有关该用户的信息。<p>
 * Session钝化与活化： <p>
 * &emsp;   钝化：在服务器正常关闭后，Tomcat会自动将Session数据写入硬盘的文件中 </p>
 * &emsp;   活化：再次启动服务器后，从文件中加载数据到Session中 <p>
 * session的销毁：浏览器关闭后会销毁Session；默认无操作30分钟后自动销毁，可以修改失效时间；
 * 调用Session对象的 invalidate() 方法手动销毁
 */

@WebServlet(name = "Session", value = "/session")
public class SessionServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("存储Session");

        //获取Session对象
        HttpSession session = request.getSession();

        //查看获取的Session对象是否为同一个
        System.out.println(session);

        //存储数据
        session.setAttribute("userdata","芜湖");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
