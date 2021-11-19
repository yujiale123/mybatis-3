package com.mybatis.config;

import com.mybatis.pojo.Configuration;
import com.mybatis.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class XmlMapperBuilder {

  private Configuration configuration;

  public XmlMapperBuilder(Configuration configuration) {
    this.configuration = configuration;
  }

  public void parse(InputStream inputStream) throws DocumentException {
    Document document = new SAXReader().read(inputStream);
    Element rootElement = document.getRootElement();
    List<Element> list = rootElement.selectNodes("//select");
    String namespace = rootElement.attributeValue("namespace");
    for (Element element : list) {
      String id = element.attributeValue("id");
      String resultType = element.attributeValue("resultType");
      String parameterType = element.attributeValue("parameterType");
      String textTrim = element.getTextTrim();
      MappedStatement mappedStatement = new MappedStatement();
      mappedStatement.setId(id);
      mappedStatement.setParameterType(parameterType);
      mappedStatement.setResultType(resultType);
      mappedStatement.setSql(textTrim);
      String key = namespace + "." + id;
      configuration.getMappedStatementMap().put(key, mappedStatement);
    }
  }
}
