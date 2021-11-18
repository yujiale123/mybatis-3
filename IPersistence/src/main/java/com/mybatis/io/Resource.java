package com.mybatis.io;

import java.io.InputStream;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/18
 */
public class Resource {
  /**
   * 根据配置文件的路径，将配置文件加载到字节输入流，存储到内存中
   *
   * @param path
   * @return
   */
  public static InputStream getResourceAsStream(String path) {
    InputStream resource = Resource.class.getClassLoader().getResourceAsStream(path);
    return resource;
  }
}
