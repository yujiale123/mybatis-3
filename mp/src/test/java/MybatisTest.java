import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.mybatis.mp.User;
import com.mybatis.mp.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
public class MybatisTest {

  @Test
  public void test1() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<User> all = mapper.findAll();
    for (User user : all) {
      System.out.println(user);
    }
  }

  @Test
  public void test2() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//这⾥使⽤的是MP 中的MybatisSqlSessionFactoryBuilder
    SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//可以调⽤BaseMapper中定义的⽅法
    List<User> all = mapper.selectList(null);
    for (User user : all) {
      System.out.println(user);
    }
  }
}
