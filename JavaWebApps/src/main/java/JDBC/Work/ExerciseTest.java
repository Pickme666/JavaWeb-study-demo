package JDBC.Work;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 * JDBC工作步骤 <p>
 * 1.获取Connection <p>
 * 2.定义SQL语句 (不必要) <p>
 * 3.获取PrepareStatement对象 <p>
 * 4.设置参数 (不必要) <p>
 * 5.执行SQL <p>
 * 6.处理结果 (不必要) <p>
 * 7.释放资源
 */

public class ExerciseTest {
    static final String ptah = "E:\\IDEA_Java\\JavaWeb\\src\\main\\java\\JDBC\\Work\\Exercise.properties";

    //查询
    @Test
    public void testBrand() throws Exception {
        //配置数据库连接池
        Properties pro =  new Properties();
        pro.load(new FileInputStream(ptah));
        DataSource data = DruidDataSourceFactory.createDataSource(pro);
        //获取Connection
        Connection conn = data.getConnection();
        //定义SQL语句 (不必要)
        String sql = "select * from tb_brand";
        //获取PrepareStatement对象
        PreparedStatement pres = conn.prepareStatement(sql);
        //执行SQL
        ResultSet rs = pres.executeQuery();
        //处理结果
        ArrayList<Brand> arr = new ArrayList<>();
        Brand b;
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            b = new Brand();
            b.setId(id);
            b.setBrandName(brandName);
            b.setCompanyName(companyName);
            b.setOrdered(ordered);
            b.setDescription(description);
            b.setStatus(status);

            arr.add(b);
        }
        for (Brand brand : arr) System.out.println(brand);
        //释放资源
        conn.close();
    }

    //添加
    @Test
    public void TestCURD() throws Exception {

        //需求
        String brand_name = "kunkun";
        String company_name = "kunkun偶像练习生有限公司";
        int ordered = 10;
        String description = "唱, 跳, rap, 篮球";
        int status = 0;

        Properties pro = new Properties();
        pro.load(new FileInputStream(ptah));
        DataSource data = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = data.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status)" +
                " values(?,?,?,?,?)";

        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1,brand_name);
        prep.setString(2,company_name);
        prep.setInt(3,ordered);
        prep.setString(4,description);
        prep.setInt(5,status);

        //执行SQL
        int sum = prep.executeUpdate();
        //打印执行结果
        System.out.println(sum > 0);

        conn.close();
    }
}
