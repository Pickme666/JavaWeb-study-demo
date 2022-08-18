package com.mapper;

import com.pojo.User;
import java.util.List;

/**
 * Mapper代理开发
 * sql映射文件 UserMapper.xml 对应的 Mapper 接口
 * Mapper接口和SQL映射文件要放置在同一目录下
 */

public interface UserMapper {

    //方法对应映射的sql (id="selectAll") , 设置方法返回类型为List集合
    List<User> selectAll();
}
