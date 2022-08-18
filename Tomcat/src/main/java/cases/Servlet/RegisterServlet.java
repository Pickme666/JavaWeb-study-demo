package cases.Servlet;

import cases.mapper.UserMapper;
import cases.pojo.User;
import cases.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录案例
 * 注册 Servlet
 */

@WebServlet(name = "UserRegister", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();*/
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //获取Session中存储的验证码数据
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");

        //获取请求参数值
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String userCheckCode = request.getParameter("checkCode");

        //判断用户名格式
        if (name.equals("")) {
            writer.println("用户名格式错误，请重新输入");
            return;
        }

        //查询并判断用户名是否存在
        User username = mapper.selectName(name);
        if (username != null) {
            writer.println("用户名已存在，请重新输入");
            return;
        }

        //判断密码格式
        if (password.equals("")) {
            writer.println("密码格式错误，请重新输入");
            return;
        }

        //判断验证码是否正确，不区分大小写
        if (!userCheckCode.equalsIgnoreCase(checkCode)) {
            writer.println("验证码错误");
            return;
        }

        //执行添加
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        int affect = mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
        writer.println(affect > 0 ? "注册成功，请返回登录页面 <a href='/tomcat_war/html/login.html'>登录</a>" : "注册失败，系统出现问题");
    }
}
