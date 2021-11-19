package com.mybatis.service.Impl;

import com.mybatis.io.Resource;
import com.mybatis.pojo.User;
import com.mybatis.service.UserService;
import com.mybatis.sqlSession.SqlSession;
import com.mybatis.sqlSession.SqlSessionFactory;
import com.mybatis.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class UserServiceImpl implements UserService {
  @Override
  public List<User> findAll() throws PropertyVetoException, DocumentException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {


    InputStream resource = Resource.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<User> userList = sqlSession.selectList("user.selectList");
    for (User user1 : userList) {
      System.out.println(user1);
    }
    return userList;
  }

  @Override
  public User findByCondition(User user) throws PropertyVetoException, DocumentException, IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
    InputStream resource = Resource.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User userOne = sqlSession.selectOne("user.selectOne", user);

    System.out.println(userOne);
    return userOne;

  }
}
