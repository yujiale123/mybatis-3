package com.mybatis.sqlSession;

import com.mybatis.pojo.Configuration;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

  private Configuration configuration;

  public DefaultSqlSessionFactory(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public SqlSession openSession() {
    return new DefaultSqlSession(configuration);
  }
}
