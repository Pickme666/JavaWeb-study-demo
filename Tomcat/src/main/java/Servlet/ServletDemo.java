package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet <p>
 * Servlet是运行在Web服务器或应用服务器上的程序, 可以接收并响应来自Web客户机的请求。<p>
 * 当客户端重浏览器发出请求时, Web服务器会根据请求的URL找到对应的Servlet类并实例化该类调用它的方法 <p>
 *
 * Servlet生命周期 <p>
 * Servlet运行在Servlet容器(web服务器)中，其生命周期由容器来管理，分为4个阶段：<p>
 * 1. 加载和实例化：默认情况下，当Servlet第一次被访问时，由容器创建Servlet对象 <p>
 * 2. 初始化：在Servlet实例化之后，容器将调用Servlet的init()方法初始化这个对象，
 *    完成一些如加载配置文件、创建连接等初始化的工作。该方法只调用一次 <p>
 * 3. 请求处理：每次请求Servlet时，Servlet容器都会调用Servlet的service()方法对请求进行处理 <p>
 * 4. 服务终止：当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放。
 *    在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收
 */

/* @WebServlet 用于声明servlet的注解
    value 和 urlPatterns 属性可以配置Servlet的URL, 一个Servlet可以配置多个URL
    loadOnStartup 属性可以配置servlet的加载-启动顺序, 参数取值(默认值-1):
        * 负整数: 第一次访问时创建Servlet对象
        * 0或正整数: 服务器启动时创建Servlet对象, 数值越小优先级越高
*/
@WebServlet("/demo")  //配置Servlet的URL
public class ServletDemo implements Servlet { //定义一个类实现Servlet接口

    //init() 初始化方法只会在第一次请求时被调用, 只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("good Servlet demo");
    }

    //service() 提供服务方法，每次请求，都会调用该方法
    //ServletRequest参数封装的是请求数据，ServletResponse参数封装响应数据，通过这两个参数可以实现前后端的数据交互
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet, this is iKun server");
    }

    //destroy() 当Servlet被销毁时会调用该方法, 释放占用的资源和这个Servlet实例, 只会执行一次
    @Override
    public void destroy() {
        System.out.println("清理占用资源");
    }

    //返回一个ServletConfig对象, 该对象为servlet配置对象，servlet容器使用它在初始化期间向servlet传递信息。
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //返回有关servlet的信息，例如作者、版本和版权。
    @Override
    public String getServletInfo() {
        return null;
    }

}
