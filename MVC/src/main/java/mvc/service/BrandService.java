package mvc.service;

import mvc.mapper.BrandMapper;
import mvc.pojo.Brand;
import mvc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

/**
 * 业务逻辑层 Service
 * 处理各种业务逻辑
 */

public class BrandService {

    SqlSessionFactory sqlSessionFactory =  SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public int add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int affect =  mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
        return affect;
    }

    public int update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int affect = mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
        return affect;
    }

    public int delete(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int affect = mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return affect;
    }
}
