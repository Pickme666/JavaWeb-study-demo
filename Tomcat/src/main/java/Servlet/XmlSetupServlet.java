package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 3.0版本之前只支持在XML文件中配置,
 * 在WEB-INF目录下的web.xml文件中配置Servlet
 */

//不需要注解标记
public class XmlSetupServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("XML文件配置Servlet");
    }
}
