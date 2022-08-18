package mvc.web.servlet.brand_crud;

import com.alibaba.fastjson.JSON;
import mvc.pojo.Brand;
import mvc.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 添加数据 Servlet
 */

@WebServlet(name = "add", value = "/add")
public class AddServlet extends HttpServlet {
    BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取post请求体数据
        BufferedReader reader = request.getReader();
        String addData = reader.readLine();
        //将JSON字符串数据转换为java对象 Brand
        Brand brand = JSON.parseObject(addData, Brand.class);

        /* request.getParameter() 不能接收JSON数据
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));*/

        int affect = service.add(brand);
        System.out.println(affect > 0 ? "添加成功" : "error");
        if (affect > 0) {
            //响应添加结果数据
            response.getWriter().write("1");
            System.out.println("添加成功");
        } else System.out.println("error");

        //请求重定向
        //response.sendRedirect(request.getContextPath() + "/selectAll");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
