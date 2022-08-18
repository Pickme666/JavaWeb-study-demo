package mvc.web.servlet.brand_crud;

import mvc.pojo.Brand;
import mvc.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改数据 Servlet <p>
 * 修改数据分为两部分：<p>
 *      1. 回显数据：根据id查询数据显示到修改页面 </p>
 *      2. 执行修改：修改回显内容并提交
 */

@WebServlet(name = "update", value = "/update")
public class UpdateServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        int affect = service.update(brand);
        System.out.println(affect > 0 ? "修改成功" : "error");

        //请求重定向
        response.sendRedirect(request.getContextPath() + "/selectAll");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
