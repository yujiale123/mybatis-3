package com.mybatis.sqlSession;

import com.mybatis.config.XmlConfigBuilder;
import com.mybatis.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class SqlSessionFactoryBuilder {

  public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {
    //第一使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
    XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
    Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
    //第二：创建SqlSessionFactory对象 工厂类：主要生产sqlSession回话对象
    DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);

    return sqlSessionFactory;
  }
}
