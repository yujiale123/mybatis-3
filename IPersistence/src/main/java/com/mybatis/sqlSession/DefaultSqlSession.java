package com.mybatis.sqlSession;

import com.mybatis.pojo.Configuration;
import com.mybatis.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class DefaultSqlSession implements SqlSession {

  private Configuration configuration;

  public DefaultSqlSession(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public <E> List<E> selectList(String statementId, Object... params) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
    //将要完成对simpleExecutor里的query方法调用
    simpleExecutor simpleExecutor = new simpleExecutor();
    MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
    List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
    return (List<E>) list;
  }

  @Override
  public <T> T selectOne(String statementId, Object... params) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {

    List<Object> objects = selectList(statementId, params);
    if (objects.size() == 1) {
      return (T) objects.get(0);
    } else {
      throw new RuntimeException("查询结果为空或者返回结果过多");
    }
  }
}
