package com.mybatis.sqlSession;

import com.mybatis.config.BoundSql;
import com.mybatis.pojo.Configuration;
import com.mybatis.pojo.MappedStatement;
import com.mybatis.utils.GenericTokenParser;
import com.mybatis.utils.ParameterMapping;
import com.mybatis.utils.ParameterMappingTokenHandler;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class simpleExecutor implements Executor {
  @Override
  public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, IntrospectionException, InvocationTargetException, InstantiationException {
    // 1. 注册驱动，获取连接
    Connection connection = configuration.getDataSource().getConnection();

    // 2. 获取sql语句 : select * from user where id = #{id} and username = #{username}
    //转换sql语句： select * from user where id = ? and username = ? ，转换的过程中，还需要对#{}里面的值进行解析存储
    String sql = mappedStatement.getSql();
    BoundSql boundSql = getBoundSql(sql);

    // 3.获取预处理对象：preparedStatement
    PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSql());

    // 4. 设置参数
    //获取到了参数的全路径
    String parameterType = mappedStatement.getParameterType();
    Class<?> parameterTypeClass = getClassType(parameterType);

    List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
    for (int i = 0; i < parameterMappingList.size(); i++) {
      ParameterMapping parameterMapping = parameterMappingList.get(i);
      String content = parameterMapping.getContent();

      //反射
      Field declaredField = parameterTypeClass.getDeclaredField(content);
      //暴力访问
      declaredField.setAccessible(true);
      Object o = declaredField.get(params[0]);
      preparedStatement.setObject(i + 1, o);

    }

    // 5. 执行sql
    ResultSet resultSet = preparedStatement.executeQuery();
    String resultType = mappedStatement.getResultType();
    Class<?> resultTypeClass = getClassType(resultType);

    ArrayList<Object> objects = new ArrayList<>();

    // 6. 封装返回结果集
    while (resultSet.next()) {
      Object o = resultTypeClass.newInstance();
      //元数据
      ResultSetMetaData metaData = resultSet.getMetaData();
      for (int i = 1; i <= metaData.getColumnCount(); i++) {

        // 字段名
        String columnName = metaData.getColumnName(i);
        // 字段的值
        Object value = resultSet.getObject(columnName);

        //使用反射或者内省，根据数据库表和实体的对应关系，完成封装
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(o, value);


      }
      objects.add(o);

    }
    return (List<E>) objects;
  }

  private Class<?> getClassType(String paramterType) throws ClassNotFoundException {
    if (paramterType != null) {
      Class<?> aClass = Class.forName(paramterType);
      return aClass;
    }
    return null;

  }

  /**
   * 完成对#{}的解析工作
   * 1、将#{}使用？代替
   * 2、解析出#{}里面的值进行存储
   *
   * @param sql
   * @return
   */
  private BoundSql getBoundSql(String sql) {
    //标记处理类：配置标记解析器来完成对占位符的解析处理工作
    ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
    GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
    //解析出来的sql
    String parseSql = genericTokenParser.parse(sql);
    //#{}里面解析出来的参数名称
    List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
    BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
    return boundSql;
  }

}
