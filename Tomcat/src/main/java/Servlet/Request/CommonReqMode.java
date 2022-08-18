package Servlet.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 通用请求方法 <p>
 * 根据请求方式不一样我们要编写不同的代码来获取请求参赛值, 这样分别处理会比较繁琐,
 * 所以Request对象提供了一种通用的获取请求参数的方式, Request对象会根据不同的请求方式分别获取不同的请求参数值，
 * 然后把获取到的参数指进行分割, 封装到一个Map集合中, 这样我们只需要从Map集合中获取参数值就行了
 */

//可以使用idea中的模板快速创建Servlet
@WebServlet(name = "Request3", value = "/Common")
public class CommonReqMode extends HttpServlet {

    String reqMet = "get请求---------------------------------------";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(reqMet);
        reqMet = "get请求---------------------------------------";

        //获取封装参数的Map集合 Map<String,String[]>
        //因为参数的值可能是一个，也可能有多个，所以Map的value的类型为String[]数组。
        Map<String, String[]> map = req.getParameterMap();

        //遍历Map集合
        map.forEach((key,value) -> System.out.println(key + ":" + Arrays.toString(value)));

        //根据名称获取参数值（数组）
        String[] choose = req.getParameterValues("choose");
        System.out.println(Arrays.toString(choose));

        //根据名称获取参数值(单个值), 以后使用的频率会比较高
        String userText = req.getParameter("userText");
        System.out.println(userText);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reqMet = "post请求---------------------------------------";

        //通用的请求方法, post请求和get请求的处理方式一样可以直接调用doGet()方法
        doGet(req,resp);
    }
}
