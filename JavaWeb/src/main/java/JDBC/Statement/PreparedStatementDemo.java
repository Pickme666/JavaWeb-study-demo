package JDBC.Statement;

import java.sql.*;

/**
 * Statement 的子接口: PreparedStatement <p>
 * 在JDBC执行sql语句时要先检查语法, 再编译, 然后再执行预编译SQL, 这些步骤很耗时
 * 使用PreparedStatement执行对象预编译sql, 传入的SQL语句会被预编译并存储在PreparedStatement对象中, 这样可以更高效的多次执行
 * 预编译功能默认关闭, 需要配置参数 useServerPrepStmts=true 开启<p>
 *
 * SQL注入攻击 <p>
 * SQL注入是通过操作输入来修改事先定好的SQL语句, 用以达到执行代码对服务器进行攻击的方式
 * 使用PreparedStatement执行对象可以防止sql注入, 该对象会对敏感字符进行转义
 */

public class PreparedStatementDemo {
    static Connection conn;

    //模拟登录系统
    public static void main(String[] args) throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true", "root","123456");

        //输入的用户名和密码
        String name = "abcasj";
        String password = "3231686";
        String name1 = "ikun";
        String password1 = "123123";

        //模拟sql注入, 输入sql语句
        String inject = "' or '1' = '1";

        //登录
        login(name,password);  //失败
        login(name1,password1);  //成功
        login(name,inject);  //sql注入成功, 登录成功

        System.out.println("\n--------------------------------------------------\n");

        secureLogin(name1,password1);  //成功
        secureLogin(name,inject);  //sql注入失败, 登录失败
        // ' or '1' = '1   转义成   \' or \'1\' = \'1

        conn.close();
    }

    //普通登录
    static public void login(String name, String password) throws SQLException {

        //字符串拼接sql语句
        String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
        System.out.println(sql);

        //获取sql执行对象Statement
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        //判断是否有查询结果
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        stat.close();
    }

    //防止sql注入登录
    static public void secureLogin(String name, String password) throws SQLException {

        //用 ? 代替参数
        String sql = "select * from user where name = ? and password = ?";
        System.out.println(sql);

        //获取sql执行对象PreparedStatement, Statement的子接口
        PreparedStatement pre = conn.prepareStatement(sql);
        //创建PreparedStatement传入sql语句时就会进行预编译操作, 该操作只会进行一次

        //设置 ? 的值
        pre.setString(1, name);  //代表第一个 ?
        pre.setString(2, password);  //代表第二个 ?

        //执行sql
        ResultSet rs = pre.executeQuery();

        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        pre.close();
    }
}