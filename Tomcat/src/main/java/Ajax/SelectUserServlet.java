package Ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 使用Ajax实现前后端分离
 */

@WebServlet(name = "Ajax1", value = "/ajaxSelect")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收前端用户名
        String username = request.getParameter("username");

        //调用Service查询用户名是否存在，此为模拟业务逻辑处理
        boolean boole = true;
        System.out.println("true 用户名已存在");

        //响应处理数据给前端
        response.getWriter().write("" + boole);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
