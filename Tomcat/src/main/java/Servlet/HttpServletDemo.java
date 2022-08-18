package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet <p>
 * 对HTTP协议封装的Servlet实现类, HttpServlet会调用 getMethod() 方法获取HTTP的请求方式,
 * 对获取到的请求方式进行判断, 不同的请求方式调用不同的方法 <p>
 * 基于HTTP协议定义的Servlet都要继承HttpServlet并重写一些方法
 */

@WebServlet(name = "Servlet", value = "/httpServ")
public class HttpServletDemo extends HttpServlet {

    //当HTTP的请求方式为get时, 会调用此方法 (http协议的请求方式默认为get)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get请求");
    }

    //当HTTP的请求方式为post时, 会调用此方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post请求");
    }


}
