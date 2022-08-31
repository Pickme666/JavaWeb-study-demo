package JDBC.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据库连接池 <p>
 * 标准接口: DataSource。
 * 数据库连接池是个容器，负责分配、管理数据库连接 (Connection), 类似于线程池，它允许应用程序重复使用一个现有的数据库连接，
 * 而不是再重新建立一个。并可以释放空闲时间超过最大空闲时间的数据库连接来避免连接遗漏 (连接遗漏: 因为没有释放数据库连接而导致)。<p>
 * 使用数据库连接池的好处: 资源重用, 提升系统响应速度, 避免数据库连接遗漏。<p>
 * 常见的数据库连接池有: DBCP, C3P0, Druid (德鲁伊), 现在使用最多的是Druid, 性能更好
 * 在以后的开发中可以不需要通过 DriverManager 获取Connection对象，而是通过连接池 DataSource 来获取。
 */

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        //Druid数据连接池的用法
        //先导入对应的jar包 druid-1.1.12, 定义好配置文件

        //加载配置文件 druid.properties
        String path = "E:\\IDEA_Java\\JavaWeb\\src\\main\\java\\JDBC\\DataSource\\druid.properties";
        Properties prop = new Properties();
        prop.load(new FileInputStream(path));

        //获取连接池对象
        DataSource data = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接对象
        Connection conn = data.getConnection();

        System.out.println(conn);

        conn.close();

        //打印当前模块路径
        System.out.println(System.getProperty("user.dir"));
    }

    /*  数据库连接池配置文件
        driverClassName=com.mysql.jdbc.Driver  注册驱动
        url=jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true  连接参数
        username=root   数据库账户
        password=123456 数据库账户密码
        initialSize=5   初始化连接数量
        maxActive=10    最大连接数
        maxWait=3000    最大等待时间
    */
}
