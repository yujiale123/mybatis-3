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
public interface Executor {
  /**
   * query查询
   * @param configuration
   * @param mappedStatement
   * @param params
   * @param <E>
   * @return
   */
  public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IntrospectionException, InvocationTargetException, InstantiationException;

}
