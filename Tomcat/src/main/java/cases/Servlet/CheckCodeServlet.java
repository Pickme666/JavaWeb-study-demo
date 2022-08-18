package cases.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import cases.util.CheckCodeUtil;

/**
 * 用户登录案例，此Servlet用于生成验证码，存储验证码数据
 */

@WebServlet(name = "UserCheckCode", value = "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //生成验证码图片和数据
        ServletOutputStream outputStream = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(80, 40, outputStream, 4);

        System.out.println(checkCode);

        //将验证码数据存储到Session
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",checkCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
