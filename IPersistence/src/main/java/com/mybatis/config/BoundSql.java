package com.mybatis.config;

import com.mybatis.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class BoundSql {

  //解析过后的sql
  private String sql;
  private List<ParameterMapping> parameterMappingList = new ArrayList<>();

  public BoundSql(String sql, List<ParameterMapping> parameterMappingList) {
    this.sql = sql;
    this.parameterMappingList = parameterMappingList;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public List<ParameterMapping> getParameterMappingList() {
    return parameterMappingList;
  }

  public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
    this.parameterMappingList = parameterMappingList;
  }
}
