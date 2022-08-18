package SessionTracking.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 获取Session中的数据
 */

@WebServlet(name = "Session1", value = "/getSession")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取Session");

        //获取Session对象
        HttpSession session = request.getSession();

        //查看获取的Session对象是否为同一个
        System.out.println(session);

        //获取数据
        Object userdata = session.getAttribute("userdata");
        System.out.println(userdata);

        //销毁会话中的Session对象（可用于注销登录需求）
        //session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
