package com;

import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p> MyBatis </p>
 * MyBatis是一款优秀的持久层框架，用于简化JDBC开发, 官网：<a href="https://mybatis.org/mybatis-3/zh/index.html">https://mybatis.org/mybatis-3/zh/index.html</a>
 * JavaEE三层架构：表现层、业务层、持久层, 持久层负责将数据到保存到数据库的那一层代码。
 *
 * <p> 从 SqlSessionFactory 中获取 SqlSession </p>
 * 每个基于MyBatis的应用都是以一个 SqlSessionFactory 的实例为核心的。该实例可以通过 SqlSessionFactoryBuilder 获得。
 * SqlSessionFactoryBuilder可以从XML配置文件或一个预先配置的 Configuration 实例来构建出SqlSessionFactory实例。
 * 有了SqlSessionFactory我们就可以从中获得 SqlSession 的实例。
 * SqlSession提供了在数据库执行SQL命令所需的所有方法。可以通过SqlSession实例来直接执行已映射的SQL语句
 */

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {

        //加载MyBatis的核心配置文件, 获取 SqlSessionFactory 对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象来执行sql
        SqlSession session = sqlSessionFactory.openSession();

        //执行sql, 该方法的 (String var1) 参数会匹配映射文件中sql对应的名称空间(namespace)和id
        List<User> user = session.selectList("com.mapper.UserMapper.selectAll");
        //selectList() 方法会返回一个List集合来保存结果集

        for (User u : user) System.out.println(u);

        session.close();
        inputStream.close();
    }
}
