package mvc.web.servlet.brand_crud;

import mvc.service.BrandService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 根据id删除 Servlet
 */

@WebServlet(name = "delete", value = "/delete")
public class DeleteServlet extends HttpServlet {
    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int affect = service.delete(id);
        System.out.println(affect > 0 ? "删除成功" : "");
        request.getRequestDispatcher("/selectAll").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
