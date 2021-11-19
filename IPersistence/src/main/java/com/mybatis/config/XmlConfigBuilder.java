package com.mybatis.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mybatis.io.Resource;
import com.mybatis.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class XmlConfigBuilder {

  private Configuration configuration;

  public XmlConfigBuilder() {
    this.configuration = new Configuration();
  }

  /**
   * 使用dom4j对配置文件进行解析，封装Configuration
   *
   * @param inputStream
   * @return
   */
  public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {
    Document document = new SAXReader().read(inputStream);
    Element rootElement = document.getRootElement();
    //对数据库xml解析
    List<Element> list = rootElement.selectNodes("//property");
    Properties properties = new Properties();
    for (Element element : list) {
      String name = element.attributeValue("name");
      String value = element.attributeValue("value");
      properties.setProperty(name, value);
    }
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
    comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
    comboPooledDataSource.setUser(properties.getProperty("username"));
    comboPooledDataSource.setPassword(properties.getProperty("password"));
    configuration.setDataSource(comboPooledDataSource);
    //对mapper.xml解析
    List<Element> listMapper = rootElement.selectNodes("//mapper");
    for (Element element : listMapper) {
      String mapperPath = element.attributeValue("resource");
      InputStream resourceAsStream = Resource.getResourceAsStream(mapperPath);
      XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);
      xmlMapperBuilder.parse(resourceAsStream);
    }
    return configuration;
  }

}
