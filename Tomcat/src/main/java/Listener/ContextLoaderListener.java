package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listener 表示监听器，是 JavaWeb 三大组件(Servlet、Filter、Listener)之一。<p>
 * 监听器可以监听就是在 application，session，request 三个对象创建、销毁或者往其中添加修改删除属性时自动执行代码的功能组件。<p>
 * ServletContext 代表整个web应用，在服务器启动的时候，tomcat会自动创建该对象。在服务器关闭时会自动销毁该对象。
 */

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener 监听器：ServletContext 对象创建时会自动执行此方法");
        //加载资源

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listener 监听器：ServletContext 对象销毁时会自动执行此方法");
        //释放资源

    }
}
