package JDBC.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ResultSet 接口
 * 表示数据库执行结果集的数据表，通常通过执行查询数据库的语句生成。
 * 遍历结果集, ResultSet对象中维护一个指向当前数据行的游标。最初光标定位在第一行之前。
 * 每执行一次next()方法游标标将会移动到下一行，当ResultSet对象中没有更多行时，则返回false，
 */

public class ResultSetDemo {
    public static void main(String[] args) throws Exception {

        //建立连接获取执行对象Statement
        Statement stat = DriverManager.getConnection(
                "jdbc:mysql:///db1","root","123456").createStatement();

        //返回受影响的行数, 执行成功也可能返回0, 通常用于执行DML, DDL语句
        int sum = stat.executeUpdate("insert into jdbc(name,money) values('歌姬',2800);");
        System.out.println(sum);

        //返回ResultSet结果集对象, 通常执行DQL语句
        ResultSet rs = stat.executeQuery("select * from jdbc");
        //默认情况下，每个Statement对象只能打开一个ResultSet对象 (详细看官方文档)

        //遍历查询结果
        while (rs.next()) {

            //获取当前数据行对应列的值
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.print(id + "\t");
            System.out.print(name + "\t");
            System.out.println(money);

            System.out.println("-------------------------------");
        }

        rs.close();
        stat.close();

    }
}
