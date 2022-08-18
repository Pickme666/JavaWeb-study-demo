package JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Jsp", value = "/jspServ")
public class JspServlet extends HttpServlet {

    static List<Brand> brands;

    static {
        brands = new ArrayList<>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //存储数据到request域中
        request.setAttribute("brands", brands);

        //请求转发到 el.jsp
        request.getRequestDispatcher("/jsp/el.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //JSTL
        int status = 1;
        request.setAttribute("status",status);
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/jsp/jstl.jsp").forward(request,response);
    }
}
