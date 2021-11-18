package com.mybatis.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class Configuration {

  private DataSource dataSource;

  /**
   * key:statementId
   * value:封装好的MappedStatement对象
   */
  Map<String,MappedStatement> mappedStatementMap=new HashMap<>();

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Map<String, MappedStatement> getMappedStatementMap() {
    return mappedStatementMap;
  }

  public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
    this.mappedStatementMap = mappedStatementMap;
  }

  @Override
  public String toString() {
    return "Configuration{" +
      "dataSource=" + dataSource +
      ", mappedStatementMap=" + mappedStatementMap +
      '}';
  }
}
