import com.mybatis.io.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/21
 */
public class MybatisTest {

  /**
   * 传统方式
   */
  public void test01() throws Exception{

    //1、读取配置文件，读取成字节输入流，还没有解析  Mybatis初始化解析
    InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
    //2、解析配置文件，把结果封装成Configuration对象，创建DefaultSqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //3、执行SQL流程解析 生产了DefaultSqlSessionFactory对象，设置了事务不自动提交，完成executor对象的创建
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //4、selectList底层分析
    //4.1、根据statementId从Configuration中map集合中获取指定的MappedStatement对象
    //4.2、将查询任务委托给executor执行器
    List<Object> selectList = sqlSession.selectList("namespace,id");

  }

  /**
   * 基于mapper代理方式
   */
  public void test02() throws Exception{
    InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
  }
}
