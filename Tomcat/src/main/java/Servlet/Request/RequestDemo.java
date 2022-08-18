package Servlet.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * request 请求对象 <P>
 * 用于获取请求数据的对象, 浏览器会发送HTTP请求到后台服务器[Tomcat],
 * HTTP的请求中会包含很多请求数据[请求行+请求头+请求体],
 * 后台服务器[Tomcat]会对HTTP请求中的数据进行解析并把解析结果存入到一个对象中,
 * 所存入的对象即为request对象，所以我们可以从request对象中获取请求的相关参数,
 * 获取到数据后就可以继续后续的业务，比如获取用户名和密码就可以实现登录操作的相关业务 <p>
 *
 * request 继承体系 <p>
 * ServletRequest --> HttpServletRequest --> RequestFacade
 */

@WebServlet(name = "Request", value = "/req")
public class RequestDemo extends HttpServlet {

    /**
     * get请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------------------------------------------------------");

        //获取请求行数据, 请求行包含三块内容，分别是请求方式、请求资源路径、HTTP协议及版本

        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        //获取运行web应用程序的路径 <path>/tomcat_demo</path> (虚拟访问目录)
        String path = req.getContextPath();
        System.out.println(path);

        //获取URL(统一资源定位符)
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        //获取URI(URL的一部分, 统一资源标识符)
        String uri = req.getRequestURI();
        System.out.println(uri);

        //获取请求参数 (GET方式)
        String query = req.getQueryString();
        System.out.println(query);

        //获取请求头数据,  user-agent 为浏览器的版本信息
        String header = req.getHeader("user-agent");
        System.out.println(header);

    }

    /**
     * post请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 获取请求体数据 (post请求参数)
            GET请求是没有请求体的，所以要用到doPost方法获取(post)请求体
            Request对象提供了两种方式来获取请求体中的数据:
                * 字节输入流，如果前端发送的是字节数据，比如传递的是文件数据，则使用该方式
                * 字符输入流，如果前端发送的是纯文本数据，则使用该方式
        */

        //获取字符输入流
        BufferedReader reader = req.getReader();

        //读取数据
        System.out.println("post请求参数: " + reader.readLine());
    }
}
