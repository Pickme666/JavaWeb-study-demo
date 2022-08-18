package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
 * MyBatis案例练习
 */

public interface BrandMapper {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 查询详细
     */
    Brand selectById(Integer id);

    /**
     * 单条件动态查询
     */
    List<Brand>selectByConditionSingle(Brand brand);

    /**
     * 动态多条件查询<p>
     * 1.散装参数: 要使用@Param("SQL中的参数占位符名称")<p>
     * 2.实体类封装参数: 需SQL中的参数名和实体类属性名对应<p>
     * 3.Map集合: 需SQL中参数名和map集合的键key对应<p>
     * <p>
     * MyBatis 参数传递机制<p>
     * MyBatis接口方法中可以接收各种各样的参数, MyBatis底层使用 ParamNameResolver 类对这些参数进行不同的处理<p>
     * 多个参数: 当有多个参数时会将这些参数封装成 Map 集合对象，值就是参数值，而键在没有使用 @Param 注解时有以下命名规则：
     * <blockquote><pre>
     *      map.put("arg0"，参数值1);
     *      map.put("arg1"，参数值2);
     *      map.put("param1"，参数值1);
     *      map.put("param2"，参数值2);
     * </pre></blockquote>
     * 单个参数：单个参数时又可以是如下类型
     * <blockquote><pre>
     *      POJO 类型
     *      Map 集合类型
     *      Collection 集合类型
     *      List 集合类型
     *      Array 类型
     *      其他类型
     * </pre></blockquote>
     * POJO 类型:
     * 直接使用。要求 属性名 和 参数占位符名称 一致
     * Map 集合类型
     * 直接使用。要求 map集合的键名 和 参数占位符名称 一致<p>
     * Collection 集合类型
     * Mybatis 会将集合封装到 map 集合中，如下：
     * map.put("arg0"，collection集合);
     * map.put("collection"，collection集合;
     * 可以使用 @Param 注解替换map集合中默认的 arg 键名。<p>
     * List 集合类型:
     * Mybatis 会将集合封装到 map 集合中，如下：
     * map.put("arg0"，list集合);
     * map.put("collection"，list集合);
     * map.put("list"，list集合);
     * 可以使用 @Param 注解替换map集合中默认的 arg 键名。<p>
     * Array 类型:
     * Mybatis 会将集合封装到 map 集合中，如下：
     * map.put("arg0"，数组);
     * map.put("array"，数组);
     * 可以使用 @Param 注解替换map集合中默认的 arg 键名。<p>
     * 其他类型:
     * 比如int类型， 参数占位符名称 叫什么都可以。尽量做到见名知意
     * <p><p>
     * 建议：将来都使用@Param注解来修改Map集合中默认的键名, 并使用修改后的名称来获取值, 这样代码的可读性更高。
     */
    //散装参数
    List<Brand> selectByCondition(
            @Param("status") Integer status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName
    );

    //实体类封装参数
    List<Brand> selectByCondition(Brand brand);

    //Map集合
    List<Brand> selectByCondition(Map map);

    /**
     * 添加数据
     */
    void addData(Brand brand);

    /**
     * 动态修改
     */
    int update(Brand brand);

    /**
     * 删除数据
     */
    int deleteById(Integer id);

    /**
     * 批量删除
     */
    int deleteByIdBach(int[] ids); //传入一个id值int数组

    /**
     * 当写一些简单的SQL语句时, 使用注解映射会比XML配置更方便, SQL语句可以直接写在注解里, 不用在XML文档中配置<p>
     * 常用注解映射:
     *      @Select 查询
     *      @Insert 添加
     *      @Update 修改
     *      @Delete 删除
     */
    @Select("select * from tb_brand where id = #{id}")
    Brand selectByIdNote(Integer id);
}
