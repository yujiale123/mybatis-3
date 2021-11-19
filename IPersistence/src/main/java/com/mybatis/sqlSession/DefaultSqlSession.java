package com.mybatis.sqlSession;

import com.mybatis.pojo.Configuration;
import com.mybatis.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class DefaultSqlSession implements SqlSession {

  private Configuration configuration;

  public DefaultSqlSession(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public <E> List<E> selectList(String statementId, Object... params) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
    //将要完成对simpleExecutor里的query方法调用
    simpleExecutor simpleExecutor = new simpleExecutor();
    MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
    List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
    return (List<E>) list;
  }

  @Override
  public <T> T selectOne(String statementId, Object... params) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {

    List<Object> objects = selectList(statementId, params);
    if (objects.size() == 1) {
      return (T) objects.get(0);
    } else {
      throw new RuntimeException("查询结果为空或者返回结果过多");
    }
  }

  @Override
  public <T> T getMapper(Class<?> mapperClass) {
    //使用jdk动态代理为service接口生成代理对象，并返回


    Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
      /**
       *
       * @param proxy 当前代理对象的应用
       * @param method 当前被调用方法的引用
       * @param args 传递的参数
       * @return
       * @throws Throwable
       */
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //底层还是去执行JDBC代码
        //准备参数1、statementId：sql语句的唯一标识：namespace.id
        //方法名
        String name = method.getName();
        String className = method.getDeclaringClass().getName();
        String statementId = className + "." + name;
        //参数2、params：args
        //获取被调用方法返回值类型
        Type genericReturnType = method.getGenericReturnType();
        //判断是否进行了范型类型参数化
        if (genericReturnType instanceof ParameterizedType) {
          List<Object> list = selectList(statementId, args);
          return list;
        }
        return selectOne(statementId, args);
      }
    });
    return (T) proxyInstance;
  }
}
