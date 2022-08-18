package mvc.mapper;

import mvc.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 用户登录案例
 * mapper 接口
 */

public interface UserMapper {

    List<User> selectAll();

    @Select("select * from login where name = #{name} and password = #{password}")
    User selectUser(@Param("name")String name, @Param("password")String password);

    @Select("select * from login where name = #{name}")
    User selectName(String name);

    @Insert("insert into login values (null, #{name}, #{password}, #{phone})")
    int add(User user);
}
