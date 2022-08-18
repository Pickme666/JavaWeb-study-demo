package com;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p> Mapper代理开发 </p>
 * 调用 selectList() 方法传递的参数是映射配置文件中的 namespace.id 值。这样写也不便于后期的维护。
 * 使用MyBatis的 Mapper 代理方式可以解决原生方式中的硬编码, 简化后期执行SQL和维护
 *
 * <p> 使用Mapper代理要求 </p>
 *      1.定义与SQL映射文件同名的Mapper接口，并且将Mapper接口和SQL映射文件放置在同一目录下<p>
 *      2.设置SQL映射文件的namespace属性为Mapper接口全限定名<p>
 *      3.在 Mapper 接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致<p>
 */

public class MapperProxyDemo {
    public static void main(String[] args) throws IOException {

        ////加载MyBatis的核心配置文件, 获取 SqlSessionFactory 对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //调用selectAll()方法, 执行对应映射的sql
        List<User> user = userMapper.selectAll();

        for (User u : user) System.out.println(u);

        session.close();
        inputStream.close();
    }
}
