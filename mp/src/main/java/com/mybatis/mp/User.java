package com.mybatis.mp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
