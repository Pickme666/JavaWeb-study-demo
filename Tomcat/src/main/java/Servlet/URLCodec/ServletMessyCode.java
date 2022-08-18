package Servlet.URLCodec;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 解决 Tomcat7 中文乱码问题 <p>
 * Tomcat8版本以下使用的是iso-8859-1编码格式对URL进行解码, ISO-8859-1编码是不支持中文的，所以会出现乱码
 */

@WebServlet(name = "UrlCodec", value = "/codec")
public class ServletMessyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get请求解决乱码");

        //获取参数值
        String userText = request.getParameter("userText");
        System.out.println("解决乱码前: " + userText);

        //解决乱码 (通用解决方式)
        byte[] bytes = userText.getBytes(StandardCharsets.ISO_8859_1);
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("解决乱码后: " + s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求解决乱码");

        //适用于post请求的解决中文乱码方式

        //重写此请求正文中使用的字符编码, 这个方法必须在读取请求参数或使用getReader()读取输入之前调用, 否则没有效果。
        request.setCharacterEncoding("UTF-8");

        //获取参数值
        String userText = request.getParameter("userText");
        System.out.println(userText);
    }
}
