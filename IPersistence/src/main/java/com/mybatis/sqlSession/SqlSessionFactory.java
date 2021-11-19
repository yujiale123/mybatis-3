package com.mybatis.sqlSession;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public interface SqlSessionFactory {

  /**
   * 打开会话
   * @return
   */
  public SqlSession openSession();
}
