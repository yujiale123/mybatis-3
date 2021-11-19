package com.mybatis.sqlSession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public interface SqlSession {

  /**
   * 查询所有
   *
   * @param statementId
   * @param params
   * @param <E>
   * @return
   */
  public <E> List<E> selectList(String statementId, Object... params) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException;

  /**
   * 查询单个
   *
   * @param statementId
   * @param params
   * @param <T>
   * @return
   */
  public <T> T selectOne(String statementId, Object... params) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException;

}
