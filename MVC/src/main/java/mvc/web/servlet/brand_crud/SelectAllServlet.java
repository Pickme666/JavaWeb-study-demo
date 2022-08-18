package mvc.web.servlet.brand_crud;

import com.alibaba.fastjson.JSON;
import mvc.pojo.Brand;
import mvc.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有 Servlet
 */

@WebServlet(name = "selectAll", value = "/selectAll")
public class SelectAllServlet extends HttpServlet {
    BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();

        //JSON, 将集合转换为json数据 (序列化)
        String jsonString = JSON.toJSONString(brands);
        System.out.println(jsonString);
        //响应数据, 设置类型为 text/json
        response.setContentType("text/json;charset=utf-8");
        //获取字符输出流, 向客户端写入json数据
        response.getWriter().write(jsonString);

        /* JSP
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("/brand.jsp").forward(request,response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
