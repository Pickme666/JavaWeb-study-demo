package casus;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis案例练习
 */

public class MyBatisTest {

    /**
     * 配置环境
     */
    static SqlSession session;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            //session = sqlSessionFactory.openSession(true); 设置自动提交事务, true 自动提交, false 手动提交 (默认为false)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    BrandMapper brandMapper = session.getMapper(BrandMapper.class);

    /**
     * 查询所有数据
     */
    @Test
    public void selectAllTest() {
        List<Brand> brands = brandMapper.selectAll();
        for (Brand b : brands) System.out.println(b);
    }

    /**
     * 查询详细
     */
    @Test
    public void selectByIdTest() {
        int id = 4;  //查询参数
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
    }

    /**
     * 动态多条件查询
     */
    @Test
    public void selectByConditionTest() {

        //查询参数
        Integer status = null;
        String companyName = "华为";
        //String brandName = "华为";
        String brandName = null;
        //如果有参数为null, 则不能查出数据, 所以要使用动态多条件查询
        //SQl语句会随着用户的输入或外部条件的变化而变, 称之为动态SQL

        //模糊查询参数处理
        if (companyName != null && companyName != "") companyName = "%" + companyName + "%";
        if (brandName != null && brandName != "") brandName = "%" + brandName + "%";

        //1.散装参数
        System.out.println("散装参数");
        List<Brand> brands1 = brandMapper.selectByCondition(status,companyName,brandName);
        for (Brand b : brands1) System.out.println(b);

        //2.实体类封装参数
        System.out.println("实体类封装参数");
        Brand bra = new Brand();
        bra.setStatus(status);
        bra.setCompanyName(companyName);
        bra.setBrandName(brandName);
        List<Brand> brands2 = brandMapper.selectByCondition(bra);
        for (Brand b : brands2) System.out.println(b);

        //3.Map集合
        System.out.println("Map集合");
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        List<Brand> brands3 = brandMapper.selectByCondition(map);
        for (Brand b : brands3) System.out.println(b);
    }

    /**
     * 单条件动态查询
     */
    @Test
    public void selectByConditionSingleTest() {
        String companyName = "kunkun";
        if (companyName != null && companyName != "") companyName = "%" + companyName + "%";

        Brand bra = new Brand();
        bra.setBrandName(companyName);
        List<Brand> brands = brandMapper.selectByConditionSingle(bra);
        for (Brand b : brands) System.out.println(b);
    }

    /**
     * 添加数据
     */
    @Test
    public void addDataTest() {
        String brandName = "菠萝手机";
        String companyName = "菠萝集团有限公司";
        Integer ordered = 999;
        String description = "美国有苹果, 中国有菠萝, 菠萝手机";
        Integer status = 1;

        Brand bra = new Brand(brandName,companyName,ordered,description,status);
        brandMapper.addData(bra);
        System.out.println(bra.getId());  //获取该数据的主键值

        //提交事务, MyBatis事务管理是默认手动提交, 可以在获取SqlSession对象的openSession()方法中设置为自动提交
        session.commit();
    }

    /**
     * 动态修改
     */
    @Test
    public void updateTest() {
        Brand bra = new Brand();
        bra.setId(9);
        bra.setCompanyName("菠萝科技股粪有限公司");
        bra.setOrdered(666);

        int sum = brandMapper.update(bra);
        System.out.println(sum > 0 ? "修改成功" : "修改失败");
        session.commit();
    }

    /**
     * 删除数据
     */
    @Test
    public void deleteByIdTest() {
        int id = 9;
        int sum = brandMapper.deleteById(id);
        System.out.println(sum > 0 ? "删除成功" : "删除失败");
        session.commit();
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteByIdBachTest() {
        int[] ids = {1,3,10};  //删除 id = 1, id = 3, id = 10 的数据
        int sum = brandMapper.deleteByIdBach(ids);
        System.out.println(sum > 0 ? "删除成功" : "删除失败");
        session.commit();
    }

    /**
     * 注解映射 select * from tb_brand where id = #{id}
     */
    @Test
    public void selectByIdNoteTest() {
        Brand brand = brandMapper.selectByIdNote(2);
        System.out.println(brand);
    }

    //此方法所有执行的单元测试方法执行完后执行
    @AfterClass
    public static void close() {
        session.close();
        System.out.println("资源已关闭");
    }
}
