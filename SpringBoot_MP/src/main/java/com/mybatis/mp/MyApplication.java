package com.mybatis.mp;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@MapperScan("com.mybatis.mp.mapper") //设置 mapper 接⼝的扫描包
@SpringBootApplication
public class MyApplication {
  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
  }
}
