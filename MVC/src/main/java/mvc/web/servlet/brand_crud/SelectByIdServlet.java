package mvc.web.servlet.brand_crud;

import mvc.pojo.Brand;
import mvc.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 根据id查询 Servlet
 */

@WebServlet(name = "selectById", value = "/selectById")
public class SelectByIdServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brand = service.selectById(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
