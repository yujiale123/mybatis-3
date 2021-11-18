package com.mybatis.sqlSession;

import java.io.InputStream;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class SqlSessionFactoryBuilder {

  public SqlSessionFactory build(InputStream inputStream){
    //第一使用dom4j解析配置文件，将解析出来的内容封装到Configuration中

    //第二：创建SqlSessionFactory对象
  }
}
