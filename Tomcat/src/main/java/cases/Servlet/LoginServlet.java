package cases.Servlet;

import cases.mapper.UserMapper;
import cases.pojo.User;
import cases.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录案例
 * 登录 Servlet
 */

@WebServlet(name = "UserLogin", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //配置mybatis
        /*String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //获取请求参数值
        request.setCharacterEncoding("UTF-8");  //重新请求编码格式, 防止中文乱码
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //调用sql映射方法
        User user = mapper.selectUser(name, password);
        sqlSession.close();

        //判断是否查询到用户, 并响应对应内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (user != null) {
            writer.println("<h3>登录成功</h3>");
            writer.println("<h1>欢迎 " + user.getName() + "</h1>");
        } else {
            writer.println("<h3>登录失败</h3>");
            writer.println("用户名不存在或密码错误");
        }
    }
}
