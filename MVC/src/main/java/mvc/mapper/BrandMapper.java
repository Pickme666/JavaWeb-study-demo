package mvc.mapper;

import mvc.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    @Select("select * from mvc_brand")
    @ResultMap("brandResultMap") //使用字段映射名称
    List<Brand> selectAll();

    @Insert("insert into mvc_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int add(Brand brand);

    @Select("select * from mvc_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Update("update mvc_brand set " +
            "brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} " +
            "where id = #{id}")
    int update(Brand brand);

    @Delete("delete from mvc_brand where id = #{id}")
    int delete(int id);
}
