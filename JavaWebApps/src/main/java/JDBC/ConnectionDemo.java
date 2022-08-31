package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection 接口 <p>
 *      1.建立数据库的连接(会话), 执行SQL语句并返回结果在连接的上下文中。 <p>
 *      2.创建SQL执行对象，用于向数据库发送SQL语句。 <p>
 *      3.提供JDBC事务管理方法 <p>
 *
 * Statement 接口 <p>
 *      用于执行静态SQL语句并返回其产生的结果的对象。
 */

public class ConnectionDemo {
    public static void main(String[] args) throws SQLException {

        //创建连接和执行对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1","root","123456");
        Statement stat = conn.createStatement();

        //使用 try catch 异常机制实现事务管理
        try {

            //开启事务
            conn.setAutoCommit(false);  //参数: true 自动提交; false 手动提交, 即为开启事务管理

            int sum1 = stat.executeUpdate("UPDATE jdbc SET money = 648 where name = '张三';");
            System.out.println(sum1);

            //int a = 1/0;  //模拟执行错误

            int sum2 = stat.executeUpdate("UPDATE jdbc SET money = 9999 where name = '李四';");
            System.out.println(sum2);

            //提交事务
            conn.commit();
        } catch (Exception e) {

            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }

        stat.close();
        conn.close();
    }
}
