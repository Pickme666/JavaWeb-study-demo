package Servlet.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Response 响应对象 <p>
 * 用于设置响应数据的对象, 当业务处理完后，后台就需要给前端返回业务处理的结果即响应数据, 把响应数据封装到response对象中
 * 后台服务器 [Tomcat] 会解析response对象, 按照 [响应行+响应头+响应体] 格式拼接结果,
 * 浏览器会对该结果进行解析，然后把内容展示在浏览器中供用户浏览 <p>
 *
 * Response 继承体系和 Request 相似 <p>
 * ServletResponse --> HttpServletResponse --> ResponseFacade
 */

@WebServlet(name = "Response", value = "/resp")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response 响应对象, get请求");

        //HTTP响应数据总共分为三部分内容，分别是响应行、响应头、响应体

        //响应行, 设置响应状态码方法
        response.setStatus(200);  //200为正常响应

        //响应头, 设置响应头键值对
        //response.setHeader("content-type", "text/html");
        // content-type:text/html 告诉浏览器返回的数据类型是HTML类型数据，这样浏览器才会解析HTML标签

        //设置响应的数据格式及数据的编码, 可以替换setHeader()方法设置响应头
        response.setContentType("text/html;charset=utf-8");

        //响应体, 通过字符、字节输出流的方式将资源输出到浏览器
        //获取字符打印输出流, 响应字符数据
        PrintWriter writer = response.getWriter();
        writer.println("hello");
        writer.println("<h2>你干嘛, 哈哈哎呦<h2>");
        //通过response获取的流在响应结束后会自动关闭, 不用手动关闭
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response 响应对象, post请求");

        //设置响应字节数据响应体, 获取字节输出流响应字节数据
        ServletOutputStream stream = response.getOutputStream();

        //读取字节文件
        FileInputStream file = new FileInputStream(
                "E:\\IDEA_Java\\Tomcat\\src\\main\\webNote\\http响应数据.jpg");

        //将读取的本地字节数据文件拷贝到Servlet的字节输出流, 使用 IOUtils 工具完成流的拷贝
        IOUtils.copy(file,stream);

        file.close();
    }
}
