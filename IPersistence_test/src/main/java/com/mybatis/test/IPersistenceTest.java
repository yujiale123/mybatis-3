package com.mybatis.test;

import com.mybatis.io.Resource;

import java.io.InputStream;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class IPersistenceTest {

  public void Test(){
    InputStream resource = Resource.getResourceAsStream("sqlMapConfig.xml");
  }


  public static void main(String[] args) {

  }
}
