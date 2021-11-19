package com.mybatis.test;

import com.mybatis.io.Resource;
import com.mybatis.pojo.User;
import com.mybatis.sqlSession.SqlSession;
import com.mybatis.sqlSession.SqlSessionFactory;
import com.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class IPersistenceTest {

  public void Test() throws Exception {
    InputStream resource = Resource.getResourceAsStream("sqlMapConfig.xml");

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User user = new User();
    user.setId(1);
    user.setUsername("张三");
    User userOne = sqlSession.selectOne("user.selectOne", user);

    System.out.println(userOne);


    List<User> userList = sqlSession.selectList("user.selectList", );

    for (User user1 : userList) {
      System.out.println(user1);
    }
  }


  public static void main(String[] args) {

  }
}
