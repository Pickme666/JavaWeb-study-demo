package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC <p>
 * JDBC (java数据库连接) 就是使用java语言操作关系数据库的一套API <p>
 * JDBC定义了一套操作所有关系型数据库的规则, 即接口
 */

public class JDBC_Demo {
    public static void main(String[] args) throws Exception {

        //JDBC的用法
        //先导入对应关系数据库的驱动jar包

        //注册驱动 (可省略)
        Class.forName("com.mysql.jdbc.Driver");

        //连接参数
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        //数据库Url (协议)，形式为 jdbc:mysql://ip地址(域名):端口号/数据库名称?配置参数1&配置参数2
        //配置 useSSL=false 参数, 禁用安全连接方式, 解决安全警告, 列: jdbc:mysql:///db1?useSSL=false
        String username = "root";  //数据库用户
        String password = "123456";  //密码

        //获取数据库连接, 传参
        Connection conn = DriverManager.getConnection(url, username, password);

        //获取sql语句执行对象
        Statement stmt = conn.createStatement();

        //执行sql语句, 返回执行结果 (受影响的行数)
        int count = stmt.executeUpdate("UPDATE jdbc SET money = 2000;");

        //打印执行结果
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();
    }
}
